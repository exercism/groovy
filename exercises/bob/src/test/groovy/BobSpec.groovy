import spock.lang.*

class BobSpec extends Specification {

    def "Stating something"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob                     || expected
        'Tom-ay-to, tom-aaaah-to.' || 'Whatever.'
    }

    @Ignore
    def "Shouting"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob       || expected
        'WATCH OUT!' || 'Whoa, chill out!'
    }

    @Ignore
    def "Shouting gibberish"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob       || expected
        'FCECDFCAAB' || 'Whoa, chill out!'
    }

    @Ignore
    def "Asking a question"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob                                          || expected
        'Does this cryogenic chamber make me look fat?' || 'Sure.'
    }

    @Ignore
    def "Asking a numeric question"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob                    || expected
        'You are, what, like 15?' || 'Sure.'
    }

    @Ignore
    def "Asking gibberish"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob        || expected
        'fffbbcbeab?' || 'Sure.'
    }

    @Ignore
    def "Talking forcefully"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob                               || expected
        'Let\'s go make out behind the gym!' || 'Whatever.'
    }

    @Ignore
    def "Using acronyms in regular speech"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob                                          || expected
        'It\'s OK if you don\'t want to go to the DMV.' || 'Whatever.'
    }

    @Ignore
    def "Forceful question"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob                             || expected
        'WHAT THE HELL WERE YOU THINKING?' || 'Calm down, I know what I\'m doing!'
    }

    @Ignore
    def "Shouting numbers"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob        || expected
        '1, 2, 3 GO!' || 'Whoa, chill out!'
    }

    @Ignore
    def "No letters"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob    || expected
        '1, 2, 3' || 'Whatever.'
    }

    @Ignore
    def "Question with no letters"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob || expected
        '4?'   || 'Sure.'
    }

    @Ignore
    def "Shouting with special characters"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob                                          || expected
        'ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!' || 'Whoa, chill out!'
    }

    @Ignore
    def "Shouting with no exclamation mark"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob           || expected
        'I HATE THE DMV' || 'Whoa, chill out!'
    }

    @Ignore
    def "Statement containing question mark"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob                            || expected
        'Ending with ? means a question.' || 'Whatever.'
    }

    @Ignore
    def "Non-letters with question"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob || expected
        ':) ?' || 'Sure.'
    }

    @Ignore
    def "Prattling on"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob                                   || expected
        'Wait! Hang on. Are you going to be OK?' || 'Sure.'
    }

    @Ignore
    def "Silence"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob || expected
        ''     || 'Fine. Be that way!'
    }

    @Ignore
    def "Prolonged silence"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob       || expected
        '          ' || 'Fine. Be that way!'
    }

    @Ignore
    def "Alternate silence"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob                 || expected
        '\t\t\t\t\t\t\t\t\t\t' || 'Fine. Be that way!'
    }

    @Ignore
    def "Multiple line question"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob                                                 || expected
        '\nDoes this cryogenic chamber make me look fat?\nNo.' || 'Whatever.'
    }

    @Ignore
    def "Starting with whitespace"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob                 || expected
        '         hmmmmmmm...' || 'Whatever.'
    }

    @Ignore
    def "Ending with whitespace"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob                                       || expected
        'Okay if like my  spacebar  quite a bit?   ' || 'Sure.'
    }

    @Ignore
    def "Other whitespace"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob    || expected
        '\n\r \t' || 'Fine. Be that way!'
    }

    @Ignore
    def "Non-question ending with whitespace"() {
        expect:
        Bob.response(heyBob) == expected

        where:
        heyBob                                             || expected
        'This is a statement ending with whitespace      ' || 'Whatever.'
    }

}