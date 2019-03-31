import spock.lang.*

class DifferenceOfSquaresSpec extends Specification {

    @Unroll("can square the sum of the numbers up to #integer")
    def "can square the sum up to the given integer"() {
        expect:
        new DifferenceOfSquares(integer).squareOfSum() == expected

        where:
        integer | expected
        1       | 1
        5       | 225
        100     | 25502500
    }

    @Ignore
    @Unroll("can sum the squares up to #integer")
    def 'can sum the squares up to the given integer'() {
        expect:
        new DifferenceOfSquares(integer).sumOfSquares() == expected

        where:
        integer | expected
        1       | 1
        5       | 55
        100     | 338350
    }

    @Ignore
    @Unroll("can subtract sum of squares from square of sum of #integer")
    def 'can subtract sum of squares from square of sum'() {
        expect:
        new DifferenceOfSquares(integer).difference() == expected

        where:
        integer | expected
        1       | 0
        5       | 170
        100     | 25164150
    }
}
