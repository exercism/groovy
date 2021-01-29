import spock.lang.*

class SecretHandshakeSpec extends Specification {

    def "Wink for 1"() {
        expect:
        SecretHandshake.commands(number) == expected

        where:
        number || expected
        1      || ['wink']
    }

    @Ignore
    def "Double blink for 10"() {
        expect:
        SecretHandshake.commands(number) == expected

        where:
        number || expected
        2      || ['double blink']
    }

    @Ignore
    def "Close your eyes for 100"() {
        expect:
        SecretHandshake.commands(number) == expected

        where:
        number || expected
        4      || ['close your eyes']
    }

    @Ignore
    def "Jump for 1000"() {
        expect:
        SecretHandshake.commands(number) == expected

        where:
        number || expected
        8      || ["jump"]
    }

    @Ignore
    def "Combine two actions"() {
        expect:
        SecretHandshake.commands(number) == expected

        where:
        number || expected
        3      || ['wink', 'double blink']
    }

    @Ignore
    def "Reverse two actions"() {
        expect:
        SecretHandshake.commands(number) == expected

        where:
        number || expected
        19     || ['double blink', 'wink']
    }

    @Ignore
    def "Reversing one action gives the same action"() {
        expect:
        SecretHandshake.commands(number) == expected

        where:
        number || expected
        24     || ['jump']
    }

    @Ignore
    def "Reversing no actions still gives no actions"() {
        expect:
        SecretHandshake.commands(number) == expected

        where:
        number || expected
        16     || []
    }

    @Ignore
    def "All possible actions"() {
        expect:
        SecretHandshake.commands(number) == expected

        where:
        number || expected
        15     || ['wink', 'double blink', 'close your eyes', 'jump']
    }

    @Ignore
    def "Reverse all possible actions"() {
        expect:
        SecretHandshake.commands(number) == expected

        where:
        number || expected
        31     || ['jump', 'close your eyes', 'double blink', 'wink']
    }

    @Ignore
    def "Do nothing for zero"() {
        expect:
        SecretHandshake.commands(number) == expected

        where:
        number || expected
        0      || []
    }

}