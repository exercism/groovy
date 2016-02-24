# Getting Started

These exercises lean on Test-Driven Development (TDD), but they're not an exact match.

The following steps assume that you are in the base directory of the exercise.

## Step 1

Run the test suite. It's written using the JUnit framework, and can be run with gradle:

```sh
$ ./gradlew test
```

This will fail, complaining that there is no method called `hello` for the `HelloWorld` class.

To fix the error, open `src/main/groovy/HelloWorld.groovy` and add a `hello` method that returns a `String`.
The method can return an empty string `""` for now:

```Groovy
class HelloWorld {
  def hello(name) {
    // YOUR CODE HERE
  }
}
```

## Step 2

Run the tests again. It will give you a new error, since now the method exists, but the tests are expects the
method to accept one argument as input, a name.

The errors will look something like:

```sh
$ /gradlew test
:compileJava UP-TO-DATE
:compileGroovy
:processResources UP-TO-DATE
:classes
:compileTestJava UP-TO-DATE
:compileTestGroovy
:processTestResources UP-TO-DATE
:testClasses
:test

HelloWorldTest > testSampleName FAILED
    java.lang.AssertionError at HelloWorldTest.groovy:12

HelloWorldTest > testAnotherSampleName FAILED
    java.lang.AssertionError at HelloWorldTest.groovy:17

HelloWorldTest > testNoName FAILED
    java.lang.AssertionError at HelloWorldTest.groovy:7

3 tests completed, 3 failed
:test FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':test'.
> There were failing tests. See the report at: file:///./build/reports/tests/index.html

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.

BUILD FAILED

Total time: 6.205 secs
```

### Fixing the Error

To fix it, open `src/main/groovy/HelloWorld.groovy` and add a `name` to the method the signature:

```groovy
class HelloWorld {
  def hello(name) {
    ''
  }
}
```

Now the `hello` method accepts a `name` as an input.

### Understanding Test Failures

Test failures will either be compilation errors or test failures. So far, we've been dealing with compilation
errors. Once our test and main code successful compile, `gradle` will run the actual test suite.

## Step 3

Run the tests again. You'll notice that the gradle output passes the `:compileTestJava` phase and fails
at the `:test` phase.

The errors will look something like:

```
$ gradle test
:compileJava
:processResources UP-TO-DATE
:classes
:compileTestJava
:processTestResources UP-TO-DATE
:testClasses
:test

HelloWorldTest > helloNoName FAILED
    org.junit.ComparisonFailure at HelloWorldTest.java:9

...

3 tests completed, 3 failed
:test FAILED
```

These are actual test failures. It means that both our main and test java code is running but the test is
expecting one outcome, but getting another.

Open `src/test/groovy/HelloWorldTest.groovy` and go to line 9.

```java
assertEquals("Hello, World!", HelloWorld.hello(""));
```

The test is expecting that `hello` returns "Hello, World!", when given an empty string (`""`) as input.
The easiest way to make the test pass is to return `"Hello, World!"` instead of `"".

```java
class HelloWorld {
  def hello(name) {
    'Hello, World!'
  }
}
```

## Wash, Rinse, Repeat

Run the tests again.

If it fails you're going to need to read the error message carefully to figure out what went wrong, fix the problem
in the main code, and then try again until all the tests pass.

```
$ ./gradlew test
:compileJava UP-TO-DATE
:compileGroovy
:processResources UP-TO-DATE
:classes
:compileTestJava UP-TO-DATE
:compileTestGroovy
:processTestResources UP-TO-DATE
:testClasses
:test

BUILD SUCCESSFUL

Total time: 6.156 secs
```

## Submit

When everything is passing, you can submit your code with the following command:

```
$ exercism submit src/main/groovy/HelloWorld.groovy
```



