import spock.lang.*

class PangramSpec extends Specification {

    def "Sentence empty"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence || expected
        ''       || false
    }

    @Ignore
    def "Recognizes a perfect lower case pangram"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                     || expected
        'abcdefghijklmnopqrstuvwxyz' || true
    }

    @Ignore
    def "Pangram with only lower case"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                      || expected
        'the quick brown fox jumps over the lazy dog' || true
    }

    @Ignore
    def "Missing character 'x'"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                                      || expected
        'a quick movement of the enemy will jeopardize five gunboats' || false
    }

    @Ignore
    def "Another missing character, e.g. 'h'"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                 || expected
        'five boxing wizards jump quickly at it' || false
    }

    @Ignore
    def "Pangram with underscores"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                      || expected
        'the_quick_brown_fox_jumps_over_the_lazy_dog' || true
    }

    @Ignore
    def "Pangram with numbers"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                           || expected
        'the 1 quick brown fox jumps over the 2 lazy dogs' || true
    }

    @Ignore
    def "Missing letters replaced by numbers"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                      || expected
        '7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog' || false
    }

    @Ignore
    def "Pangram with mixed case and punctuation"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                   || expected
        '"Five quacking Zephyrs jolt my wax bed."' || true
    }

    @Ignore
    def "Upper and lower case versions of the same character should not be counted separately"() {
        expect:
        Pangram.isPangram(sentence) == expected

        where:
        sentence                                      || expected
        'the quick brown fox jumps over with lazy FX' || false
    }

}