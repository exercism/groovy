import spock.lang.*

class AccumulateSpec extends Specification {

    def "Empty collection returns empty collection"() {
        expect:
        Accumulate.accumulate(collection, function) == expected

        where:
        collection | function  || expected
        []         | { it**2 } || []
    }

    @Ignore
    def "Squares"() {
        expect:
        Accumulate.accumulate(collection, function) == expected

        where:
        collection      | function  || expected
        [1, 2, 3, 4, 5] | { it**2 } || [1, 4, 9, 16, 25]
    }

    @Ignore
    def "UpperCases"() {
        expect:
        Accumulate.accumulate(collection, function) == expected

        where:
        collection         | function             || expected
        ['hello', 'world'] | { it.toUpperCase() } || ['HELLO', 'WORLD']
    }

    @Ignore
    def "Reverse"() {
        expect:
        Accumulate.accumulate(collection, function) == expected

        where:
        collection                              | function         || expected
        ['eht', 'kciuq', 'nworb', 'xof', 'cte'] | { it.reverse() } || ['the', 'quick', 'brown', 'fox', 'etc']
    }

    @Ignore
    def "Different return type"() {
        expect:
        Accumulate.accumulate(collection, function) == expected

        where:
        collection | function          || expected
        [1, 2, 3]  | { it.toString() } || ['1', '2', '3']
    }

    @Ignore
    def "Accumulate within accumulate"() {
        given:
        def input1 = ['a', 'b', 'c']
        def input2 = ['1', '2', '3']
        def function = { c -> Accumulate.accumulate(input2, { d -> c + d }).join(' ') }

        expect:
        Accumulate.accumulate(input1, function) == ['a1 a2 a3', 'b1 b2 b3', 'c1 c2 c3']
    }

}