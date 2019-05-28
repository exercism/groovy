import spock.lang.Ignore
import spock.lang.Specification

class LuhnSpec extends Specification {

    def "Single digit strings can not be valid"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value || expected
        '1'   || false
    }

    @Ignore
    def "A single zero is invalid"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value || expected
        '0'   || false
    }

    @Ignore
    def "A simple valid SIN that remains valid if reversed"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value || expected
        '059' || true
    }

    @Ignore
    def "A simple valid SIN that becomes invalid if reversed"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value || expected
        '59'  || true
    }

    @Ignore
    def "A valid Canadian SIN"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value         || expected
        '055 444 285' || true
    }

    @Ignore
    def "Invalid Canadian SIN"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value         || expected
        '055 444 286' || false
    }

    @Ignore
    def "Invalid credit card"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value                 || expected
        '8273 1232 7352 0569' || false
    }

    @Ignore
    def "Valid number with an even number of digits"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value        || expected
        '095 245 88' || true
    }

    @Ignore
    def "Valid number with an odd number of spaces"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value             || expected
        '234 567 891 234' || true
    }

    @Ignore
    def "Valid strings with a non-digit added at the end become invalid"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value  || expected
        '059a' || false
    }

    @Ignore
    def "Valid strings with punctuation included become invalid"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value         || expected
        '055-444-285' || false
    }

    @Ignore
    def "Valid strings with symbols included become invalid"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value           || expected
        '055# 444$ 285' || false
    }

    @Ignore
    def "Single zero with space is invalid"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value || expected
        ' 0'  || false
    }

    @Ignore
    def "More than a single zero is valid"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value    || expected
        '0000 0' || true
    }

    @Ignore
    def "Input digit 9 is correctly converted to output digit 9"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value || expected
        '091' || true
    }

    @Ignore
    def "Using ascii value for non-doubled non-digit isn't allowed"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value          || expected
        '055b 444 285' || false
    }

    @Ignore
    def "Using ascii value for doubled non-digit isn't allowed"() {
        expect:
        Luhn.valid(value) == expected

        where:
        value || expected
        ':9'  || false
    }

}