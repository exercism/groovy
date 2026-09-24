/**
 * A single test with a description.
 */
class LabeledTestCase {
    /**
     * A version 4 UUID (compliant with RFC 4122) in the canonical textual representation.
     */
    UUID identifier

    /**
     * Description of test case.
     */
    String description

    /**
     * Property to test.
     */
    String property

    /**
     * Suggested inputs.
     */
    Object input

    /**
     * Expected answer.
     */
    Object expected

    LabeledTestCase(UUID identifier, String description, String property, Object input, Object expected) {
        this.identifier = identifier
        this.description = description
        this.property = property
        this.input = input
        this.expected = expected
    }
}
