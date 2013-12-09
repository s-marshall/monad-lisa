(ns fsm-monad.core
  (:use clojure.algo.monads))

(defn nice-table [input current-state]
  (condp = [input current-state]
    [\n 1] 2
    [\i 2] 3
    [\c 3] 4
    [\e 4] :success
    :error)) 
  
(defn odd-even-table [input current-state]
  (condp = [input current-state]
    [\1 1] 1
    [\0 1] 2
    [\1 2] 2
    [\0 2] 1
    nil))

(defn get-next-state [table input current-state]
  (table input current-state))

(defn state-machine [input state fsm-table]
  ((domonad state-m
    [current-state  (set-state state)
     next-state     (update-state (partial get-next-state fsm-table input))]
    [input next-state]) state))

(defn get-fsm-state [result] (second result))
    
(defn run-machine [input state fsm-table]
  (if (> (count input) 0)
    (let [char (first input)
        result (state-machine char state fsm-table)]
      (run-machine (rest input) (get-fsm-state result) fsm-table))
    state))
    
(defn zero-count [binary-string]
  (condp = (run-machine binary-string 1 odd-even-table)
    1 "even"
    2 "odd"
    "Error: The binary string should only contain ones and zeros!"))
      
(defn just-nice [word]
  (condp = (run-machine word 1 nice-table)
    :success "This word is nice!"
    "This is not nice."))