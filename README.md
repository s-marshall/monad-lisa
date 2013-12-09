# Mad About Monads

These examples use the state-m monad defined in [algo.monads](https://github.com/clojure/algo.monads) in Clojure to create simple finite state machines.

The examples can be found on the [Finite-state machine](http://en.wikipedia.org/wiki/Finite-state_machine) page in Wikipedia.

## Finite state machines

### Odd or even zero count

This finite state machine returns 1 or 2 to indicate an even or an odd number of zeros in a binary string.

![alt text](http://upload.wikimedia.org/wikipedia/commons/9/9d/DFAexample.svg "Odd/even zero count finite state machine")

| State | Input  | Next State |
|:-----:|:------:|:----------:|
| 1 | 1 | 1 |    
| 1 | 0 | 2 |
| 2 | 1 | 2 |
| 2 | 0 | 1 |
| * | * | nil |

### Nice word recognizer

This finite state machine only accepts the word "nice."

![alt text](http://upload.wikimedia.org/wikipedia/commons/a/a8/Fsm_parsing_word_nice.svg "nice finite state machine")

| State | Input  | Next State |
|:-----:|:------:|:----------:|
| 1 | n | 2 |    
| 2 | i | 3 |
| 3 | c | 4 |
| 4 | e | :success |
| * | * | :error |

## Usage

Look at the tests.

## License

Copyright © 2013 Shelley Marshall

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
