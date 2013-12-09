(ns fsm-monad.core-test
  (:require [clojure.test :refer :all]
            [fsm-monad.core :refer :all]))
            
(deftest nice-table-test
  (testing "fsm table for nice"
    (is (= (nice-table (first "n") 1) 2))
    (is (= (nice-table (first "i") 2) 3))
    (is (= (nice-table (first "c") 3) 4))
    (is (= (nice-table (first "e") 4) :success))
    (is (= (nice-table (first "l") 1) :error))))

(deftest odd-even-table-test
  (testing "fsm table for counting zeros"
    (is (= (odd-even-table (first "1") 1) 1))
    (is (= (odd-even-table (first "0") 1) 2))
    (is (= (odd-even-table (first "1") 2) 2))
    (is (= (odd-even-table (first "0") 2) 1))
    (is (nil? (odd-even-table (first "1") 3)))))

(deftest get-next-state-test
  (testing "function that fetches the next state"
    (is (= (get-next-state odd-even-table (first "0") 1) 2))
    (is (= (get-next-state nice-table (first "c") 3) 4))))

(deftest zero-count-test
  (testing "zero count state machine"
    (is (= "even" (zero-count "100100")))
    (is (= "odd" (zero-count "1000100010001"))))
    (is (not= "odd" (not= "even" (zero-count "0101103")))))
    
(deftest nice-test
  (testing "is a word nice"
    (is (= "This word is nice!" (just-nice "nice")))
    (is (not= "This word is nice!" (just-nice "nick")))))
