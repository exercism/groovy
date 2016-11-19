import spock.lang.Specification;

public class HelloWorldSpec extends Specification {

    def helloWorld = new HelloWorld()

    def 'greets the world when given no name parameter'() {
        expect: helloWorld.hello() == 'Hello, World!'
    }

    def 'greets Alice when passed her name'() {
        expect: helloWorld.hello('Alice') == 'Hello, Alice!'
    }

    def 'greets Bob when passed his name'() {
        expect: helloWorld.hello('Bob') == 'Hello, Bob!'
    }

}
