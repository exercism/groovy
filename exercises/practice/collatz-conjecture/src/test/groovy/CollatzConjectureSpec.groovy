import spock.lang.*

class CollatzConjectureSpec extends Specification {

    def "Zero steps for one"() {
        expect:
        CollatzConjecture.steps(number) == expected

        where:
        number || expected
        1      || 0
    }

    @Ignore
    def "Divide if even"() {
        expect:
        CollatzConjecture.steps(number) == expected

        where:
        number || expected
        16     || 4
    }

    @Ignore
    def "Even and odd steps"() {
        expect:
        CollatzConjecture.steps(number) == expected

        where:
        number || expected
        12     || 9
    }

    @Ignore
    def "Large number of even and odd steps"() {
        expect:
        CollatzConjecture.steps(number) == expected

        where:
        number  || expected
        1000000 || 152
    }

    @Ignore
    def "Zero is an error"() {
        when:
        CollatzConjecture.steps(number)

        then:
        thrown(ArithmeticException)

        where:
        number = 0
    }

    @Ignore
    def "Negative value is an error"() {
        when:
        CollatzConjecture.steps(number)

        then:
        thrown(ArithmeticException)

        where:
        number = -15
    }

}