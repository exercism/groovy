import spock.lang.*

class SeriesSpec extends Specification {

    def "Slices of one from one"() {
        expect:
        Series.slices(series, sliceLength) == expected

        where:
        series | sliceLength || expected
        "1"    | 1           || ['1']
    }

    @Ignore
    def "Slices of one from two"() {
        expect:
        Series.slices(series, sliceLength) == expected

        where:
        series | sliceLength || expected
        '12'   | 1           || ['1', '2']
    }

    @Ignore
    def "Slices of two"() {
        expect:
        Series.slices(series, sliceLength) == expected

        where:
        series | sliceLength || expected
        '35'   | 2           || ['35']
    }

    @Ignore
    def "Slices of two overlap"() {
        expect:
        Series.slices(series, sliceLength) == expected

        where:
        series | sliceLength || expected
        '9142' | 2           || ['91', '14', '42']
    }

    @Ignore
    def "Slices can include duplicate"() {
        expect:
        Series.slices(series, sliceLength) == expected

        where:
        series   | sliceLength || expected
        '777777' | 3           || ['777', '777', '777', '777']
    }

    @Ignore
    def "Slices of a long series"() {
        expect:
        Series.slices(series, sliceLength) == expected

        where:
        series = '918493904243'
        sliceLength = 5
        expected = ['91849', '18493', '84939', '49390',
                    '93904', '39042', '90424', '04243']
    }

    @Ignore
    def "Slice length is too large"() {
        when:
        Series.slices('12345', 6)

        then:
        thrown(ArithmeticException)
    }

    @Ignore
    def "Slice length cannot be zero"() {
        when:
        Series.slices('12345', 0)

        then:
        thrown(ArithmeticException)
    }

    @Ignore
    def "Slice length cannot be negative"() {
        when:
        Series.slices('123', -1)

        then:
        thrown(ArithmeticException)
    }

    @Ignore
    def "Empty series is invalid"() {
        when:
        Series.slices('', -1)

        then:
        thrown(ArithmeticException)
    }
}