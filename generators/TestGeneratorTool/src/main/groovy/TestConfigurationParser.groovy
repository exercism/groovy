/**
 * Test configuration (tests.toml) file parser.
 */
class TestConfigurationParser {
    /**
     * Lookup for excluded tests in tests.toml file.
     * @param source The source text of tests.toml file.
     * @return A set of identifiers for excluded tests.
     */
    static Set<UUID> findExcludedTests(String source) {
        Set<UUID> excludedTests = []
        UUID latestIdentifier = null
        for (String line in source.split("\\r?\\n")) {
            if (line == "include = false" && latestIdentifier != null) {
                excludedTests.add(latestIdentifier)
            } else if (line.startsWith('[') && line.endsWith(']')) {
                latestIdentifier = UUID.fromString(line.substring(1, line.size() - 1))
            }
        }
        excludedTests
    }
}
