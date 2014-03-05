(ns scufl2.test.core
  (:use [clojure.java.io])
  (:use [scufl2.core])
  (:use [clojure.test])
  (:import (java.io File)))


(defn helloworld []
  (read-bundle "test/helloworld.wfbundle"))

(deftest read-bundle-from-file
  (is (= "Hello_World" (.getName (helloworld)))))

(defn tempfile []
  (doto (File/createTempFile "test" "scufl2")
    (.delete)
    (.deleteOnExit)))

(deftest test-write-bundle
  (let [tmp (tempfile)]   
    (is (not (.exists tmp)))
    (write-bundle (new uk.org.taverna.scufl2.api.container.WorkflowBundle) tmp)
    (is (.exists tmp))))

(deftest test-workflowbundle-to-clj
  (let [wfb (workflowbundle-to-clj (helloworld))]
    (is (= "Hello_World" (:name wfb)))
    (is (= "http://ns.taverna.org.uk/2010/workflowBundle/8781d5f4-d0ba-48a8-a1d1-14281bd8a917/" (:identifier wfb)))
    (is (= "Hello_World" (:mainWorkflow wfb)))
    (is (= '("Hello_World") (keys (:workflows wfb))))
    (is (= "taverna-2.4.0" (:mainProfile wfb)))
    (is (= '("taverna-2.4.0") (keys (:profiles wfb))))
    ))

(deftest test-main-workflow
  (let [wfb { :mainWorkflow "fred"
              :workflows {"soup" :soupWf
                          "fred" :fredWf
                          }
             }]
      (is (= :fredWf (main-workflow wfb))))
  (let [no-main { :workflows { "soup" :soup } } ]
      (is (nil? (main-workflow no-main))))
  (let [missing-main { :mainWorkflow "missing"
                       :workflows {} }]
      (is (nil? (main-workflow missing-main)))))

      

(deftest test-workflow-to-clj
  (let [wf (workflow-to-clj (.getMainWorkflow (helloworld)))]
      (is (= '() (:controlLinks wf))) 
))




