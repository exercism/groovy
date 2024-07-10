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
        FooBar.foo(word) == expected

        where:
        word   || expected
        "time" || "emit"
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
                    },
                    {
                        uuid 'f22d7a03-e752-4f14-9231-4eae9f128cef'
                        description 'Foo of a number returns nothing'
                        property 'foo'
                        input {
                            word 42
                        }
                        expected null
                    },
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
        FooBar.foo(word) == expected

        where:
        word   || expected
        "time" || "emit"
    }

    @Ignore
    def "Bar a name to combine its parts"() {
        expect:
        FooBar.bar(firstName, lastName) == expected

        where:
        firstName | lastName || expected
        "Alan"    | "Smith"  || "Alan Smith"
    }

    @Ignore
    def "Foo of a number returns nothing"() {
        expect:
        FooBar.foo(word) == expected

        where:
        word || expected
        42   || null
    }
}'''
    }

    def "It can render test method with an error assertion"() {
        when:
        JsonBuilder builder = new JsonBuilder()
        builder {
            exercise 'foo-bar'
            cases([
                    {
                        uuid 'c7b6f24a-553f-475a-8a40-dba854fe1bff'
                        description 'Bar a name with numbers gives an error'
                        property 'bar'
                        input {
                            firstName 'HAL'
                            lastName 900
                        }
                        expected {
                            error 'You should never bar a number'
                        }
                    }
            ])
        }
        String sample = builder.toString()
        CanonicalDataParser specification = new CanonicalDataParser(sample)
        String renderedTests = TestCasesRenderer.render(specification)

        then:
        renderedTests == '''import spock.lang.*

class FooBarSpec extends Specification {
    def "Bar a name with numbers gives an error"() {
        when:
        FooBar.bar(firstName, lastName)

        then:
        IllegalArgumentException exceptionThrown = thrown(IllegalArgumentException)
        exceptionThrown.message == "You should never bar a number"

        where:
        firstName | lastName
        "HAL"     | 900
    }
}'''
    }
}
