import spock.lang.*

class LargestSeriesProductSpec extends Specification {

    def "Say Hi!"() {
        expect:
        new LargestSeriesProduct().hello() == expected

        where:
        expected = 'Hello, World!'
    }

}
