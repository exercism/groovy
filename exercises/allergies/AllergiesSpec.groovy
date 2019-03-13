@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class AllergiesSpec extends Specification {

    /*
    Given a number and a substance, indicate whether Tom is allergic
    to that substance.
    Test cases for this method involve more than one assertion.
    Each case in 'expected' specifies what the method should return for
    the given substance.
    */

    def 'No allergies means not allergic'() {
        given:
        int score = 0
        def allergies = new Allergies(score)

        expect:
        allergies.allergicTo(substance) == result

        where:
        substance      | result
        "peanuts"      | false
        "cats"         | false
        "strawberries" | false
    }

    def 'Is allergic to eggs'() {
        given:
        int score = 5
        def allergies = new Allergies(score)

        expect:
        allergies.allergicTo(substance) == result

        where:
        substance | result
        "eggs"    | true
    }

    def 'Allergic to strawberries but not peanuts'() {
        given:
        int score = 9
        def allergies = new Allergies(score)

        expect:
        allergies.allergicTo(substance) == result

        where:
        substance      | result
        "eggs"         | true
        "peanuts"      | false
        "shellfish"    | false
        "strawberries" | true
    }

    // Given a number, list all things Tom is allergic to

    def 'No allergies at all'() {
        given:
        int score = 0
        def allergies = new Allergies(score)

        expect:
        allergies.list() == []
    }

    def 'Allergic to just eggs'() {
        given:
        int score = 1
        def allergies = new Allergies(score)

        expect:
        allergies.list() == ["eggs"]
    }

    def 'Allergic to just peanuts'() {
        given:
        int score = 2
        def allergies = new Allergies(score)

        expect:
        allergies.list() == ["peanuts"]
    }

    def 'Allergic to just strawberries'() {
        given:
        int score = 8
        def allergies = new Allergies(score)

        expect:
        allergies.list() == ["strawberries"]
    }

    def 'Allergic to eggs and peanuts'() {
        given:
        int score = 3
        def allergies = new Allergies(score)

        expect:
        allergies.list() == ["eggs", "peanuts"]
    }

    def 'Allergic to lots of stuff'() {
        given:
        int score = 248
        def allergies = new Allergies(score)

        expect:
        allergies.list() == ["strawberries",
                             "tomatoes",
                             "chocolate",
                             "pollen",
                             "cats"]
    }

    def 'Allergic to everything'() {
        given:
        int score = 255
        def allergies = new Allergies(score)

        expect:
        allergies.list() == ["eggs",
                             "peanuts",
                             "shellfish",
                             "strawberries",
                             "tomatoes",
                             "chocolate",
                             "pollen",
                             "cats"]
    }

    def 'Ignore non allergen score parts'() {
        given:
        int score = 509
        def allergies = new Allergies(score)

        expect:
        allergies.list() == ["eggs",
                             "shellfish",
                             "strawberries",
                             "tomatoes",
                             "chocolate",
                             "pollen",
                             "cats"]
    }

}