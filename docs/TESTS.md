1) In a Command Prompt or Terminal, fetch the first exercise.

```
C:\Users\You>exercism fetch groovy

Not Submitted:       1 problem
groovy (Hello World) Path\To\Your\Exercism\groovy\hello-world

New:                 1 problem
groovy (Hello World) Path\To\Your\Exercism\groovy\hello-world

unchanged: 0, updated: 0, new: 1
```

2) Start IntelliJ IDEA. In the "Welcome to IntelliJ IDEA" window, click the "Open" option.

3) Navigate to the "Path\To\Your\Exercism\groovy\THIS_EXERCISE" folder.  Make sure you've selected the root directory of the exercise. Click "OK".

4) Follow the dialog for creating the project from existing external sources.

5) IntelliJ will then create a new project structure in the editor for your exercise.

6) Open the `README.md` file and carefully read the background for the assignment.

7) Start by running the test suite: In the "Project" view, right-click on the test file (`hello-world\HelloWorldTest.groovy`), select "Run", then pick the "EtlTest" that has a JUnit icon to the left of it (red and green arrows).

8) The tests are designed to fail at the beginning. Each exercise will expect you to update the associated groovy file (named the same as the test without the ````Tests```` suffix in the filename.

9) To skip a test, you can add the @Ignore annotation a test method:

````
  //This test will run.
  @Test
  void testNoName() {
    assertTrue new HelloWorld().hello() == 'Hello, World!'
  }

  //this test will be skipped.
  @Test
  @Ignore
  void testSampleName() {
    assertTrue new HelloWorld().hello('Alice') == 'Hello, Alice!'
  }
````

Alternatively, you can simply comment out an entire method to have it removed from compilation and being included in test output.

10) Update the main Groovy code and re-run the tests until they pass.
