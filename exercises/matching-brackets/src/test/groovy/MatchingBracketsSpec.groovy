import spock.lang.*

class MatchingBracketsSpec extends Specification {

    def "Paired square brackets"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value || expected
        '[]'  || true
    }

    @Ignore
    def "Empty string"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value || expected
        ''    || true
    }

    @Ignore
    def "Unpaired brackets"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value || expected
        '[['  || false
    }

    @Ignore
    def "Wrong ordered brackets"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value || expected
        '}{'  || false
    }

    @Ignore
    def "Wrong closing bracket"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value || expected
        '{]'  || false
    }

    @Ignore
    def "Paired with whitespace"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value || expected
        '{ }' || true
    }

    @Ignore
    def "Partially paired brackets"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value  || expected
        '{[])' || false
    }

    @Ignore
    def "Simple nested brackets"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value  || expected
        '{[]}' || true
    }

    @Ignore
    def "Several paired brackets"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value  || expected
        '{}[]' || true
    }

    @Ignore
    def "Paired and nested brackets"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value          || expected
        '([{}({}[])])' || true
    }

    @Ignore
    def "Unopened closing brackets"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value     || expected
        '{[)][]}' || false
    }

    @Ignore
    def "Unpaired and nested brackets"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value   || expected
        '([{])' || false
    }

    @Ignore
    def "Paired and wrong nested brackets"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value    || expected
        '[({]})' || false
    }

    @Ignore
    def "Paired and incomplete brackets"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value || expected
        '{}[' || false
    }

    @Ignore
    def "Too many closing brackets"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value || expected
        '[]]' || false
    }

    @Ignore
    def "Math expression"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value                             || expected
        '(((185 + 223.85) * 15) - 543)/2' || true
    }

    @Ignore
    def "Complex latex expression"() {
        expect:
        MatchingBrackets.isPaired(value) == expected

        where:
        value = '\\\\left(\\\\begin{array}{cc} \\\\frac{1}{3} & x\\\\\\\\ \\\\mathrm{e}^{x} &... x^2 \\\\end{array}\\\\right)'
        expected = true
    }

}