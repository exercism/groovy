import spock.lang.*

class CollatzConjectureSpec extends Specification {

    def 'zero steps for one'() {
        expect:
        CollatzConjecture.steps(number) == expected

        where:
        number | expected
        1      | 0
    }

    @Ignore
    def 'divide if even'() {
        expect:
        CollatzConjecture.steps(number) == expected

        where:
        number | expected
        16     | 4
    }

    @Ignore
    def 'even and odd steps'() {
        expect:
        CollatzConjecture.steps(number) == expected

        where:
        number | expected
        12     | 9
    }

    @Ignore
    def 'large number of even and odd steps'() {
        expect:
        CollatzConjecture.steps(number) == expected

        where:
        number  | expected
        1000000 | 152
    }

    @Ignore
    def 'zero is an error'() {
        when:
        CollatzConjecture.steps(number)

        then:
        thrown(ArithmeticException)

        where:
        number = 0
    }

    @Ignore
    def 'negative value is an error'() {
        when:
        CollatzConjecture.steps(number)

        then:
        thrown(ArithmeticException)

        where:
        number = -15
    }

}