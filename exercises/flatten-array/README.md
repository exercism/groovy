# Flatten Array

Take a nested list and return a single flattened list with all values except nil/null.

The challenge is to write a function that accepts an arbitrarily-deep nested list-like structure and returns a flattened structure without any nil/null values.

For Example

input: [1,[2,3,null,4],[null],5]

output: [1,2,3,4,5]

# Groovy Tips

Since this exercise has difficulty 5 it doesn't come with any starter implementation.
This is so that you get to practice creating classes and methods which is an important part of programming in Groovy.
It does mean that when you first try to run the tests, they won't compile.
They will give you an error similar to:
```
 path-to-exercism-dir\exercism\groovy\exercises\name-of-exercise\ExerciseNameSpec.groovy: 9: unable to resolve class ExerciseClassName
        ExerciseClassName exerciseClassName = new ExerciseClassName()
        ^
 1 error
```
This error occurs because the test refers to a class that hasn't been created yet (`ExerciseClassName`).
To resolve the error you need to add a file matching the class name in the error to the `name-of-exercise` directory.
For example, for the error above you would add a file called `ExerciseClassName.groovy`.

When you try to run the tests again you will get slightly different errors.
You might get an error similar to:
```
Test Failure: flat list is preserved(FlattenerSpec)
groovy.lang.MissingMethodException: No signature of method: Flattener.flatten() is applicable for argument types: (java.util.ArrayList) values: [[0, 1, two]]
        at FlattenerSpec.flat list is preserved(FlattenerSpec.groovy:16)
```
This error means that you need to add a `flatten` method to your new class that takes a `List` as its argument.
Something like this:
```
static List flatten(List l) {
    l
}
```
That should make the error go away, though you might need to add some more code to your class to make the tests pass!

# Running the tests

You can run all the tests for an exercise by entering

```sh
$ groovy ./FlattenerSpec.groovy
```

in your terminal.

## Source

Interview Question [https://reference.wolfram.com/language/ref/Flatten.html](https://reference.wolfram.com/language/ref/Flatten.html)

## Submitting Incomplete Solutions

It's possible to submit an incomplete solution so you can see how others have completed the exercise.
