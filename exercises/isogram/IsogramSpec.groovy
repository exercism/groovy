@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class IsogramSpec extends Specification {

    def 'an empty string'() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase = ""
        expected = true
    }

    def 'isogram with only lower case characters'() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase = "isogram"
        expected = true
    }

    def 'word with one duplicated character'() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase = "eleven"
        expected = false
    }

    def 'word with one duplicated character from the end of the alphabet'() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase = "zzyzx"
        expected = false
    }

    def 'longest reported english isogram'() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase = "subdermatoglyphic"
        expected = true
    }

    def 'word with duplicated character in mixed case'() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase = "Alphabet"
        expected = false
    }

    def 'hypothetical isogrammic word with hyphen'() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase = "thumbscrew-japingly"
        expected = true
    }

    def 'hypothetical word with duplicated character following hyphen'() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase = "thumbscrew-jappingly"
        expected = false
    }

    def 'isogram with duplicated hyphen'() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase = "six-year-old"
        expected = true
    }

    def 'made-up name that is an isogram'() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase = "Emily Jung Schwartzkopf"
        expected = true
    }

    def 'duplicated character in the middle'() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase = "accentor"
        expected = false
    }

    def 'same first and last characters'() {
        expect:
        Isogram.isIsogram(phrase) == expected

        where:
        phrase = "angola"
        expected = false
    }

}