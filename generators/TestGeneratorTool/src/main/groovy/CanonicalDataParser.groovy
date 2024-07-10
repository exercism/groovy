import groovy.json.JsonSlurper

/**
 * Canonical data parser.
 */
class CanonicalDataParser {
    LinkedHashMap specification

    /**
     * Parse canonical-data.json.
     * @param source The text content of canonical-data.json file.
     */
    CanonicalDataParser(String source) {
        specification = new JsonSlurper().parseText(source) as LinkedHashMap
    }

    /**
     * Get exercise slug from parsed data.
     * @return Exercise slug.
     */
    String getExerciseSlug() {
        specification["exercise"]
    }

    /**
     * Helper function to flatten the nested structure of test cases.
     * @param testItems A collection of test cases and test groups.
     * @return A collection of test cases as LabeledTestCase objects (test groups are flattened).
     */
    ArrayList<LabeledTestCase> getTestCasesHelper(ArrayList<LinkedHashMap> testItems) {
        ArrayList<LabeledTestCase> collectedItems = []

        for (LinkedHashMap labeledTestItem in testItems) {

            // Only test groups contain the 'cases' property.
            if (labeledTestItem.containsKey 'cases') {

                // Test groups are handled by recursive call.
                collectedItems.addAll(getTestCasesHelper(labeledTestItem['cases'] as ArrayList<LinkedHashMap>))
            } else {

                // Standard test case (not a test group).
                collectedItems.add(new LabeledTestCase(UUID.fromString(labeledTestItem['uuid'] as String),
                        labeledTestItem['description'] as String,
                        labeledTestItem['property'] as String,
                        labeledTestItem['input'],
                        labeledTestItem['expected']))
            }
        }
        collectedItems
    }

    /**
     * Get collection of test cases as LabeledTestCase objects.
     * @return A collection of test cases as LabeledTestCase objects.
     */
    ArrayList<LabeledTestCase> getLabeledTestCases() {
        getTestCasesHelper(specification['cases'] as ArrayList<LinkedHashMap>)
    }
}
