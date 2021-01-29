# Secret Handshake

> There are 10 types of people in the world: Those who understand
> binary, and those who don't.

You and your fellow cohort of those in the "know" when it comes to
binary decide to come up with a secret "handshake".

```text
1 = wink
10 = double blink
100 = close your eyes
1000 = jump


10000 = Reverse the order of the operations in the secret handshake.
```

Given a decimal number, convert it to the appropriate sequence of events for a secret handshake.

Here's a couple of examples:

Given the input 3, the function would return the array
["wink", "double blink"] because 3 is 11 in binary.

Given the input 19, the function would return the array
["double blink", "wink"] because 19 is 10011 in binary.
Notice that the addition of 16 (10000 in binary)
has caused the array to be reversed.

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

Bert, in Mary Poppins [http://www.imdb.com/title/tt0058331/quotes/qt0437047](http://www.imdb.com/title/tt0058331/quotes/qt0437047)

## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have completed the exercise.
