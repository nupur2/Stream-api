# Stream-api

Introduced in Java 8, the Stream API is used to process collections of objects.
A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.
The features of Java stream are –

A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations can be pipeline

Different Operations On Streams-
Intermediate Operations:

map: The map method is used to returns a stream consisting of the results of applying the given function to the elements of this stream.

filter: The filter method is used to select elements as per the Predicate passed as argument.

sorted: The sorted method is used to sort the stream.

Terminal Operations:

collect: The collect method is used to return the result of the intermediate operations performed on the stream.

forEach: The forEach method is used to iterate through every element of the stream.

