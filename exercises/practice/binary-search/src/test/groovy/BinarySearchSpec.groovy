import spock.lang.*

class BinarySearchSpec extends Specification {

    def "Finds a value in an array with one element"() {
        expect:
        new BinarySearch(array).indexOf(value) == expected

        where:
        array | value || expected
        [6]   | 6     || 0
    }

    @Ignore
    def "Finds a value in the middle of an array"() {
        expect:
        new BinarySearch(array).indexOf(value) == expected

        where:
        array                  | value || expected
        [1, 3, 4, 6, 8, 9, 11] | 6     || 3
    }

    @Ignore
    def "Finds a value at the beginning of an array"() {
        expect:
        new BinarySearch(array).indexOf(value) == expected

        where:
        array                  | value || expected
        [1, 3, 4, 6, 8, 9, 11] | 1     || 0
    }

    @Ignore
    def "Finds a value at the end of an array"() {
        expect:
        new BinarySearch(array).indexOf(value) == expected

        where:
        array                  | value || expected
        [1, 3, 4, 6, 8, 9, 11] | 11    || 6
    }

    @Ignore
    def "Finds a value in an array of odd length"() {
        expect:
        new BinarySearch(array).indexOf(value) == expected

        where:
        array                                                | value || expected
        [1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634] | 144   || 9
    }

    @Ignore
    def "Finds a value in an array of even length"() {
        expect:
        new BinarySearch(array).indexOf(value) == expected

        where:
        array                                           | value || expected
        [1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377] | 21    || 5
    }

    @Ignore
    def "Identifies that a value is not included in the array"() {
        expect:
        new BinarySearch(array).indexOf(value) == expected

        where:
        array                  | value || expected
        [1, 3, 4, 6, 8, 9, 11] | 7     || -1
    }

    @Ignore
    def "A value smaller than the arrays smallest value is not included"() {
        expect:
        new BinarySearch(array).indexOf(value) == expected

        where:
        array                  | value || expected
        [1, 3, 4, 6, 8, 9, 11] | 0     || -1
    }

    @Ignore
    def "A value larger than the arrays largest value is not included"() {
        expect:
        new BinarySearch(array).indexOf(value) == expected

        where:
        array                  | value || expected
        [1, 3, 4, 6, 8, 9, 11] | 13    || -1
    }

    @Ignore
    def "Nothing is included in an empty array"() {
        expect:
        new BinarySearch(array).indexOf(value) == expected

        where:
        array | value || expected
        []    | 1     || -1
    }

    @Ignore
    def "Nothing is found when the left and right bounds cross"() {
        expect:
        new BinarySearch(array).indexOf(value) == expected

        where:
        array  | value || expected
        [1, 2] | 0     || -1
    }

}
