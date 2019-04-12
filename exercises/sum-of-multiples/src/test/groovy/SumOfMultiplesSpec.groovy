import spock.lang.*

class SumOfMultiplesSpec extends Specification {

    def "No multiples within limit"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors | limit || expected
        [3, 5]  | 1     || 0
    }

    @Ignore
    def "One factor has multiples within limit"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors | limit || expected
        [3, 5]  | 4     || 3
    }

    @Ignore
    def "More than one multiple within limit"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors | limit || expected
        [3]     | 7     || 9
    }

    @Ignore
    def "More than one factor with multiples within limit"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors | limit || expected
        [3, 5]  | 10    || 23
    }

    @Ignore
    def "Each multiple is only counted once"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors | limit || expected
        [3, 5]  | 100   || 2318
    }

    @Ignore
    def "A much larger limit"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors | limit || expected
        [3, 5]  | 1000  || 233168
    }

    @Ignore
    def "Three factors"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors     | limit || expected
        [7, 13, 17] | 20    || 51
    }

    @Ignore
    def "Factors not relatively prime"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors | limit || expected
        [4, 6]  | 15    || 30
    }

    @Ignore
    def "Some pairs of factors relatively prime and some not"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors   | limit || expected
        [5, 6, 8] | 150   || 4419
    }

    @Ignore
    def "One factor is a multiple of another"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors | limit || expected
        [5, 25] | 51    || 275
    }

    @Ignore
    def "Much larger factors"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors  | limit || expected
        [43, 47] | 10000 || 2203160
    }

    @Ignore
    def "All numbers are multiples of 1"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors | limit || expected
        [1]     | 100   || 4950
    }

    @Ignore
    def "No factors means an empty sum"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors | limit || expected
        [0]     | 10000 || 0
    }

    @Ignore
    def "The only multiple of 0 is 0"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors | limit || expected
        [0]     | 1     || 0
    }

    @Ignore
    def "The factor 0 does not affect the sum of multiples of other factors"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors | limit || expected
        [3, 0]  | 4     || 3
    }

    @Ignore
    def "Solutions using include-exclude must extend to cardinality greater than 3"() {
        expect:
        SumOfMultiples.sum(factors, limit) == expected

        where:
        factors          | limit || expected
        [2, 3, 5, 7, 11] | 10000 || 39614537
    }
}