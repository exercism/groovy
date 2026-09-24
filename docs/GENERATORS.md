# Test generators

Test generators allow tracks to generate tests automatically without having to write them ourselves. Each test generator reads from the exercise's `canonical data`, which defines the name of the test, its inputs, and outputs. You can read more about exercism's approach to test suites [here](https://github.com/exercism/problem-specifications#test-data-canonical-datajson).

Generating tests automatically removes any sort of user error when creating tests. Furthermore, we want the tests to be accurate with respect to its canonical data. Test generation also makes it much easier to keep tests up to date. As the canonical data changes, the tests will be automatically updated when the generator for that test is run.

An example of a canonical data file can be found [here](https://github.com/exercism/problem-specifications/blob/master/exercises/bob/canonical-data.json)

## Deploying the generator

### Creating a project

1. Open IntelliJ Idea.
2. Click on "New Project".
3. Set name: "TestGeneratorTool".
4. Set desired test generator location
5. Set build system: "Gradle".
6. Set latest JDK and Groovy SDK.
7. Set Gradle DSL: "Groovy".
8. Click "Create".
9. Copy *TestGeneratorTool/src* folder to the project.
10. Copy *TestGeneratorTool/templates* folder to the project.
11. Copy *TestGeneratorTool/build.gradle* file to the project.

### Adding necessary dependencies

All necessary dependencies are already added to *TestGeneratorTool/build.gradle*

Should you run into any problems, search for installation instructions of Spock testing framework on their [official site][spock-framework-official].

Search for installation instructions of Picocli framework [here][picocli].

### The structure of project

- TestGeneratorTool/src - source files of test generator
- TestGeneratorTool/templates - templates used to render test class and test methods
- TestGeneratorTool/build.gradle - dependencies of project

## Usage of test generator

1. Open project in IntelliJ Idea.
2. Move to *TestGeneratorTool/src/main/groovy/Main.groovy*
3. Create a new run configuration by clicking on green arrow to the left of `static void main`.
4. Edit the configuration:
   1. Find the "Main" confugration on top panel, to the left of green arrow and green bug.
   2. Click on configuration and choose "Edit configurations..."
   3. In the "Program arguments" text box, set location of repository directory and the location on canonical-data.json to parse.
      
      Here is the example, please edit it to match your actual file system:
      
      ```
      --repository-directory=C:\Users\Aksima\Exercism\building-exercism\groovy --canonical-data=C:\Users\Aksima\Exercism\building-exercism\canonical-data\groovy\largest-series-product\canonical-data.json
      ```
   4. In the "Working directory" set the path to the project you created for test generator tool. For example, if you created project in
      
      ```
      C:\Users\Aksima\Exercism\building-exercism\tooling\groovy\generators\TestGeneratorTool
      ```
      
      ...then you must set the same text in the "Working directory" textbox.
      
   5. Click "OK"
5. Everything should be set now! You can generate tests by simply clicking the green arrow on top menu.
6. Do not forget to change *--canonical-data* command line option when you need to generate tests from another *canonical-data.json* file.

## Contibuting to test generator tool

These resources may be useful for you if you plan to contibute to test generator tool:

1. The [documentation][problem-specifications-readme] for problem specifiations.
2. The [schema][canonical-data-definition] for canonical data.
3. Groovy language [official documentation][groovy-docs].
4. [Parsing and producing JSON][groovy-parsing-json] topic in Groovy language official documentation.
5. [Template engines][groovy-templating] in Groovy
6. An article on [command line builder][command-line-builder] at groovy-lang.org.
7. [Instructions][command-line-parser-annotations] on building command-line parsers using annotations and an interface.
8. [Official page][spock-framework-official] for Spock test framework.
9. [Examples][spock-test-primer] of test cases built on top of Spock framework.
10. [Picocli][picocli] official documentation.

### Investigating canonical-data.json file structure

The formal definition of canonical-data.json file can be found [here][canonical-data-definition]. According to that definition, the canonical-data.json file consists of following parts:

- **exercise** - exercise's slug (kebab-case) - required.
- **comments** - optional.
- **cases** - an array of labeled test items - required.
  - **labeledTestItem** - either **labeledTest** or group of description and **cases** defined above.
  - **labeledTest** - a single test with following properties:
    - **uuid** - a version 4 UUID - required.
    - **reimplements** - optional.
    - **description** - a short, clear, one-line description - required.
    - **comments** - optional.
    - **scenarios** - scenarios to include/exclude test cases - optional.
    - **property** - letters-only, lowerCamelCase property name - required.
    - **input** - the inputs to a test case - required.
    - **expected** - the expected return value of a test case - required.

[problem-specifications-readme]: <https://github.com/exercism/problem-specifications/blob/main/README.md> "The documentation for problem specifiations"

[canonical-data-definition]: <https://github.com/exercism/problem-specifications/blob/main/canonical-data.schema.json> "Formal definition of canonical data (schema)"

[groovy-docs]: <https://groovy-lang.org/documentation.html> "Groovy language official documentation"

[groovy-parsing-json]: <https://groovy-lang.org/processing-json.html> "Parsing and producing JSON in Groovy"

[groovy-templating]: <https://groovy-lang.org/templating.html> "Template engines in Groovy"

[command-line-builder]: <https://groovy-lang.org/dsls.html#_clibuilder> "Builder for command-line interface"

[command-line-parser-annotations]: <https://groovy-lang.org/dsls.html#_using_annotations_and_an_interface> "Describe command-line parsers using annotations and an interface"

[spock-framework-official]: <https://spockframework.org/> "Official page for Spock test framework"

[spock-test-primer]: <https://spockframework.org/spock/docs/2.3/spock_primer.html> "Examples of test cases built on top of Spock framework"

[picocli]: <https://picocli.info/> "Picocli framework official page"