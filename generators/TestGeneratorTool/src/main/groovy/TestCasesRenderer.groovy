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
        String testMethodErrorPattern = Files.readString(Path.of('templates', 'TestMethodError.template'))
        Template templateMethod = engine.createTemplate(testMethodPattern)
        Template templateMethodError = engine.createTemplate(testMethodErrorPattern)

        String exerciseName = Identifier.of(specification.exerciseSlug, Casing.KebabCase).toCase(Casing.PascalCase)

        ArrayList<String> testMethods = []
        boolean ignore = false
        for (labeledTestCase in specification.labeledTestCases) {
            LinkedHashMap input = labeledTestCase.input as LinkedHashMap
            ArrayList<String> argumentNames = new ArrayList<>(input.keySet())
            ArrayList<String> argumentValues = input.values().collect({ JsonOutput.toJson(it) })
            ArrayList<Integer> fieldWidths = []
            for (i in 0..<argumentNames.size()) {
                fieldWidths.add(Math.max(argumentNames[i].length(), argumentValues[i].length()))
            }
            String commaSeparatedArgumentNames = argumentNames.join(', ')
            String pipeSeparatedArgumentNames =
                    argumentNames
                    .withIndex()
                    .collect({ String name, Integer index -> name.padRight(fieldWidths[index]) })
                    .join(' | ')
            String pipeSeparatedArgumentValues =
                    argumentValues
                    .withIndex()
                    .collect({ String value, Integer index -> value.padRight(fieldWidths[index]) })
                    .join(' | ')
            if (labeledTestCase.expected instanceof Map && (labeledTestCase.expected as LinkedHashMap).containsKey('error')) {
                testMethods.add(templateMethodError.make([
                        ignore: ignore,
                        description: labeledTestCase.description,
                        exerciseName: exerciseName,
                        property: labeledTestCase.property,
                        commaSeparatedArgumentNames: commaSeparatedArgumentNames,
                        pipeSeparatedArgumentNamesTrimmed: pipeSeparatedArgumentNames.trim(),
                        pipeSeparatedArgumentValuesTrimmed: pipeSeparatedArgumentValues.trim(),
                        errorMessage: JsonOutput.toJson(labeledTestCase.expected['error'])
                ]).toString())
            } else {
                testMethods.add(templateMethod.make([
                        ignore: ignore,
                        description: labeledTestCase.description,
                        exerciseName: exerciseName,
                        property: labeledTestCase.property,
                        commaSeparatedArgumentNames: commaSeparatedArgumentNames,
                        pipeSeparatedArgumentNames: pipeSeparatedArgumentNames,
                        pipeSeparatedArgumentValues: pipeSeparatedArgumentValues,
                        expected: JsonOutput.toJson(labeledTestCase.expected)
                ]).toString())
            }
            ignore = true
        }

        LinkedHashMap bindings = [
                exerciseName: exerciseName,
                testMethods : testMethods
        ]

        engine.createTemplate(testClassPattern).make(bindings).toString()
    }
}
