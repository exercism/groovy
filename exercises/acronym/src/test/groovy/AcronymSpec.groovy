import spock.lang.*

class AcronymSpec extends Specification {

    def "Basic"() {
        expect:
        Acronym.abbreviate(phrase) == expected

        where:
        phrase                      || expected
        'Portable Network Graphics' || 'PNG'
    }

    @Ignore
    def "Lowercase words"() {
        expect:
        Acronym.abbreviate(phrase) == expected

        where:
        phrase          || expected
        'Ruby on Rails' || 'ROR'
    }

    @Ignore
    def "Punctuation"() {
        expect:
        Acronym.abbreviate(phrase) == expected

        where:
        phrase                || expected
        'First In, First Out' || 'FIFO'
    }

    @Ignore
    def "All caps word"() {
        expect:
        Acronym.abbreviate(phrase) == expected

        where:
        phrase                           || expected
        'GNU Image Manipulation Program' || 'GIMP'
    }

    @Ignore
    def "Punctuation without whitespace"() {
        expect:
        Acronym.abbreviate(phrase) == expected

        where:
        phrase                                    || expected
        'Complementary metal-oxide semiconductor' || 'CMOS'
    }

    @Ignore
    def "Very long abbreviation"() {
        expect:
        Acronym.abbreviate(phrase) == expected

        where:
        phrase = 'Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me'
        expected = 'ROTFLSHTMDCOALM'
    }

    @Ignore
    def "Consecutive delimiters"() {
        expect:
        Acronym.abbreviate(phrase) == expected

        where:
        phrase                                || expected
        'Something - I made up from thin air' || 'SIMUFTA'
    }

    @Ignore
    def "Apostrophes"() {
        expect:
        Acronym.abbreviate(phrase) == expected

        where:
        phrase            || expected
        'Halley\'s Comet' || 'HC'
    }

    @Ignore
    def "Underscore emphasis"() {
        expect:
        Acronym.abbreviate(phrase) == expected

        where:
        phrase                 || expected
        'The Road _Not_ Taken' || 'TRNT'
    }

}