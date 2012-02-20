(ns scufl2.core
  (:use [clojure.java.io])
  (:import (uk.org.taverna.scufl2.api.io WorkflowBundleIO) 
           (uk.org.taverna.scufl2.api.common URITools Scufl2Tools)
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


(defn bundle-structure
  [bundle]
  ; FIXME: dummy structure
  '(wfbundle))

