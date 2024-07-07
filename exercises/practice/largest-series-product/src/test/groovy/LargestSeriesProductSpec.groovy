import spock.lang.*

class ExerciseSpec extends Specification {
    @IgnoreRest
    def "finds the largest product if span equals length"() {
        expect:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span) == expected

        where:
        // Please use the following input: {"digits":"29","span":2}
        // Please expect the following: 18
        digits | span || expected
        "29"   | 2    || 18
    }

    def "can find the largest product of 2 with numbers in order"() {
        expect:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span) == expected

        where:
        // Please use the following input: {"digits":"0123456789","span":2}
        // Please expect the following: 72
        digits       | span || expected
        "0123456789" | 2    || 72
    }

    def "can find the largest product of 2"() {
        expect:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span) == expected

        where:
        // Please use the following input: {"digits":"576802143","span":2}
        // Please expect the following: 48
        digits      | span || expected
        "576802143" | 2    || 48
    }

    def "can find the largest product of 3 with numbers in order"() {
        expect:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span) == expected

        where:
        // Please use the following input: {"digits":"0123456789","span":3}
        // Please expect the following: 504
        digits       | span || expected
        "0123456789" | 3    || 504
    }

    def "can find the largest product of 3"() {
        expect:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span) == expected

        where:
        // Please use the following input: {"digits":"1027839564","span":3}
        // Please expect the following: 270
        digits       | span || expected
        "1027839564" | 3    || 270
    }

    def "can find the largest product of 5 with numbers in order"() {
        expect:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span) == expected

        where:
        // Please use the following input: {"digits":"0123456789","span":5}
        // Please expect the following: 15120
        digits       | span || expected
        "0123456789" | 5    || 15120
    }

    def "can get the largest product of a big number"() {
        expect:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span) == expected

        where:
        // Please use the following input: {"digits":"73167176531330624919225119674426574742355349194934","span":6}
        // Please expect the following: 23520
        digits                                               | span || expected
        "73167176531330624919225119674426574742355349194934" | 6    || 23520
    }

    def "reports zero if the only digits are zero"() {
        expect:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span) == expected

        where:
        // Please use the following input: {"digits":"0000","span":2}
        // Please expect the following: 0
        digits | span || expected
        "0000" | 2    || 0
    }

    def "reports zero if all spans include zero"() {
        expect:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span) == expected

        where:
        // Please use the following input: {"digits":"99099","span":3}
        // Please expect the following: 0
        digits  | span || expected
        "99099" | 3    || 0
    }

    def "rejects span longer than string length"() {
        when:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span)

        then:
        // Please expect the following: {"error":"span must be smaller than string length"}
        IllegalArgumentException exceptionThrown = thrown(IllegalArgumentException)
        exceptionThrown.message == "span must be smaller than string length"

        where:
        // Please use the following input: {"digits":"123","span":4}
        digits | span
        "123"  | 4
    }

    def "reports 1 for empty string and empty product (0 span)"() {
        expect:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span) == expected

        where:
        // Please use the following input: {"digits":"","span":0}
        // Please expect the following: 1
        digits | span || expected
        ""     | 0    || 1
    }

    def "reports 1 for nonempty string and empty product (0 span)"() {
        expect:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span) == expected

        where:
        // Please use the following input: {"digits":"123","span":0}
        // Please expect the following: 1
        digits | span || expected
        "123"  | 0    || 1
    }

    def "rejects empty string and nonzero span"() {
        when:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span)

        then:
        // Please expect the following: {"error":"span must be smaller than string length"}
        IllegalArgumentException exceptionThrown = thrown(IllegalArgumentException)
        exceptionThrown.message == "span must be smaller than string length"

        where:
        // Please use the following input: {"digits":"","span":1}
        digits | span
        ""     | 1
    }

    def "rejects invalid character in digits"() {
        when:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span)

        then:
        // Please expect the following: {"error":"digits input must only contain digits"}
        IllegalArgumentException exceptionThrown = thrown(IllegalArgumentException)
        exceptionThrown.message == "digits input must only contain digits"

        where:
        // Please use the following input: {"digits":"1234a5","span":2}
        digits   | span
        "1234a5" | 2
    }

//    def "rejects negative span"() {
//        when:
//        // Please check the "largestProduct" property
//        Exercise.largestProduct(digits, span)
//
//        then:
//        // Please expect the following: {"error":"span must be greater than zero"}
//
//        where:
//        // Please use the following input: {"digits":"12345","span":-1}
//    }

    def "rejects negative span"() {
        when:
        // Please check the "largestProduct" property
        Exercise.largestProduct(digits, span)

        then:
        // Please expect the following: {"error":"span must not be negative"}
        IllegalArgumentException exceptionThrown = thrown(IllegalArgumentException)
        exceptionThrown.message == "span must not be negative"

        where:
        // Please use the following input: {"digits":"12345","span":-1}
        digits  | span
        "12345" | -1
    }
}