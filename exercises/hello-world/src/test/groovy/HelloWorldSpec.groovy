import spock.lang.*

class HelloWorldSpec extends Specification {

    def "Outputs 'Hello, World!'"() {
        expect:
        new HelloWorld().hello() == expected

        where:
        expected = 'Hello, World!'
    }

}
