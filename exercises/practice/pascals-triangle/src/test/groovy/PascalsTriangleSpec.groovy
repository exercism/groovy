import spock.lang.*

class PascalsTriangleSpec extends Specification {

    def "zero rows"() {
        expect:
        PascalsTriangle.rows(0) == []
    }

    @Ignore
    def "single row"() {
        expect:
        PascalsTriangle.rows(1) == [
            [1]
        ]
    }

    @Ignore
    def "two rows"() {
        expect:
        PascalsTriangle.rows(2) == [
            [1],
            [1, 1]
        ]
    }

    @Ignore
    def "three rows"() {
        expect:
        PascalsTriangle.rows(3) == [
            [1],
            [1, 1],
            [1, 2, 1]
        ]
    }

    @Ignore
    def "four rows"() {
        expect:
        PascalsTriangle.rows(4) == [
            [1],
            [1, 1],
            [1, 2, 1],
            [1, 3, 3, 1]
        ]
    }

    @Ignore
    def "five rows"() {
        expect:
        PascalsTriangle.rows(5) == [
            [1],
            [1, 1],
            [1, 2, 1],
            [1, 3, 3, 1],
            [1, 4, 6, 4, 1]
        ]
    }

    @Ignore
    def "six rows"() {
        expect:
        PascalsTriangle.rows(6) == [
            [1],
            [1, 1],
            [1, 2,  1],
            [1, 3,  3,  1],
            [1, 4,  6,  4, 1],
            [1, 5, 10, 10, 5, 1]
        ]
    }

    @Ignore
    def "ten rows"() {
        expect:
        PascalsTriangle.rows(10) == [
            [1],
            [1,  1],
            [1,  2,  1],
            [1,  3,  3,   1],
            [1,  4,  6,   4,   1],
            [1,  5, 10,  10,   5,   1],
            [1,  6, 15,  20,  15,   6,   1],
            [1,  7, 21,  35,  35,  21,   7,   1],
            [1,  8, 28,  56,  70,  56,  28,   8,  1],
            [1,  9, 36,  84, 126, 126,  84,  36,  9,  1]
        ]
    }
}
