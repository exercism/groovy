import spock.lang.*

class ResistorColorTrioSpec extends Specification {

    def "Orange and orange and black"() {
        expect:
        ResistorColorTrio.label(colors) == expected

        where:
        colors                        || expected
        ['orange', 'orange', 'black'] || '33 ohms'
    }

    @Ignore
    def "Blue and grey and brown"() {
        expect:
        ResistorColorTrio.label(colors) == expected

        where:
        colors                    || expected
        ['blue', 'grey', 'brown'] || '680 ohms'
    }

    @Ignore
    def "Red and black and red"() {
        expect:
        ResistorColorTrio.label(colors) == expected

        where:
        colors                  || expected
        ['red', 'black', 'red'] || '2 kiloohms'
    }

    @Ignore
    def "Green and brown and orange"() {
        expect:
        ResistorColorTrio.label(colors) == expected

        where:
        colors                       || expected
        ['green', 'brown', 'orange'] || '51 kiloohms'
    }

    @Ignore
    def "Yellow and violet and yellow"() {
        expect:
        ResistorColorTrio.label(colors) == expected

        where:
        colors                         || expected
        ['yellow', 'violet', 'yellow'] || '470 kiloohms'
    }

}