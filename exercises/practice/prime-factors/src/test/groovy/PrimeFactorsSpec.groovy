import spock.lang.*

class PrimeFactorsSpec extends Specification {

    def "No factors"() {
        expect:
        PrimeFactors.factors(value) == expected

        where:
        value || expected
        1     || []
    }

    @Ignore
    def "Prime number"() {
        expect:
        PrimeFactors.factors(value) == expected

        where:
        value || expected
        2     || [2]
    }

    @Ignore
    def "Another prime number"() {
        expect:
        PrimeFactors.factors(value) == expected

        where:
        value || expected
        3     || [3]
    }

    @Ignore
    def "Square of a prime"() {
        expect:
        PrimeFactors.factors(value) == expected

        where:
        value || expected
        9     || [3, 3]
    }

    @Ignore
    def "Product of first prime"() {
        expect:
        PrimeFactors.factors(value) == expected

        where:
        value || expected
        4     || [2, 2]
    }

    @Ignore
    def "Cube of a prime"() {
        expect:
        PrimeFactors.factors(value) == expected

        where:
        value || expected
        8     || [2, 2, 2]
    }

    @Ignore
    def "Product of second prime"() {
        expect:
        PrimeFactors.factors(value) == expected

        where:
        value || expected
        27    || [3, 3, 3]
    }

    @Ignore
    def "Product of third prime"() {
        expect:
        PrimeFactors.factors(value) == expected

        where:
        value || expected
        625   || [5, 5, 5, 5]
    }

    @Ignore
    def "Product of first and second prime"() {
        expect:
        PrimeFactors.factors(value) == expected

        where:
        value || expected
        6     || [2, 3]
    }

    @Ignore
    def "Product of primes and non-primes"() {
        expect:
        PrimeFactors.factors(value) == expected

        where:
        value || expected
        12    || [2, 2, 3]
    }

    @Ignore
    def "Product of primes"() {
        expect:
        PrimeFactors.factors(value) == expected

        where:
        value  || expected
        901255 || [5, 17, 23, 461]
    }

    @Ignore
    def "Factors include a large prime"() {
        expect:
        PrimeFactors.factors(value) == expected

        where:
        value       || expected
        93819012551 || [11, 9539, 894119]
    }

}
