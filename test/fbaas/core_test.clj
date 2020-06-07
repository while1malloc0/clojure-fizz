(ns fbaas.core_test
  (:require [clojure.test :refer :all]
            [fbaas.core :refer :all]))

(deftest fizzbuzz
  (testing "numbers divisible by 3 but not 5 return fizz"
    (is (= (fizz-buzz 3) "fizz")))
  (testing "numbers divisible by 5 but not 3 return buzz"
    (is (= (fizz-buzz 5) "buzz")))
  (testing "numbers divisible by both 3 and 5 return fizzbuzz"
    (is (= (fizz-buzz 15) "fizzbuzz")))
  (testing "numbers not divisible by 3 or 5 return themselves"
    (is (= (fizz-buzz 1) "1"))))
