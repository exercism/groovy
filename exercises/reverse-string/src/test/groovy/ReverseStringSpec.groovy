import spock.lang.*

class ReverseStringSpec extends Specification {

    def "An empty string"() {
        expect:
        ReverseString.reverse(value) == expected

        where:
        value || expected
        ''    || ''
    }

    @Ignore
    def "A word"() {
        expect:
        ReverseString.reverse(value) == expected

        where:
        value   || expected
        'robot' || 'tobor'
    }

    @Ignore
    def "A capitalized word"() {
        expect:
        ReverseString.reverse(value) == expected

        where:
        value   || expected
        'Ramen' || 'nemaR'
    }

    @Ignore
    def "A sentence with punctuation"() {
        expect:
        ReverseString.reverse(value) == expected

        where:
        value         || expected
        "I'm hungry!" || "!yrgnuh m'I"
    }

    @Ignore
    def "A palindrome"() {
        expect:
        ReverseString.reverse(value) == expected

        where:
        value     || expected
        'racecar' || 'racecar'
    }

    @Ignore
    def "An even-sized word"() {
        expect:
        ReverseString.reverse(value) == expected

        where:
        value    || expected
        'drawer' || 'reward'
    }
}