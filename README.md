# Mad About Monads

These examples use the state-m monad defined in [algo.monads](https://github.com/clojure/algo.monads) in Clojure to create simple finite state machines.

The examples can be found on the [Finite-state machine](http://en.wikipedia.org/wiki/Finite-state_machine) page in Wikipedia.

## Finite state machines

### Odd or even number of zeros detector

This finite state machine returns 1 or 2 to indicate an even or an odd number of zeros in a binary number string.

![alt text](http://upload.wikimedia.org/wikipedia/commons/9/9d/DFAexample.svg "Odd/even zero count finite state machine")

| State | Input  | Next State |
|:-----:|:------:|:----------:|
| 1 | 1 | 1 |    
| 1 | 0 | 2 |
| 2 | 1 | 2 |
| 2 | 0 | 1 |
| * | * | nil |

In this finite state machine, the state is represented by an integer, but the state can be any data structure or even a function.

You may want to know the number of zeros in addition to whether the zero count is an odd or an even number. This is easy to do by changing the data structure of the
state and modifying the table of the finite state machine.
The new representation of the state is a vector. In this vector [state zero-count], the first element is an integer that represents the state, and
the second element is an integer that represents the number of zeros. The state table of this new finite state machine that can count as well as detect odd or even is shown below.

| State | Input | Next State|
|:-----:|:-----:|:---------:|
| [1 n] | 1 | [1 n] |
| [1 n] | 0 | [2 (n + 1)] |
| [2 n] | 1 | [2 n] |
| [2 n] | 0 | [1 (n + 1)] |
| * | * | nil |

n: represents the current count and has an initial value of 0

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
