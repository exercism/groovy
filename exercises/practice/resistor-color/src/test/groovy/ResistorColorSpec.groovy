import spock.lang.*

class ResistorColorSpec extends Specification {

    @Unroll
    def "#color"() {
        expect:
        ResistorColor.colorCode(color) == expected

        where:
        color    || expected
        'black'  || 0
        'white'  || 9
        'orange' || 3
    }

    @Ignore
    def "Colors"() {
        expect:
        ResistorColor.colors == ['black',
                                 'brown',
                                 'red',
                                 'orange',
                                 'yellow',
                                 'green',
                                 'blue',
                                 'violet',
                                 'grey',
                                 'white']
    }
}