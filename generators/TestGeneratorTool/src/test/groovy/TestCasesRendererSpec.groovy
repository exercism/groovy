import groovy.json.JsonBuilder
import spock.lang.*

class TestCasesRendererSpec extends Specification {
    def "It can render an empty test class"() {
        when:
        JsonBuilder builder = new JsonBuilder()
        builder {
            exercise 'foo-bar'
            cases()
        }
        String sample = builder.toString()
        CanonicalDataParser specification = new CanonicalDataParser(sample)
        String renderedTests = TestCasesRenderer.render(specification)

        then:
        renderedTests == '''import spock.lang.*

class FooBarSpec extends Specification {
}'''
    }

    def "It can render test class with a single test method"() {
        when:
        JsonBuilder builder = new JsonBuilder()
        builder {
            exercise 'foo-bar'
            cases([
                    {
                        uuid '31e9db74-86b9-4b14-a320-9ea910337289'
                        description 'Foo a word to reverse it'
                        property 'foo'
                        input {
                            word 'time'
                        }
                        expected 'emit'
                    }
            ])
        }
        String sample = builder.toString()
        CanonicalDataParser specification = new CanonicalDataParser(sample)
        String renderedTests = TestCasesRenderer.render(specification)

        then:
        renderedTests == '''import spock.lang.*

class FooBarSpec extends Specification {
    def "Foo a word to reverse it"() {
        expect:
        given == expected

        where:
        // Please check the "foo" property
        // Please use the following input: {"word":"time"}
        // Please expect the following: "emit"
    }
}'''
    }

    def "It can render several test methods inside test class"() {
        when:
        JsonBuilder builder = new JsonBuilder()
        builder {
            exercise 'foo-bar'
            cases(
                    {
                        uuid '31e9db74-86b9-4b14-a320-9ea910337289'
                        description 'Foo a word to reverse it'
                        property 'foo'
                        input {
                            word 'time'
                        }
                        expected 'emit'
                    },
                    {
                        uuid '09113ce5-b008-45d0-98af-c0378b64966b'
                        description 'Bar a name to combine its parts'
                        property 'bar'
                        input {
                            firstName 'Alan'
                            lastName 'Smith'
                        }
                        expected 'Alan Smith'
                    }
            )
        }
        String sample = builder.toString()
        CanonicalDataParser specification = new CanonicalDataParser(sample)
        String renderedTests = TestCasesRenderer.render(specification)

        then:
        renderedTests == '''import spock.lang.*

class FooBarSpec extends Specification {
    def "Foo a word to reverse it"() {
        expect:
        given == expected

        where:
        // Please check the "foo" property
        // Please use the following input: {"word":"time"}
        // Please expect the following: "emit"
    }
    def "Bar a name to combine its parts"() {
        expect:
        given == expected

        where:
        // Please check the "bar" property
        // Please use the following input: {"firstName":"Alan","lastName":"Smith"}
        // Please expect the following: "Alan Smith"
    }
}'''
    }
}
