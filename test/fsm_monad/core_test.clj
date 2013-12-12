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
    (is (= (odd-even-detector-table (first "1") 1) 1))
    (is (= (odd-even-detector-table (first "0") 1) 2))
    (is (= (odd-even-detector-table (first "1") 2) 2))
    (is (= (odd-even-detector-table (first "0") 2) 1))
    (is (nil? (odd-even-detector-table (first "1") 3)))))

(deftest get-next-state-test
  (testing "function that fetches the next state"
    (is (= (get-next-state odd-even-detector-table (first "0") 1) 2))
    (is (= (get-next-state nice-table (first "c") 3) 4))))

(deftest zero-detector-test
  (testing "zero odd/even detector state machine"
    (is (= "even" (zero-detector "100100")))
    (is (= "odd" (zero-detector "1000100010001"))))
    (is (not= "odd" (not= "even" (zero-detector "0101103")))))
    
(deftest zero-detector-with-counter-test
  (testing "zero odd/even detector state machine"
    (is (= ["even" 4] (zero-detector-with-counter "100100")))
    (is (= ["odd" 9] (zero-detector-with-counter "1000100010001"))))
    (is (not= ["odd" 3] (not= "even" (zero-detector-with-counter "0101103")))))

(deftest nice-test
  (testing "is a word nice"
    (is (= "This word is nice!" (just-nice "nice")))
    (is (not= "This word is nice!" (just-nice "nick")))))
