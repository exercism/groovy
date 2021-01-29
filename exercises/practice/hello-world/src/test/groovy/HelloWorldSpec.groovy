import spock.lang.*

class HelloWorldSpec extends Specification {

    def "Say Hi!"() {
        expect:
        new HelloWorld().hello() == expected

        where:
        expected = 'Hello, World!'
    }

}
