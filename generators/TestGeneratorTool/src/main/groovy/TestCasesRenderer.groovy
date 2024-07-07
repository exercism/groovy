import groovy.json.JsonOutput
import groovy.text.SimpleTemplateEngine
import groovy.text.Template

import java.nio.file.Files
import java.nio.file.Path

class TestCasesRenderer {
    static String render(CanonicalDataParser specification) {
        SimpleTemplateEngine engine = new SimpleTemplateEngine()
        String testClassPattern = Files.readString(Path.of('templates', 'TestClass.template'))
        String testMethodPattern = Files.readString(Path.of('templates', 'TestMethod.template'))
        Template templateMethod = engine.createTemplate(testMethodPattern)

        ArrayList<String> testMethods = []
        for (labeledTestCase in specification.labeledTestCases) {
            testMethods.add(templateMethod.make([
                    description: labeledTestCase.description,
                    property: labeledTestCase.property,
                    input: JsonOutput.toJson(labeledTestCase.input),
                    expected: JsonOutput.toJson(labeledTestCase.expected)
            ]).toString())
        }

        LinkedHashMap bindings = [
                exerciseName: Identifier.of(specification.exerciseSlug, Casing.KebabCase).toCase(Casing.PascalCase),
                testMethods : testMethods
        ]

        engine.createTemplate(testClassPattern).make(bindings).toString()
    }
}
