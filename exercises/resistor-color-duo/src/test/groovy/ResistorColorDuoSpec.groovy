import spock.lang.*

class ResistorColorDuoSpec extends Specification {

    def "Brown and black"() {
        expect:
        ResistorColorDuo.value(colors) == expected

        where:
        colors             || expected
        ['brown', 'black'] || 10
    }

    @Ignore
    def "Blue and grey"() {
        expect:
        ResistorColorDuo.value(colors) == expected

        where:
        colors           || expected
        ['blue', 'grey'] || 68
    }

    @Ignore
    def "Yellow and violet"() {
        expect:
        ResistorColorDuo.value(colors) == expected

        where:
        colors               || expected
        ['yellow', 'violet'] || 47
    }

    @Ignore
    def "Orange and orange"() {
        expect:
        ResistorColorDuo.value(colors) == expected

        where:
        colors               || expected
        ['orange', 'orange'] || 33
    }
}