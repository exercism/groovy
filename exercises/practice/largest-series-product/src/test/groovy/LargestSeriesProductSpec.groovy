import spock.lang.*

class LargestSeriesProductSpec extends Specification {
    def "finds the largest product if span equals length"() {
        expect:
        LargestSeriesProduct.largestProduct(digits, span) == expectedResult

        where:
        digits | span || expectedResult
        "29"   | 2    || 18
    }

    @Ignore
    def "can find the largest product of 2 with numbers in order"() {
        expect:
        LargestSeriesProduct.largestProduct(digits, span) == expectedResult

        where:
        digits       | span || expectedResult
        "0123456789" | 2    || 72
    }

    @Ignore
    def "can find the largest product of 2"() {
        expect:
        LargestSeriesProduct.largestProduct(digits, span) == expectedResult

        where:
        digits      | span || expectedResult
        "576802143" | 2    || 48
    }

    @Ignore
    def "can find the largest product of 3 with numbers in order"() {
        expect:
        LargestSeriesProduct.largestProduct(digits, span) == expectedResult

        where:
        digits       | span || expectedResult
        "0123456789" | 3    || 504
    }

    @Ignore
    def "can find the largest product of 3"() {
        expect:
        LargestSeriesProduct.largestProduct(digits, span) == expectedResult

        where:
        digits       | span || expectedResult
        "1027839564" | 3    || 270
    }

    @Ignore
    def "can find the largest product of 5 with numbers in order"() {
        expect:
        LargestSeriesProduct.largestProduct(digits, span) == expectedResult

        where:
        digits       | span || expectedResult
        "0123456789" | 5    || 15120
    }

    @Ignore
    def "can get the largest product of a big number"() {
        expect:
        LargestSeriesProduct.largestProduct(digits, span) == expectedResult

        where:
        digits                                               | span || expectedResult
        "73167176531330624919225119674426574742355349194934" | 6    || 23520
    }

    @Ignore
    def "reports zero if the only digits are zero"() {
        expect:
        LargestSeriesProduct.largestProduct(digits, span) == expectedResult

        where:
        digits | span || expectedResult
        "0000" | 2    || 0
    }

    @Ignore
    def "reports zero if all spans include zero"() {
        expect:
        LargestSeriesProduct.largestProduct(digits, span) == expectedResult

        where:
        digits  | span || expectedResult
        "99099" | 3    || 0
    }

    @Ignore
    def "rejects span longer than string length"() {
        when:
        LargestSeriesProduct.largestProduct(digits, span)

        then:
        IllegalArgumentException exceptionThrown = thrown(IllegalArgumentException)
        exceptionThrown.message == expectedErrorMessage

        where:
        digits | span || expectedErrorMessage
        "123"  | 4    || "span must not exceed string length"
    }

    @Ignore
    def "reports 1 for empty string and empty product (0 span)"() {
        expect:
        LargestSeriesProduct.largestProduct(digits, span) == expectedResult

        where:
        digits | span || expectedResult
        ""     | 0    || 1
    }

    @Ignore
    def "reports 1 for nonempty string and empty product (0 span)"() {
        expect:
        LargestSeriesProduct.largestProduct(digits, span) == expectedResult

        where:
        digits | span || expectedResult
        "123"  | 0    || 1
    }

    @Ignore
    def "rejects empty string and nonzero span"() {
        when:
        LargestSeriesProduct.largestProduct(digits, span)

        then:
        IllegalArgumentException exceptionThrown = thrown(IllegalArgumentException)
        exceptionThrown.message == expectedErrorMessage

        where:
        digits | span || expectedErrorMessage
        ""     | 1    || "span must not exceed string length"
    }

    @Ignore
    def "rejects invalid character in digits"() {
        when:
        LargestSeriesProduct.largestProduct(digits, span)

        then:
        IllegalArgumentException exceptionThrown = thrown(IllegalArgumentException)
        exceptionThrown.message == expectedErrorMessage

        where:
        digits   | span || expectedErrorMessage
        "1234a5" | 2    || "digits input must only contain digits"
    }

    @Ignore
    def "rejects negative span"() {
        when:
        LargestSeriesProduct.largestProduct(digits, span)

        then:
        IllegalArgumentException exceptionThrown = thrown(IllegalArgumentException)
        exceptionThrown.message == expectedErrorMessage

        where:
        digits  | span || expectedErrorMessage
        "12345" | -1   || "span must not be negative"
    }
}
