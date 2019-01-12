# Scott Shrout
## Homework 1
As per assignment requirements, I implemented ILinkedList interface and created unit tests for my implementation.

Please note:  I utilized assertSame to test that two variables pointed to same memory location (as would be expected when testing the *next* member given no apparent expectation of a deep copy [though it appears assertEqual would test this as a well for a non-primitive type that does not implement the equals method]) though assertEqual was used in testing the *value* member of a node.