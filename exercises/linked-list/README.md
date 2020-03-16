# Linked List

Implement a doubly linked list.

Like an array, a linked list is a simple linear data structure. Several
common data types can be implemented using linked lists, like queues,
stacks, and associative arrays.

A linked list is a collection of data elements called *nodes*. In a
*singly linked list* each node holds a value and a link to the next node.
In a *doubly linked list* each node also holds a link to the previous
node.

You will write an implementation of a doubly linked list. Implement a
Node to hold a value and pointers to the next and previous nodes. Then
implement a List which holds references to the first and last node and
offers an array-like interface for adding and removing items:

* `push` (*insert value at back*);
* `pop` (*remove value at back*);
* `shift` (*remove value at front*).
* `unshift` (*insert value at front*);

To keep your implementation simple, the tests will not cover error
conditions. Specifically: `pop` or `shift` will never be called on an
empty list.

If you want to know more about linked lists, check [Wikipedia](https://en.wikipedia.org/wiki/Linked_list).

For installation and learning resources, refer to the
[Groovy resources page](https://exercism.io/tracks/groovy/resources).

## Setup

Go through the setup instructions for Groovy to install the necessary
dependencies:

[https://exercism.io/tracks/groovy/installation](https://exercism.io/tracks/groovy/installation)

## Making the test suite pass

We are using [Gradle](https://gradle.org/) to build and test our exercises if you have a local version of Gradle installed you can use it.
If not, we have the [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html) installed into the exercises. If you wish to use the Gradle Wrapper please make sure `gradlew` is executable on your platform beforehand.

On MacOS/Linux, please run:

```sh
$ chmod +x gradlew
```

Execute the tests with:

```sh
$ ./gradlew test
```

> Use `gradlew.bat` if you're on Windows

After the first test(s) pass, continue by commenting out or removing the `@Ignore` annotations prepending other tests.

When all tests pass, congratulations!

## Source

Classic computer science topic

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have completed the exercise.
