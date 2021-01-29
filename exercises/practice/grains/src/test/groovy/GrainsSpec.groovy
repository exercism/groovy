import spock.lang.*

class GrainsSpec extends Specification {

    @Shared
    def grains = new Grains()

    def "Square of 1"() {
        expect:
        grains.square(square) == expected

        where:
        square || expected
        1      || 1
    }

    @Ignore
    def "Square of 2"() {
        expect:
        grains.square(square) == expected

        where:
        square || expected
        2      || 2
    }

    @Ignore
    def "Square of 3"() {
        expect:
        grains.square(square) == expected

        where:
        square || expected
        3      || 4
    }

    @Ignore
    def "Square of 4"() {
        expect:
        grains.square(square) == expected

        where:
        square || expected
        4      || 8
    }

    @Ignore
    def "Square of 16"() {
        expect:
        grains.square(square) == expected

        where:
        square || expected
        16     || 32768
    }

    @Ignore
    def "Square of 32"() {
        expect:
        grains.square(square) == expected

        where:
        square || expected
        32     || 2147483648
    }

    @Ignore
    def "Square of 64"() {
        expect:
        grains.square(square) == expected

        where:
        square || expected
        64     || 9223372036854775808
    }

    @Ignore
    def "Square 0 raises an exception"() {
        when:
        grains.square(square)

        then:
        thrown(ArithmeticException)

        where:
        square = 0
    }

    @Ignore
    def "Negative square raises an exception"() {
        when:
        grains.square(square)

        then:
        thrown(ArithmeticException)

        where:
        square = -1
    }

    @Ignore
    def "Square greater than 64 raises an exception"() {
        when:
        grains.square(square)

        then:
        thrown(ArithmeticException)

        where:
        square = 65
    }


    @Ignore
    def "Test total"() {
        expect:
        grains.total() == 18446744073709551615
    }
}