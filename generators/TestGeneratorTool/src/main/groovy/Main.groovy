import java.nio.file.Files
import java.nio.file.Path

static void main(String[] args) {
    CommandLineInterface commandLineInterface = new CommandLineInterface()
    ICommandLineInterface options = commandLineInterface.parse args

    if (options.help()) {
        commandLineInterface.showUsage()
        return
    }

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

    CanonicalDataParser specification = new CanonicalDataParser(Files.readString(Path.of(canonical_data)))
    String exerciseSlug = specification.exerciseSlug
    String exerciseName = Identifier.of(exerciseSlug, Casing.KebabCase).toCase(Casing.PascalCase)
    ArrayList<LabeledTestCase> testCases = specification.labeledTestCases

    int testCount = testCases.size()
    println "We are going to implement $testCount tests for '$exerciseSlug' exercise."

    Path testConfigurationPath = Path.of(repository_directory, 'exercises', 'practice', exerciseSlug, '.meta', 'tests.toml')
    Set<UUID> excludedTests = TestConfigurationParser.findExcludedTests(Files.readString(testConfigurationPath))

    Path testFilePath = Path.of(repository_directory, 'exercises', 'practice', exerciseSlug, 'src', 'test', 'groovy', exerciseName + 'Spec.groovy')
    String testFileFullName = testFilePath.toString()
    println "Writing tests to $testFileFullName..."

    String renderedTests = TestCasesRenderer.render(specification, excludedTests)
    Files.writeString(testFilePath, renderedTests)
    println "Done."
}
