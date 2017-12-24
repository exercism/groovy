@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class HelloWorldSpec extends Specification {

    def 'outputs "Hello, World!"'() {
        expect: new HelloWorld().hello() == 'Hello, World!'
    }

}
