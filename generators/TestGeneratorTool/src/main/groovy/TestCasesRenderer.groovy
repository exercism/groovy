import groovy.json.JsonOutput
import groovy.text.SimpleTemplateEngine
import groovy.text.Template

import java.nio.file.Files
import java.nio.file.Path

/**
 * Renderer of test cases.
 */
class TestCasesRenderer {

    /**
     * Render all test cases inside a test class.
     * @param specification A parsed specification of tests (from canonical-data.json).
     * @param excludedTests A set of tests excluded in tests.toml file.
     * @return Rendered test cases.
     */
    static String render(CanonicalDataParser specification, Set<UUID> excludedTests) {
        String exerciseName = Identifier.of(specification.exerciseSlug, Casing.KebabCase).toCase(Casing.PascalCase)

        Template testClassTemplate, testMethodTemplate, testErrorTemplate
        (testClassTemplate, testMethodTemplate, testErrorTemplate) = loadTemplates()

        // Do not add @Ignore attribute to the first test.
        boolean ignore = false

        ArrayList<String> testMethods = []
        for (labeledTestCase in specification.labeledTestCases) {

            // Prepare the rendering of method.
            String preparedMethod = renderMethod(
                    exerciseName,
                    labeledTestCase,
                    testMethodTemplate,
                    testErrorTemplate,
                    ignore)

            // Comment out the rendered method if it
            // should not be included according to tests.toml file.
            //
            // As per https://github.com/exercism/problem-specifications/blob/main/README.md:
            // Track generators should not automatically select the "latest" version
            // of a test case by looking at the "reimplements" hierarchy. We recommend
            // each track to make this a manual action, as the re-implemented test case
            // might actually make less sense for a track.
            //
            // According to this, we cannot just delete the excluded exercise,
            // all we can do is to comment it out, leaving the final decision
            // to the exercise author and maintainers.
            if (excludedTests.contains(labeledTestCase.identifier)) {
                preparedMethod = commentOut(preparedMethod)
            }

            // Add rendered method to the list of methods
            // which will be rendered inside test class.
            testMethods.add(preparedMethod)

            // Use @Ignore attribute for all tests after the first one.
            ignore = true
        }

        // Render the test class.
        testClassTemplate.make([
                exerciseName: exerciseName,
                testMethods : testMethods
        ]).toString()
    }

    /**
     * Render a single test method.
     * @param exerciseName The name of exercise for which test method is rendered.
     * @param labeledTestCase Test case to be rendered.
     * @param testMethodTemplate Regular test method template.
     * @param testErrorTemplate Template for checking the existence and contents of error.
     * @param ignore Should the rendered method have the @Ignore attribute?
     * @return Rendered test method.
     */
    static String renderMethod(
            String exerciseName,
            LabeledTestCase labeledTestCase,
            Template testMethodTemplate,
            Template testErrorTemplate,
            boolean ignore
    ) {
        // Convert the names of arguments and their values to string representation.
        LinkedHashMap arguments = labeledTestCase.input as LinkedHashMap
        ArrayList<String> argumentNames = new ArrayList<>(arguments.keySet())
        ArrayList<String> argumentValues = arguments.values().collect({ JsonOutput.toJson(it) })

        // Prepare the list of argument names used in property call.
        String commaSeparatedArgumentNames = argumentNames.join(', ')

        // Calculate column widths for data tables.
        ArrayList<Integer> columnWidths = []
        for (i in 0..<argumentNames.size()) {
            columnWidths.add(Math.max(argumentNames[i].length(), argumentValues[i].length()))
        }

        // Pad names to column widths and join them using pipe.
        String pipeSeparatedArgumentNames =
                argumentNames
                        .withIndex()
                        .collect({ String name, Integer index -> name.padRight(columnWidths[index]) })
                        .join(' | ')

        // Pad values to column widths and join them using pipe.
        String pipeSeparatedArgumentValues =
                argumentValues
                        .withIndex()
                        .collect({ String value, Integer index -> value.padRight(columnWidths[index]) })
                        .join(' | ')

        // Check what template we should use: a regular test method template,
        // or a template to test property call which should throw an error.
        boolean useErrorCheckTemplate =
                labeledTestCase.expected instanceof Map
                        && (labeledTestCase.expected as LinkedHashMap).containsKey('error')

        // Render the corresponding template.
        Object expected = useErrorCheckTemplate ? labeledTestCase.expected['error'] : labeledTestCase.expected
        (useErrorCheckTemplate ? testErrorTemplate : testMethodTemplate).make([
                ignore                     : ignore,
                description                : labeledTestCase.description,
                exerciseName               : exerciseName,
                property                   : labeledTestCase.property,
                commaSeparatedArgumentNames: commaSeparatedArgumentNames,
                pipeSeparatedArgumentNames : pipeSeparatedArgumentNames,
                pipeSeparatedArgumentValues: pipeSeparatedArgumentValues,
                expected                   : JsonOutput.toJson(expected)
        ]).toString()
    }

    /**
     * Load templates from filesystem.
     * @return Retrieved templates.
     */
    static ArrayList<Template> loadTemplates() {
        SimpleTemplateEngine engine = new SimpleTemplateEngine()
        [
                'TestClass.template',
                'TestMethod.template',
                'TestError.template'
        ].collect { engine.createTemplate(Files.readString(Path.of('templates', it))) }
    }

    /**
     * Comment out the specified test method.
     * @param source The source text of test method.
     * @return The text of test method after disabling it (by using line comments).
     */
    static String commentOut(String source) {
        String lineSeparator = source.contains('\r') ? '\r\n' : '\n'
        source.split("\\r?\\n").collect({ '//' + it }).join(lineSeparator) + lineSeparator
    }
}
