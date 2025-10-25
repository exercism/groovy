import spock.lang.*

class ResistorColorDuoSpec extends Specification {

    def "Brown and black"() {
        expect:
        ResistorColorDuo.value(colors) == expected

        where:
        colors             || expected
        ['brown', 'black'] || 10
    }

    @Unroll
    @Ignore
    def "Resistor Color Duo - #label"() {
        expect:
        ResistorColorDuo.value(colors) == expected

        where:
        label                        | colors                       || expected
        'Blue and grey'              | ['blue', 'grey']             || 68
        'Yellow and violet'          | ['yellow', 'violet']         || 47
        'White and red'              | ['white', 'red']             || 92
        'Orange and orange'          | ['orange', 'orange']         || 33
        'Ignore additional colors'   | ['green', 'brown', 'orange'] || 51
        'Black and brown, one digit' | ['black', 'brown']           ||  1
    }
}
