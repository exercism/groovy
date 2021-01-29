# Bank Account

Simulate a bank account supporting opening/closing, withdrawals, and deposits
of money. Watch out for concurrent transactions!

A bank account can be accessed in multiple ways. Clients can make
deposits and withdrawals using the internet, mobile phones, etc. Shops
can charge against the account.

Create an account that can be accessed from multiple threads/processes
(terminology depends on your programming language).

It should be possible to close an account; operations against a closed
account must fail.

## Instructions

Run the test file, and fix each of the errors in turn. When you get the
first test to pass, go to the first pending or skipped test, and make
that pass as well. When all of the tests are passing, feel free to
submit.

Remember that passing code is just the first step. The goal is to work
towards a solution that is as readable and expressive as you can make
it.

Have fun!

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


## Submitting Incomplete Solutions
It's possible to submit an incomplete solution so you can see how others have completed the exercise.
