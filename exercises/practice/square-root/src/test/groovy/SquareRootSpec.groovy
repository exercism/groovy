import spock.lang.*

class SquareRootSpec extends Specification {

    @Unroll
    def "root of #radicand"() {
        expect:
        SquareRoot.squareRoot(radicand) == expected

        where:
        radicand    || expected
        1           || 1
        4           || 2
        25          || 5
        81          || 9
        196         || 14
        65025       || 255
    }
}
