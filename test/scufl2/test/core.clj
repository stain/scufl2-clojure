(ns scufl2.test.core
  (:use [clojure.java.io])
  (:use [scufl2.core])
  (:use [clojure.test])
  (:import (java.io File)))

(deftest bundle-from-file
  (is (= "Hello_World" (.getName (read-bundle "test/helloworld.wfbundle")))))

(defn tempfile []
  (doto (File/createTempFile "test" "scufl2")
    (.delete)
    (.deleteOnExit)))

(deftest bundle-to-file
  (let [tmp (tempfile)]   
    (is (not (.exists tmp)))
    (write-bundle (new uk.org.taverna.scufl2.api.container.WorkflowBundle) tmp)
    (is (.exists tmp))))

