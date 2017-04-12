#!/usr/bin/env groovy
@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class SquaresSpec extends Specification {

    @Unroll("can square the sum of the numbers up to #integer")
    def "can square the sum up to the given integer"() {
        expect:
            new Squares(integer).squareOfSums() == result
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
            new Squares(integer).sumOfSquares() == result
        where:
            integer | result
            5       | 55
            10      | 385
            100     | 338350
    }

    @Ignore
    @Unroll("can subtract sum of squares from square of sums of #integer")
    def 'can subtract sum of squares from square of sums'() {
        expect:
            new Squares(integer).difference() == result
        where:
            integer | result
            0       | 0
            5       | 170
            10      | 2640
            100     | 25164150
    }

}
