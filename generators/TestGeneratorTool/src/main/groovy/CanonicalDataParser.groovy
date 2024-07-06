import groovy.json.JsonSlurper

class CanonicalDataParser {
    LinkedHashMap specification

    CanonicalDataParser(String source) {
        specification = new JsonSlurper().parseText(source) as LinkedHashMap
    }

    String getExerciseSlug() {
        specification["exercise"]
    }

    ArrayList<LabeledTestCase> getTestCasesHelper(ArrayList<LinkedHashMap> testItems) {
        ArrayList<LabeledTestCase> collectedItems = []
        for (LinkedHashMap labeledTestItem in testItems) {
            if (labeledTestItem.containsKey 'cases') {
                collectedItems.addAll(getTestCasesHelper(labeledTestItem['cases'] as ArrayList<LinkedHashMap>))
            } else {
                boolean containsDescription = labeledTestItem.containsKey 'description'
                boolean containsProperty = labeledTestItem.containsKey 'property'
                boolean containsInput = labeledTestItem.containsKey 'input'
                boolean containsExpected = labeledTestItem.containsKey 'expected'
                if (containsDescription && containsProperty && containsInput && containsExpected) {
                    collectedItems.add(new LabeledTestCase(labeledTestItem['description'] as String, labeledTestItem['property'] as String, labeledTestItem['input'], labeledTestItem['expected']))
                }
            }
        }
        collectedItems
    }

    ArrayList<LabeledTestCase> getLabeledTestCases() {
        getTestCasesHelper(specification['cases'] as ArrayList<LinkedHashMap>)
    }
}
