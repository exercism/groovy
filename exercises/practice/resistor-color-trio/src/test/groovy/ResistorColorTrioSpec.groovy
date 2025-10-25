import spock.lang.*

class ResistorColorTrioSpec extends Specification {

    def "Orange and orange and black"() {
        expect:
        ResistorColorTrio.label(colors) == expected

        where:
        colors                        || expected
        ['orange', 'orange', 'black'] || '33 ohms'
    }

    @Unroll
    @Ignore
    def "Resistor Color Trio - #label"() {
        expect:
        ResistorColorTrio.label(colors) == expected

        where:
        label                          | colors                         || expected
        'Blue and grey and brown'      | ['blue', 'grey', 'brown']      || '680 ohms'
        'Red and black and red'        | ['red', 'black', 'red']        || '2 kiloohms'
        'Green and brown and orange'   | ['green', 'brown', 'orange']   || '51 kiloohms'
        'Yellow and violet and yellow' | ['yellow', 'violet', 'yellow'] || '470 kiloohms'
        'Blue and violet and blue'     | ['blue', 'violet', 'blue']     || '67 megaohms'
        'Minimum possible value'       | ['black', 'black', 'black']    || '0 ohms'
        'Maximum possible value'       | ['white', 'white', 'white']    || '99 gigaohms'
    }

    @Ignore
    def "First two colors make an invalid octal number"() {
        expect:
        ResistorColorTrio.label(colors) == expected

        where:
        colors                     || expected
        ['black', 'grey', 'black'] || '8 ohms'
    }

    @Ignore
    def "Ignore extra colors"() {
        expect:
        ResistorColorTrio.label(colors) == expected

        where:
        colors                                || expected
        ['blue', 'green', 'yellow', 'orange'] || '650 kiloohms'
    }

}
