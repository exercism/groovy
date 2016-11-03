@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class HelloWorldSpec extends Specification {

    @Shared
    def hello = new HelloWorld()

    def 'outputs "Hello, World!"'() {
        expect: hello.hello() == 'Hello, World!'
    }

    @Ignore
    def 'outputs "Hello, Alice!" when given the name "Alice"'() {
        expect: hello.hello('Alice') == 'Hello, Alice!'
    }

    @Ignore
    def 'outputs "Hello, Bob!" when given the name "Bob"'() {
        expect: hello.hello('Bob') == 'Hello, Bob!'
    }

}
