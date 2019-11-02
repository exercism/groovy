import spock.lang.*

class StrainSpec extends Specification {

    def "Keep returns empty collection"() {
        expect:
        Strain.keep(collection, predicate) == expected

        where:
        collection | predicate       || expected
        []         | { it % 2 == 0 } || []
    }

    @Ignore
    def "Keep all even numbers"() {
        expect:
        Strain.keep(collection, predicate) == expected

        where:
        collection      | predicate       || expected
        [1, 2, 3, 4, 5] | { it % 2 == 0 } || [2, 4]
    }

    @Ignore
    def "Keep all odd numbers"() {
        expect:
        Strain.keep(collection, predicate) == expected

        where:
        collection      | predicate       || expected
        [1, 2, 3, 4, 5] | { it % 2 != 0 } || [1, 3, 5]
    }

    @Ignore
    def "Keep all everything under 10"() {
        expect:
        Strain.keep(collection, predicate) == expected

        where:
        collection      | predicate   || expected
        [1, 2, 3, 4, 5] | { it < 10 } || [1, 2, 3, 4, 5]
    }

    @Ignore
    def "Keep String that start with 'z'"() {
        expect:
        Strain.keep(collection, predicate) == expected

        where:
        collection = ['apple', 'zebra', 'banana', 'zombies', 'cherimoya', 'zelot']
        predicate = { it.startsWith('z') }
        expected = ['zebra', 'zombies', 'zelot']
    }

    @Ignore
    def "Discard returns empty collection"() {
        expect:
        Strain.discard(collection, predicate) == expected

        where:
        collection | predicate       || expected
        []         | { it % 2 == 0 } || []
    }

    @Ignore
    def "Discard all even numbers"() {
        expect:
        Strain.discard(collection, predicate) == expected

        where:
        collection      | predicate       || expected
        [1, 2, 3, 4, 5] | { it % 2 == 0 } || [1, 3, 5]
    }

    @Ignore
    def "Discard all odd numbers"() {
        expect:
        Strain.discard(collection, predicate) == expected

        where:
        collection      | predicate       || expected
        [1, 2, 3, 4, 5] | { it % 2 != 0 } || [2, 4]
    }

    @Ignore
    def "Discard all everything under 10"() {
        expect:
        Strain.discard(collection, predicate) == expected

        where:
        collection      | predicate   || expected
        [1, 2, 3, 4, 5] | { it < 10 } || []
    }

    @Ignore
    def "Discard String that start with 'z'"() {
        expect:
        Strain.discard(collection, predicate) == expected

        where:
        collection = ['apple', 'zebra', 'banana', 'zombies', 'cherimoya', 'zelot']
        predicate = { it.startsWith('z') }
        expected = ['apple', 'banana', 'cherimoya']
    }
}