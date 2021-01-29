# Flatten Array

Take a nested list and return a single flattened list with all values except nil/null.

The challenge is to write a function that accepts an arbitrarily-deep nested list-like structure and returns a flattened structure without any nil/null values.

For Example

input: [1,[2,3,null,4],[null],5]

output: [1,2,3,4,5]

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

Interview Question [https://reference.wolfram.com/language/ref/Flatten.html](https://reference.wolfram.com/language/ref/Flatten.html)

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have completed the exercise.
