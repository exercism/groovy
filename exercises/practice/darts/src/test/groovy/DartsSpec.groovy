import spock.lang.*

class DartsSpec extends Specification {

    def "Missed target"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x  | y || expected
        -9 | 9 || 0
    }

    @Ignore
    def "On the outer circle"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x | y  || expected
        0 | 10 || 1
    }

    @Ignore
    def "On the middle circle"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x  | y || expected
        -5 | 0 || 5
    }

    @Ignore
    def "On the inner circle"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x | y  || expected
        0 | -1 || 10
    }

    @Ignore
    def "Exactly on centre"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x | y || expected
        0 | 0 || 10
    }

    @Ignore
    def "Near the centre"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x    | y    || expected
        -0.1 | -0.1 || 10
    }

    @Ignore
    def "Just within the inner circle"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x   | y   || expected
        0.7 | 0.7 || 10
    }

    @Ignore
    def "Just outside the inner circle"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x   | y    || expected
        0.8 | -0.8 || 5
    }

    @Ignore
    def "Just within the middle circle"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x    | y   || expected
        -3.5 | 3.5 || 5
    }

    @Ignore
    def "Just outside the middle circle"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x    | y    || expected
        -3.6 | -3.6 || 1
    }

    @Ignore
    def "Just within the outer circle"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x    | y   || expected
        -7.0 | 7.0 || 1
    }

    @Ignore
    def "Just outside the outer circle"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x   | y    || expected
        7.1 | -7.1 || 0
    }

    @Ignore
    def "Asymmetric position between the inner and middle circles"() {
        expect:
        Darts.score(x, y) == expected

        where:
        x   | y  || expected
        0.5 | -4 || 5
    }
}