class LabeledTestCase {
    UUID identifier
    String description
    String property
    Object input
    Object expected

    LabeledTestCase(UUID identifier, String description, String property, Object input, Object expected) {
        this.identifier = identifier
        this.description = description
        this.property = property
        this.input = input
        this.expected = expected
    }
}
