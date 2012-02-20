(ns scufl2.core
  (:import (uk.org.taverna.scufl2.api.io WorkflowBundleIO) 
           (uk.org.taverna.scufl2.api.common URITools Scufl2Tools)
           (java.io File)
  )
)

(println "Hello")

(def io (new WorkflowBundleIO))
(def uri (new URITools))
(def tools (new Scufl2Tools))

(def MIME-WFBUNDLE "application/vnd.taverna.scufl2.workflow-bundle")
(def MIME-T2FLOW "application/vnd.taverna.t2flow+xml")

(defn read-wfbundle 
  "Read a Scufl2 workflow bundle from given filename"
  [filename] 
  (.readBundle io (new File filename) nil))

(defn write-wfbundle 
  "Write a Scufl2 workflow bundle to given filename"
  [filename] 
  (.writeBundle io (new File filename) "application/vnd.taverna.scufl2.workflow-bundle"))


