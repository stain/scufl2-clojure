(ns scufl2.test.core
  (:use [scufl2.core])
  (:use [clojure.test]))

(deftest read-bundle
  (is (= "Hello_World" (.getName (read-wfbundle "test/helloworld.wfbundle")))))
