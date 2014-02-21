(ns scufl2.core
  (:use [clojure.java.io])
  (:import (uk.org.taverna.scufl2.api.io WorkflowBundleIO) 
           (java.text SimpleDateFormat)
           (uk.org.taverna.scufl2.api.common
              URITools Scufl2Tools Visitor Visitor$VisitorWithPath)
  )
)


(def io (new WorkflowBundleIO))
(def uri (new URITools))
(def tools (new Scufl2Tools))

(def MIME-WFBUNDLE "application/vnd.taverna.scufl2.workflow-bundle")
(def MIME-T2FLOW "application/vnd.taverna.t2flow+xml")

(defn read-bundle 
  "Read a Scufl2 workflow bundle from given filename"
  [filename] 
  (.readBundle io (file filename) nil))

(defn write-bundle 
  "Write a Scufl2 workflow bundle to given filename"
  [bundle filename] 
  (.writeBundle io bundle (file filename) "application/vnd.taverna.scufl2.workflow-bundle"))

(defn as-bean [obj]
  (if (nil? obj) nil) 
    (if (map? obj) obj (bean obj)))

(defn name-of [named]
  (if (nil? named) nil
    (.getName named)))

(defn str-or-nil [obj]
  (if (nil? obj) nil (str obj)))

(defn identified-to-clj [identified] 
  { :name (.getName identified)
    :identifier (str-or-nil (. identified getIdentifier))
  }
)

(defn name-map [coll]
  (zipmap (map :name coll) coll))

(def ISO8601 (.SimpleDateFormat "yyyy-MM-dd HH:mm:ss.S z"))

(def cal-as-iso8601 [cal]
  (if (nil? cal) nil
    (. iso8601 format (. cal getTime))))

(defn revision-to-clj [revision]
  (if (nil? revision) nil
  {
    :identifier (str-or-nil (. revision getIdentifier))
    :previousRevision (revision-to-clj (.getPreviousRevision revision))
    :changeSpecificationType ((.getChangeSpecificationType revision))
    :generatedAtTime (cal-as-iso8601 (.getGeneratedAtTime revision))
  }
  )
)

(defn workflowbundle-to-clj [wfbundle]
  (merge (identified-to-clj wfbundle)
  { 
    :mainWorkflow (name-of (.getMainWorkflow wfbundle))
    :mainProfile (name-of (.getMainProfile wfbundle))
    :workflows (name-map (map identified-to-clj (.getWorkflows wfbundle)))
    :profiles (name-map (map identified-to-clj (.getProfiles wfbundle)))
    :currentRevision (revision-to-clj (.getCurrentRevision wfbundle))
  } )
)

(defn main-profile [wfbundle-struct]
  (get (:profiles wfbundle-struct) (:mainProfile wfbundle-struct)))

(defn main-workflow [wfbundle-struct]
  (get (:workflows wfbundle-struct) (:mainWorkflow wfbundle-struct)))

(defn bundle-structure [bundle]
  (workflowbundle-to-clj bundle))
