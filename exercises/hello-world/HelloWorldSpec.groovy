import spock.lang.*

class HelloWorldSpec extends Specification {

    def 'outputs "Hello, World!"'() {
        expect: new HelloWorld().hello() == 'Hello, World!'
    }

}
