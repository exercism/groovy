import spock.lang.*

class StrainSpec extends Specification {

    def "Keep on empty list returns empty list"() {
        expect:
        Strain.keep(collection, predicate) == expected

        where:
        collection  | predicate  || expected
        []          | { true }   || []
    }

    @Ignore
    def "Keeps everything"() {
        expect:
        Strain.keep(collection, predicate) == expected

        where:
        collection  | predicate || expected
        [1, 3, 5]   | { true }  || [1, 3, 5]
    }

    @Ignore
    def "Keeps nothing"() {
        expect:
        Strain.keep(collection, predicate) == expected

        where:
        collection  | predicate || expected
        [1, 3, 5]   | { false } || []
    }

    @Ignore
    def "Keeps first and last"() {
        expect:
        Strain.keep(collection, predicate) == expected

        where:
        collection  | predicate         || expected
        [1, 2, 3]   | { it % 2 == 1 }   || [1, 3]
    }

    @Ignore
    def "Keeps neither first nor last"() {
        expect:
        Strain.keep(collection, predicate) == expected

        where:
        collection  | predicate         || expected
        [1, 2, 3]   | { it % 2 == 0 }   || [2]
    }

    @Ignore
    def "Keeps strings"() {
        expect:
        Strain.keep(collection, predicate) == expected

        where:
        collection = ['apple', 'zebra', 'banana', 'zombies', 'cherimoya', 'zealot']
        predicate =  { it.startsWith('z') }
        expected = ['zebra', 'zombies', 'zealot']
    }

    @Ignore
    def "Keeps lists"() {
        expect:
        Strain.keep(collection, predicate) == expected

        where:
        collection = [
            [1, 2, 3],
            [5, 5, 5],
            [5, 1, 2],
            [2, 1, 2],
            [1, 5, 2],
            [2, 2, 1],
            [1, 2, 5]
        ]
        predicate = { it.contains(5) }
        expected = [
            [5, 5, 5],
            [5, 1, 2],
            [1, 5, 2],
            [1, 2, 5]
        ]
    }

    @Ignore
    def "Discard on empty list returns empty list"() {
        expect:
        Strain.discard(collection, predicate) == expected

        where:
        collection | predicate  || expected
        []         | { true }   || []
    }

    @Ignore
    def "Discards everything"() {
        expect:
        Strain.discard(collection, predicate) == expected

        where:
        collection  | predicate || expected
        [1, 3, 5]   | { true }  || []
    }

    @Ignore
    def "Discards nothing"() {
        expect:
        Strain.discard(collection, predicate) == expected

        where:
        collection  | predicate || expected
        [1, 3, 5]   | { false } || [1, 3, 5]
    }

    @Ignore
    def "Discards first and last"() {
        expect:
        Strain.discard(collection, predicate) == expected

        where:
        collection  | predicate         || expected
        [1, 2, 3]   | { it % 2 == 1 }   || [2]
    }

    @Ignore
    def "Discards neither first nor last"() {
        expect:
        Strain.discard(collection, predicate) == expected

        where:
        collection  | predicate         || expected
        [1, 2, 3]   | { it % 2 == 0 }   || [1, 3]
    }

    @Ignore
    def "Discards strings"() {
        expect:
        Strain.discard(collection, predicate) == expected

        where:
        collection = ['apple', 'zebra', 'banana', 'zombies', 'cherimoya', 'zealot']
        predicate = { it.startsWith('z') }
        expected = ['apple', 'banana', 'cherimoya']
    }

    @Ignore
    def "Discards lists"() {
        expect:
        Strain.discard(collection, predicate) == expected

        where:
        collection =  [
          [1, 2, 3],
          [5, 5, 5],
          [5, 1, 2],
          [2, 1, 2],
          [1, 5, 2],
          [2, 2, 1],
          [1, 2, 5]
        ]
        predicate = { it.contains(5) }
        expected =  [
            [1, 2, 3],
            [2, 1, 2],
            [2, 2, 1]
        ]
    }
}