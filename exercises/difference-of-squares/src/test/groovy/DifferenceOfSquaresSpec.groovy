import spock.lang.*

class DifferenceOfSquaresSpec extends Specification {

    @Unroll("can square the sum of the numbers up to #integer")
    def "can square the sum up to the given integer"() {
        expect:
        new DifferenceOfSquares(integer).squareOfSum() == result

        where:
        integer | result
        5       | 225
        10      | 3025
        100     | 25502500
    }

    @Ignore
    @Unroll("can sum the squares up to #integer")
    def 'can sum the squares up to the given integer'() {
        expect:
        new DifferenceOfSquares(integer).sumOfSquares() == result

        where:
        integer | result
        5       | 55
        10      | 385
        100     | 338350
    }

    @Ignore
    @Unroll("can subtract sum of squares from square of sum of #integer")
    def 'can subtract sum of squares from square of sum'() {
        expect:
        new DifferenceOfSquares(integer).difference() == result

        where:
        integer | result
        0       | 0
        5       | 170
        10      | 2640
        100     | 25164150
    }
}
