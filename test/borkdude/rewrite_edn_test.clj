(ns borkdude.rewrite-edn-test
  (:require [borkdude.rewrite-edn :as r]
            [clojure.test :as t :refer [deftest is]]))

(deftest assoc-test
  (is (= "{:a 1 :b 1}"
         (str (r/assoc
               (r/parse-string "{:a 1}")
               :b 1))))
  (is (= "{:a 2}"
         (str (r/assoc
               (r/parse-string "{:a 1}")
               :a 2))))
  (is (= "{:a #_:something 2}"
         (str (r/assoc
               (r/parse-string "{:a #_:something 1}")
               :a 2))))
  (is (= "{:a 2} ;; this is a cool map"
         (str (r/assoc
               (r/parse-string "{:a 1} ;; this is a cool map")
               :a 2)))))
