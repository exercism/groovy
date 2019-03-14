@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class CollatzConjectureSpec extends Specification {

    def 'zero steps for one'() {
        expect:
        CollatzConjecture.steps(number) == expected

        where:
        number = 1
        expected = 0

    }

    def 'divide if even'() {
        expect:
        CollatzConjecture.steps(number) == expected

        where:
        number = 16
        expected = 4
    }

    def 'even and odd steps'() {
        expect:
        CollatzConjecture.steps(number) == expected

        where:
        number = 12
        expected = 9
    }

    def 'large number of even and odd steps'() {
        expect:
        CollatzConjecture.steps(number) == expected

        where:
        number = 1000000
        expected = 152
    }

    def 'zero is an error'() {
        when:
        CollatzConjecture.steps(number)

        then:
        thrown(ArithmeticException)

        where:
        number = 0
    }

    def 'negative value is an error'() {
        when:
        CollatzConjecture.steps(number)

        then:
        thrown(ArithmeticException)

        where:
        number = -15
    }

}