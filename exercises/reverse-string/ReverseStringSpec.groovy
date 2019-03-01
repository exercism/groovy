@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class ReverseStringSpec extends Specification {

    def 'an empty string'() {
        expect:
        ReverseString.reverse("") == ""
    }

    def 'a word'() {
        expect:
        ReverseString.reverse("robot") == "tobor"
    }

    def 'a capitalized word'() {
        expect:
        ReverseString.reverse("Ramen") == "nemaR"
    }

    def 'a sentence with punctuation'() {
        expect:
        ReverseString.reverse("I'm hungry!") == "!yrgnuh m'I"
    }

    def 'a palindrome'() {
        expect:
        ReverseString.reverse("racecar") == "racecar"
    }
}