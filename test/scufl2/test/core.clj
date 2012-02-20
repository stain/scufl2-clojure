(ns scufl2.test.core
  (:use [clojure.java.io])
  (:use [scufl2.core])
  (:use [clojure.test])
  (:import (java.io File)))


(defn helloworld []
  (read-bundle "test/helloworld.wfbundle"))

(deftest bundle-from-file
  (is (= "Hello_World" (.getName (helloworld)))))

(defn tempfile []
  (doto (File/createTempFile "test" "scufl2")
    (.delete)
    (.deleteOnExit)))

(deftest bundle-to-file
  (let [tmp (tempfile)]   
    (is (not (.exists tmp)))
    (write-bundle (new uk.org.taverna.scufl2.api.container.WorkflowBundle) tmp)
    (is (.exists tmp))))

(deftest check-structure
  (let [structure (bundle-structure (helloworld))]
    (is (= '(wfbundle) structure))))


