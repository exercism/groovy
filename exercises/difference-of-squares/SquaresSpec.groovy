@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class SquaresSpec extends Specification {

    def 'can square the sum of the numbers up to the given number'() {
        expect:
            new Squares(5).squareOfSums() == 225
            new Squares(10).squareOfSums() == 3025
            new Squares(100).squareOfSums() == 25502500
    }

    @Ignore
    def 'can sum the squares of the numbers up to the given number'() {
        expect:
            new Squares(5).sumOfSquares() == 55
            new Squares(10).sumOfSquares() == 385
            new Squares(100).sumOfSquares() == 338350
    }

    @Ignore
    def 'can subtract sum of squares from square of sums'() {
        expect:
            new Squares(0).difference() == 0
            new Squares(5).difference() == 170
            new Squares(10).difference() == 2640
            new Squares(100).difference() == 25164150
    }

}
