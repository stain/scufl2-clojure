(defproject scufl2 "1.0.0-SNAPSHOT"
  :description "Scufl2 API for Clojure"
  :dependencies [
                 [org.clojure/clojure "1.3.0"]
;                 [org.clojure/clojure-contrib "1.3.0"]
                 [uk.org.taverna.scufl2/scufl2-api "0.9"]
                 [uk.org.taverna.scufl2/scufl2-rdfxml "0.9"]
                 [uk.org.taverna.scufl2/scufl2-t2flow "0.9"]

                 ;; optional
                 [com.sun.xml.bind/jaxb-impl "2.2.4-1"]

                ]
  :repositories {"mygrid-repository" "http://www.mygrid.org.uk/maven/repository/"}
)
