@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class PrimeSpec extends Specification {

    def 'can calculate the first prime'() {
        expect: Prime.nth(1) == 2
    }

    def 'can calculate the second prime'() {
        expect: Prime.nth(2) == 3
    }

    def 'can calculate the sixth prime'() {
        expect: Prime.nth(6) == 13
    }

    def 'can calculate a big prime'() {
        expect: Prime.nth(10001) == 104743
    }

    def 'throws exception when asked for the zeroth prime'() {
        when: Prime.nth(0)
        then: thrown(ArithmeticException)
    }

}
