class LabeledTestCase {
    String description
    String property
    Object input
    Object expected

    LabeledTestCase(String description, String property, Object input, Object expected) {
        this.description = description
        this.property = property
        this.input = input
        this.expected = expected
    }
}
