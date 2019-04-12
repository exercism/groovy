import spock.lang.*

class AllergiesSpec extends Specification {

    /*
    Given a number and a substance, indicate whether Tom is allergic
    to that substance.
    Test cases for this method involve more than one assertion.
    Each case in "expected" specifies what the method should return for
    the given substance.
    */

    def "No allergies means not allergic"() {
        given:
        int score = 0
        def allergies = new Allergies(score)

        expect:
        allergies.allergicTo(substance) == expected

        where:
        substance      || expected
        'peanuts'      || false
        'cats'         || false
        'strawberries' || false
    }

    @Ignore
    def "Is allergic to eggs"() {
        given:
        int score = 5
        def allergies = new Allergies(score)

        expect:
        allergies.allergicTo(substance) == expected

        where:
        substance || expected
        'eggs'    || true
    }

    @Ignore
    def "Allergic to strawberries but not peanuts"() {
        given:
        int score = 9
        def allergies = new Allergies(score)

        expect:
        allergies.allergicTo(substance) == expected

        where:
        substance      || expected
        'eggs'         || true
        'peanuts'      || false
        'shellfish'    || false
        'strawberries' || true
    }

    // Given a number, list all things Tom is allergic to

    @Ignore
    def "No allergies at all"() {
        given:
        int score = 0
        def allergies = new Allergies(score)

        expect:
        allergies.list() == []
    }

    @Ignore
    def "Allergic to just eggs"() {
        given:
        int score = 1
        def allergies = new Allergies(score)

        expect:
        allergies.list() == ['eggs']
    }

    @Ignore
    def "Allergic to just peanuts"() {
        given:
        int score = 2
        def allergies = new Allergies(score)

        expect:
        allergies.list() == ['peanuts']
    }

    @Ignore
    def "Allergic to just strawberries"() {
        given:
        int score = 8
        def allergies = new Allergies(score)

        expect:
        allergies.list() == ['strawberries']
    }

    @Ignore
    def "Allergic to eggs and peanuts"() {
        given:
        int score = 3
        def allergies = new Allergies(score)

        expect:
        allergies.list() == ['eggs', 'peanuts']
    }

    @Ignore
    def "Allergic to lots of stuff"() {
        given:
        int score = 248
        def allergies = new Allergies(score)

        expect:
        allergies.list() == ['strawberries',
                             'tomatoes',
                             'chocolate',
                             'pollen',
                             'cats']
    }

    @Ignore
    def "Allergic to everything"() {
        given:
        int score = 255
        def allergies = new Allergies(score)

        expect:
        allergies.list() == ['eggs',
                             'peanuts',
                             'shellfish',
                             'strawberries',
                             'tomatoes',
                             'chocolate',
                             'pollen',
                             'cats']
    }

    @Ignore
    def "Ignore non allergen score parts"() {
        given:
        int score = 509
        def allergies = new Allergies(score)

        expect:
        allergies.list() == ['eggs',
                             'shellfish',
                             'strawberries',
                             'tomatoes',
                             'chocolate',
                             'pollen',
                             'cats']
    }

}