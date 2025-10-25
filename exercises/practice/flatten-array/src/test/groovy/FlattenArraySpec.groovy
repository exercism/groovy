import spock.lang.*

class FlattenArraySpec extends Specification {

    @Shared
    def flattener = new FlattenArray()

    def "Empty"() {
        expect:
        flattener.flatten(array) == expected

        where:
        array || expected
        []    || []
    }

    @Ignore
    def "No nesting"() {
        expect:
        flattener.flatten(array) == expected

        where:
        array     || expected
        [0, 1, 2] || [0, 1, 2]
    }

    @Ignore
    def "Flattens a nested array"() {
        expect:
        flattener.flatten(array) == expected

        where:
        array     || expected
        [ [ [] ] ] || []
    }

    @Ignore
    def "Flattens array with just integers present"() {
        expect:
        flattener.flatten(array) == expected

        where:
        array                      || expected
        [1, [2, 3, 4, 5, 6, 7], 8] || [1, 2, 3, 4, 5, 6, 7, 8]
    }

    @Ignore
    def "5 level nesting"() {
        expect:
        flattener.flatten(array) == expected

        where:
        array                                     || expected
        [0, 2, [[2, 3], 8, 100, 4, [[[50]]]], -2] || [0, 2, 2, 3, 8, 100, 4, 50, -2]
    }

    @Ignore
    def "6 level nesting"() {
        expect:
        flattener.flatten(array) == expected

        where:
        array                                || expected
        [1, [2, [[3]], [4, [[5]]], 6, 7], 8] || [1, 2, 3, 4, 5, 6, 7, 8]
    }

    @Ignore
    def "Null values are omitted from the final result"() {
        expect:
        flattener.flatten(array) == expected

        where:
        array        || expected
        [1, 2, null] || [1, 2]
    }

    @Ignore
    def "Consecutive null values at the front of the array are omitted from the final result"() {
        expect:
        flattener.flatten(array) == expected

        where:
        array           || expected
        [null, null, 3] || [3]
    }

    @Ignore
    def "Consecutive null values in the middle of the array are omitted from the final result"() {
        expect:
        flattener.flatten(array) == expected

        where:
        array              || expected
        [1, null, null, 4] || [1, 4]
    }

    @Ignore
    def "Consecutive null values at the front of the array are omitted from the final result"() {
        expect:
        flattener.flatten(array) == expected

        where:
        array           || expected
        [null, null, 3] || [3]
    }

    @Ignore
    def "6 level nest array with null values"() {
        expect:
        flattener.flatten(array) == expected

        where:
        array                                            || expected
        [0, 2, [[2, 3], 8, [[100]], null, [[null]]], -2] || [0, 2, 2, 3, 8, 100, -2]
    }

    @Ignore
    def "All values in nested array are null"() {
        expect:
        flattener.flatten(array) == expected

        where:
        array                                                      || expected
        [null, [[[null]]], null, null, [[null, null], null], null] || []
    }
}
