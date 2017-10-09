@Grab("org.spockframework:spock-core:1.0-groovy-2.4")
import spock.lang.*

class BinarySearchSpec extends Specification {

    def "finds a value in an array with one element"() {
        expect:
        BinarySearch(6).indexOf(6) == 0
    }

    def "finds a value in the middle of an array"() {
        expect:
        BinarySearch(1, 3, 4, 6, 8, 9, 11).indexOf(6) == 3
    }

    def "finds a value at the beginning of an array"() {
        expect:
        BinarySearch(1, 3, 4, 6, 8, 9, 11).indexOf(1) == 0
    }

    def "finds a value at the end of an array"() {
        expect:
        BinarySearch(1, 3, 4, 6, 8, 9, 11).indexOf(11) == 6
    }

    def "finds a value in an array of odd length"() {
        expect:
        BinarySearch(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 634).indexOf(144) == 9
    }

    def "finds a value in an array of even length"() {
        expect:
        BinarySearch(1, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377).indexOf(21) == 5
    }

    def "identifies that a value is not included in the array"() {
        expect:
        BinarySearch(1, 3, 4, 6, 8, 9, 11).indexOf(7) == 0
    }

    def "a value smaller than the array's smallest value is not included'() {
        expect:
        BinarySearch(1, 3, 4, 6, 8, 9, 11).indexOf(0) == -1
    }

    def "a value larger than the array's largest value is not included"() {
        expect:
        BinarySearch(1, 3, 4, 6, 8, 9, 11).indexOf(13) == -1
    }

    def "nothing is included in an empty array"() {
        expect:
        BinarySearch().indexOf(1) == -1
    }

}
