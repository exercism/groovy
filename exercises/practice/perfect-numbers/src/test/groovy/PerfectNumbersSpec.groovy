import spock.lang.*

class PerfectNumbersSpec extends Specification {

    @Unroll("#number should be a Perfect number")
    def "Perfect numbers"() {
        expect:
        PerfectNumbers.classify(number) == expected

        where:
        number   || expected
        6        || Classification.PERFECT
        28       || Classification.PERFECT
        33550336 || Classification.PERFECT
    }

    @Ignore
    @Unroll("#number should be a Abundant number")
    def "Abundant numbers"() {
        expect:
        PerfectNumbers.classify(number) == expected

        where:
        number   || expected
        12       || Classification.ABUNDANT
        30       || Classification.ABUNDANT
        33550335 || Classification.ABUNDANT
    }

    @Ignore
    @Unroll("#number should be a Deficient number")
    def "Deficient numbers"() {
        expect:
        PerfectNumbers.classify(number) == expected

        where:
        number   || expected
        2        || Classification.DEFICIENT
        4        || Classification.DEFICIENT
        32       || Classification.DEFICIENT
        33550337 || Classification.DEFICIENT
    }

    @Ignore
    def "Edge case (no factors other than itself) is classified correctly"() {
        expect:
        PerfectNumbers.classify(number) == expected

        where:
        number || expected
        1      || Classification.DEFICIENT
    }

    @Ignore
    def "Zero is rejected (not a natural number)"() {
        when:
        PerfectNumbers.classify(0)

        then:
        thrown(ArithmeticException)
    }

    @Ignore
    def "Negative integer is rejected (not a natural number)"() {
        when:
        PerfectNumbers.classify(-1)

        then:
        thrown(ArithmeticException)
    }
}