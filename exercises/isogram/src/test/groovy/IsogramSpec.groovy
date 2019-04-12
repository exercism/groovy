import spock.lang.*

class IsogramSpec extends Specification {

    def "An empty string"() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase || expected
        ''     || true
    }

    @Ignore
    def "Isogram with only lower case characters"() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase    || expected
        'isogram' || true
    }

    @Ignore
    def "Word with one duplicated character"() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase   || expected
        'eleven' || false
    }

    @Ignore
    def "Word with one duplicated character from the end of the alphabet"() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase  || expected
        'zzyzx' || false
    }

    @Ignore
    def "Longest reported english isogram"() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase              || expected
        'subdermatoglyphic' || true
    }

    @Ignore
    def "Word with duplicated character in mixed case"() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase     || expected
        'Alphabet' || false
    }

    @Ignore
    def "Hypothetical isogrammic word with hyphen"() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase                || expected
        'thumbscrew-japingly' || true
    }

    @Ignore
    def "Hypothetical word with duplicated character following hyphen"() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase                 || expected
        'thumbscrew-jappingly' || false
    }

    @Ignore
    def "Isogram with duplicated hyphen"() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase         || expected
        'six-year-old' || true
    }

    @Ignore
    def "Made-up name that is an isogram"() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase                    || expected
        'Emily Jung Schwartzkopf' || true
    }

    @Ignore
    def "Duplicated character in the middle"() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase     || expected
        'accentor' || false
    }

    @Ignore
    def "Same first and last characters"() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase   || expected
        'angola' || false
    }

}