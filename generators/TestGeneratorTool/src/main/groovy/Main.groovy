import java.nio.file.Files
import java.nio.file.Path

static void main(String[] args) {
    CommandLineInterface commandLineInterface = new CommandLineInterface()
    ICommandLineInterface options = commandLineInterface.parse args

    // User requested usage summary.
    if (options.help()) {
        commandLineInterface.showUsage()
        return
    }

    // Getting path to canonical data and repository directory.
    String canonical_data = options.canonical_data()
    if (canonical_data == null) {
        println 'Path to canonical-data.json not set.'
        return
    }
    String repository_directory = options.repository_directory()
    if (repository_directory == null) {
        println 'Path to repository directory not set.'
        return
    }

    // Parsing canonical data.
    CanonicalDataParser specification = new CanonicalDataParser(Files.readString(Path.of(canonical_data)))
    String exerciseSlug = specification.exerciseSlug
    String exerciseName = Identifier.of(exerciseSlug, Casing.KebabCase).toCase(Casing.PascalCase)

    // Checking tests.toml for excluded tests.
    Path testConfigurationPath = Path.of(repository_directory, 'exercises', 'practice', exerciseSlug, '.meta', 'tests.toml')
    Set<UUID> excludedTests = TestConfigurationParser.findExcludedTests(Files.readString(testConfigurationPath))

    // Rendering tests.
    String renderedTests = TestCasesRenderer.render(specification, excludedTests)

    // Writing rendered tests to file.
    Path testFilePath = Path.of(repository_directory, 'exercises', 'practice', exerciseSlug, 'src', 'test', 'groovy', exerciseName + 'Spec.groovy')
    Files.writeString(testFilePath, renderedTests)
    println "Tests are written to " + testFilePath.toString()
}
