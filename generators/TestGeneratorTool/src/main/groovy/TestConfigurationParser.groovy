class TestConfigurationParser {
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
