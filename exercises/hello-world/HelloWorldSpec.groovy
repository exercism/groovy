@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class HelloWorldSpec extends Specification {

    def 'outputs "Hello, World!"'() {
        expect: new HelloWorld().hello() == 'Hello, World!'
    }

    @Ignore
    def 'outputs "Hello, Alice!" when given the name "Alice"'() {
        expect: new HelloWorld().hello('Alice') == 'Hello, Alice!'
    }

    @Ignore
    def 'outputs "Hello, Bob!" when given the name "Bob"'() {
        expect: new HelloWorld().hello('Bob') == 'Hello, Bob!'
    }

}
