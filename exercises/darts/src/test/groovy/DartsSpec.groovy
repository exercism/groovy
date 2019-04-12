import spock.lang.*

class DartsSpec extends Specification {

    def "A dart lands outside the target"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x  | y   || expected
        -9 | 152 || 0
    }

    @Ignore
    def "A dart lands just in the border of the target"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x | y  || expected
        0 | 10 || 1
    }

    @Ignore
    def "A dart lands in the outer circle"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x | y || expected
        4 | 4 || 1
    }

    @Ignore
    def "A dart lands right in the border between outer and middle circles"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x | y || expected
        5 | 0 || 5
    }

    @Ignore
    def "A dart lands in the middle circle"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x   | y    || expected
        0.8 | -0.8 || 5
    }

    @Ignore
    def "A dart lands right in the border between middle and inner circles"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x | y  || expected
        0 | -1 || 10
    }

    @Ignore
    def "A dart lands in the inner circle"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x    | y    || expected
        -0.1 | -0.1 || 10
    }
}