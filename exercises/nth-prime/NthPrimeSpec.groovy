@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class NthPrimeSpec extends Specification {

    def 'can calculate the first prime'() {
        expect: NthPrime.nth(1) == 2
    }

    def 'can calculate the second prime'() {
        expect: NthPrime.nth(2) == 3
    }

    def 'can calculate the sixth prime'() {
        expect: NthPrime.nth(6) == 13
    }

    def 'can calculate a big prime'() {
        expect: NthPrime.nth(10001) == 104743
    }

    def 'throws exception when asked for the zeroth prime'() {
        when: NthPrime.nth(0)
        then: thrown(ArithmeticException)
    }

}
