# Test generator

`generators/TestGeneratorTool` writes an exercise's Spock spec from the exercise's [canonical data](https://github.com/exercism/problem-specifications#test-data-canonical-datajson) in problem-specifications. This guide is for track maintainers.

## What it does

Given an exercise's `canonical-data.json`, the generator:

1. Reads every test case, flattening nested groups of cases.
2. Renders each case as a Spock feature method with a one-row `where:` table, using the templates in `templates/`:
   - A normal case checks `<Exercise>.<property>(<inputs>) == expectedResult`.
   - A case whose `expected` is `{"error": "..."}` checks that the call throws `IllegalArgumentException` with that message.
3. Puts `@Ignore` on every feature except the first.
4. Reads the exercise's `.meta/tests.toml`, and comments out any case marked `include = false`. Excluded cases are kept, not dropped, so a maintainer can decide what to do with them.
5. **Overwrites** `exercises/practice/<slug>/src/test/groovy/<Exercise>Spec.groovy`.

`<Exercise>` is the slug in PascalCase (`largest-series-product` becomes `LargestSeriesProduct`). `<property>` is the case's `property`, taken from the canonical data as is.

## Before you start

- **Java:** use JDK 17 to 21. The generator's wrapper is Gradle 8.5, which doesn't run on newer JDKs.
- **Canonical data:** `bin/configlet sync` keeps a local copy of problem-specifications. On Linux it is in `~/.cache/exercism/configlet/problem-specifications/`. An exercise's data is at `exercises/<slug>/canonical-data.json` inside it. To fetch or refresh it, run any `bin/configlet sync` command without `--offline`.
- **`tests.toml`:** the generator stops with `NoSuchFileException` if the exercise has no `.meta/tests.toml`. `bin/configlet create` and `bin/configlet sync --tests` both create it.

## Running it

Run it from the generator's directory. `--repository-directory` may be relative to that directory.

```bash
cd generators/TestGeneratorTool
./gradlew run --args="--repository-directory=../.. --canonical-data=$HOME/.cache/exercism/configlet/problem-specifications/exercises/<slug>/canonical-data.json"
```

The short forms are `-d` and `-i`. `./gradlew run --args="--help"` prints the usage.

The generator prints the path of the spec it wrote. Review the result with `git diff` before committing.

## Adding a new exercise

1. Create the exercise and its `tests.toml`:

   ```bash
   bin/configlet create --practice-exercise <slug>
   ```

   This adds the exercise to `config.json` and creates `.docs`, `.meta/config.json`, `.meta/tests.toml`, and empty stub, spec and reference solution files. All canonical cases are included.
2. To leave cases out, add `include = false` under their UUIDs in `.meta/tests.toml`.
3. Add `include 'exercises:practice:<slug>'` to `settings.gradle`, keeping the list in alphabetical order.
4. Copy `build.gradle` from any other exercise, then run `./gradlew wrapper` at the repo root to add the exercise's Gradle wrapper.
5. Run the generator, as above.
6. Write the reference solution in `.meta/src/reference/groovy/<Exercise>.groovy` and the student stub in `src/main/groovy/<Exercise>.groovy`. The stub's methods usually throw `UnsupportedOperationException('method not implemented.')`.
7. Delete the commented-out excluded cases from the spec, and fix anything the generator got wrong (see [Limitations](#limitations)).
8. Run `./gradlew :exercises:practice:<slug>:build` at the repo root, and fill in the `authors` and other fields in `.meta/config.json`.

## Updating an existing exercise's tests

1. Bring `tests.toml` up to date with the canonical data:

   ```bash
   bin/configlet sync --tests -e <slug> --update
   ```

   It asks about each new case. Answering no marks the case `include = false`.
2. Run the generator.
3. Compare the result with the old spec using `git diff`, and keep the old spec's conventions where they differ. The generator always calls a static method named after the canonical property, so exercises with a different API need the changes merged by hand. For example, `leap` uses `new Leap(year).isLeapYear()`, but the generator writes `Leap.leapYear(year)`.

## Limitations

- **API shape:** generated calls are always `<Exercise>.<property>(<inputs>)`, with the inputs in canonical-data order. Instance methods, constructors, or a different method name need editing.
- **Values are written as JSON:**
  - JSON objects (`{"value": 1}`) are not valid Groovy, and need rewriting as maps (`[value: 1]`) or another structure.
  - Strings are double-quoted, so a `$` in them is treated as Groovy interpolation. Change those strings to single quotes. Canonical data for `bob`, `ledger`, `luhn`, `simple-cipher` and `word-count` contains `$`.
- **Test names** are the canonical descriptions as they are, usually lower case. Existing hand-written specs often capitalise them.
- **Errors** are always `IllegalArgumentException`.
- **Output** has no final newline.

## Working on the generator

```bash
cd generators/TestGeneratorTool
./gradlew test
```

It is a standalone Gradle project, not part of the root build, so the root `./gradlew build` doesn't run its tests. IntelliJ IDEA can open the directory as a Gradle project.

| Path | Contents |
|---|---|
| `src/main/groovy/Main.groovy` | Entry point: reads the arguments, files and `tests.toml`, then writes the spec |
| `src/main/groovy/CanonicalDataParser.groovy`, `LabeledTestCase.groovy` | Parse `canonical-data.json` and flatten its cases |
| `src/main/groovy/TestConfigurationParser.groovy` | Finds the UUIDs marked `include = false` in `tests.toml` |
| `src/main/groovy/TestCasesRenderer.groovy` | Renders cases through the templates |
| `src/main/groovy/Identifier.groovy`, `Casing.groovy` | Convert between kebab-case and PascalCase |
| `src/main/groovy/CommandLineInterface.groovy`, `ICommandLineInterface.groovy` | Command-line options, using Groovy's picocli `CliBuilder` |
| `templates/` | `TestClass`, `TestMethod` and `TestError` templates, using Groovy's `SimpleTemplateEngine` |
| `src/test/groovy/` | The generator's own Spock tests |

### Useful references

- [problem-specifications README][problem-specifications-readme] and the [canonical data schema][canonical-data-definition]
- Groovy: [documentation][groovy-docs], [JSON][groovy-parsing-json], [template engines][groovy-templating], [CliBuilder][command-line-builder] and [annotation-based parsers][command-line-parser-annotations]
- [Spock][spock-framework-official] and its [primer][spock-test-primer]
- [Picocli][picocli]

[problem-specifications-readme]: <https://github.com/exercism/problem-specifications/blob/main/README.md> "The documentation for problem specifications"

[canonical-data-definition]: <https://github.com/exercism/problem-specifications/blob/main/canonical-data.schema.json> "Formal definition of canonical data (schema)"

[groovy-docs]: <https://groovy-lang.org/documentation.html> "Groovy language official documentation"

[groovy-parsing-json]: <https://groovy-lang.org/processing-json.html> "Parsing and producing JSON in Groovy"

[groovy-templating]: <https://groovy-lang.org/templating.html> "Template engines in Groovy"

[command-line-builder]: <https://groovy-lang.org/dsls.html#_clibuilder> "Builder for command-line interface"

[command-line-parser-annotations]: <https://groovy-lang.org/dsls.html#_using_annotations_and_an_interface> "Describe command-line parsers using annotations and an interface"

[spock-framework-official]: <https://spockframework.org/> "Official page for Spock test framework"

[spock-test-primer]: <https://spockframework.org/spock/docs/2.3/spock_primer.html> "Examples of test cases built on top of Spock framework"

[picocli]: <https://picocli.info/> "Picocli framework official page"
