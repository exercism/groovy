# Saddle Points

Detect saddle points in a matrix.

So say you have a matrix like so:

```text
    1  2  3
  |---------
1 | 9  8  7
2 | 5  3  2     <--- saddle point at column 1, row 2, with value 5
3 | 6  6  7
```

It has a saddle point at column 1, row 2.

It's called a "saddle point" because it is greater than or equal to
every element in its row and less than or equal to every element in
its column.

A matrix may have zero or more saddle points.

Your code should be able to provide the (possibly empty) list of all the
saddle points for any given matrix.

The matrix can have a different number of rows and columns (Non square).

Note that you may find other definitions of matrix saddle points online,
but the tests for this exercise follow the above unambiguous definition.

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

J Dalbey's Programming Practice problems [http://users.csc.calpoly.edu/~jdalbey/103/Projects/ProgrammingPractice.html](http://users.csc.calpoly.edu/~jdalbey/103/Projects/ProgrammingPractice.html)

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have completed the exercise.
