import spock.lang.*

class TestCasesRendererSpec extends Specification {
    def "Can render an empty test class"() {
        when:
        String sample = '''{
  "exercise": "foo-bar"
}'''
        CanonicalDataParser specification = new CanonicalDataParser(sample)
        String renderedTests = TestCasesRenderer.render(specification, [] as Set<UUID>)

        then:
        renderedTests == '''import spock.lang.*

class FooBarSpec extends Specification {
}'''
    }

    def "Can render test class with a single test method and expected string"() {
        when:
        String sample = '''{
  "exercise": "foo-bar",
  "cases": [
    {
      "uuid": "31e9db74-86b9-4b14-a320-9ea910337289",
      "description": "Foo a word to reverse it",
      "property": "foo",
      "input": {
        "word": "time"
      },
      "expected": "emit"
    }
  ]
}'''
        CanonicalDataParser specification = new CanonicalDataParser(sample)
        String renderedTests = TestCasesRenderer.render(specification, [] as Set<UUID>)

        then:
        renderedTests == '''import spock.lang.*

class FooBarSpec extends Specification {
    def "Foo a word to reverse it"() {
        expect:
        FooBar.foo(word) == expectedResult

        where:
        word   || expectedResult
        "time" || "emit"
    }
}'''
    }

    def "Can render test class with a single test method and expected integer"() {
        when:
        String sample = '''{
  "exercise": "foo-bar",
  "cases": [
    {
      "uuid": "31e9db74-86b9-4b14-a320-9ea910337289",
      "description": "Foo a number to double it",
      "property": "foo",
      "input": {
        "number": 21
      },
      "expected": 42
    }
  ]
}'''
        CanonicalDataParser specification = new CanonicalDataParser(sample)
        String renderedTests = TestCasesRenderer.render(specification, [] as Set<UUID>)

        then:
        renderedTests == '''import spock.lang.*

class FooBarSpec extends Specification {
    def "Foo a number to double it"() {
        expect:
        FooBar.foo(number) == expectedResult

        where:
        number || expectedResult
        21     || 42
    }
}'''
    }

    def "Can render test class with a single test method and expected float"() {
        when:
        String sample = '''{
  "exercise": "foo-bar",
  "cases": [
    {
      "uuid": "31e9db74-86b9-4b14-a320-9ea910337289",
      "description": "Foo a number to double it",
      "property": "foo",
      "input": {
        "number": 2.125
      },
      "expected": 4.25
    }
  ]
}'''
        CanonicalDataParser specification = new CanonicalDataParser(sample)
        String renderedTests = TestCasesRenderer.render(specification, [] as Set<UUID>)

        then:
        renderedTests == '''import spock.lang.*

class FooBarSpec extends Specification {
    def "Foo a number to double it"() {
        expect:
        FooBar.foo(number) == expectedResult

        where:
        number || expectedResult
        2.125  || 4.25
    }
}'''
    }

    def "Can render test class with a single test method and expected boolean"() {
        when:
        String sample = '''{
  "exercise": "foo-bar",
  "cases": [
    {
      "uuid": "31e9db74-86b9-4b14-a320-9ea910337289",
      "description": "Foo a logic value to negate it",
      "property": "foo",
      "input": {
        "flag": true
      },
      "expected": false
    }
  ]
}'''
        CanonicalDataParser specification = new CanonicalDataParser(sample)
        String renderedTests = TestCasesRenderer.render(specification, [] as Set<UUID>)

        then:
        renderedTests == '''import spock.lang.*

class FooBarSpec extends Specification {
    def "Foo a logic value to negate it"() {
        expect:
        FooBar.foo(flag) == expectedResult

        where:
        flag || expectedResult
        true || false
    }
}'''
    }

    def "Can render test class with a single test method and expected null"() {
        when:
        String sample = '''{
  "exercise": "foo-bar",
  "cases": [
    {
      "uuid": "31e9db74-86b9-4b14-a320-9ea910337289",
      "description": "Foo a value to nullify it",
      "property": "foo",
      "input": {
        "something": "made from air"
      },
      "expected": null
    }
  ]
}'''
        CanonicalDataParser specification = new CanonicalDataParser(sample)
        String renderedTests = TestCasesRenderer.render(specification, [] as Set<UUID>)

        then:
        renderedTests == '''import spock.lang.*

class FooBarSpec extends Specification {
    def "Foo a value to nullify it"() {
        expect:
        FooBar.foo(something) == expectedResult

        where:
        something       || expectedResult
        "made from air" || null
    }
}'''
    }

    def "Can render several test methods inside test class"() {
        when:
        String sample = '''{
  "exercise": "foo-bar",
  "cases": [
    {
      "uuid": "31e9db74-86b9-4b14-a320-9ea910337289",
      "description": "Foo a word to reverse it",
      "property": "foo",
      "input": {
        "word": "time"
      },
      "expected": "emit"
    },
    {
      "uuid": "09113ce5-b008-45d0-98af-c0378b64966b",
      "description": "Bar a name to combine its parts",
      "property": "bar",
      "input": {
        "firstName": "Alan",
        "lastName": "Smith"
      },
      "expected": "Alan Smith"
    },
    {
      "uuid": "f22d7a03-e752-4f14-9231-4eae9f128cef",
      "description": "Foo of a number returns nothing",
      "property": "foo",
      "input": {
        "word": 42
      },
      "expected": null
    }
  ]
}'''
        CanonicalDataParser specification = new CanonicalDataParser(sample)
        String renderedTests = TestCasesRenderer.render(specification, [] as Set<UUID>)

        then:
        renderedTests == '''import spock.lang.*

class FooBarSpec extends Specification {
    def "Foo a word to reverse it"() {
        expect:
        FooBar.foo(word) == expectedResult

        where:
        word   || expectedResult
        "time" || "emit"
    }

    @Ignore
    def "Bar a name to combine its parts"() {
        expect:
        FooBar.bar(firstName, lastName) == expectedResult

        where:
        firstName | lastName || expectedResult
        "Alan"    | "Smith"  || "Alan Smith"
    }

    @Ignore
    def "Foo of a number returns nothing"() {
        expect:
        FooBar.foo(word) == expectedResult

        where:
        word || expectedResult
        42   || null
    }
}'''
    }

    def "Can render test method with an error assertion"() {
        when:
        String sample = '''{
  "exercise": "foo-bar",
  "cases": [
    {
      "uuid": "c7b6f24a-553f-475a-8a40-dba854fe1bff",
      "description": "Bar a name with numbers gives an error",
      "property": "bar",
      "input": {
        "firstName": "HAL",
        "lastName": 9000
      },
      "expected": {
        "error": "You should never bar a number"
      }
    }
  ]
}'''
        CanonicalDataParser specification = new CanonicalDataParser(sample)
        String renderedTests = TestCasesRenderer.render(specification, [] as Set<UUID>)

        then:
        renderedTests == '''import spock.lang.*

class FooBarSpec extends Specification {
    def "Bar a name with numbers gives an error"() {
        when:
        FooBar.bar(firstName, lastName)

        then:
        IllegalArgumentException exceptionThrown = thrown(IllegalArgumentException)
        exceptionThrown.message == expectedErrorMessage

        where:
        firstName | lastName || expectedErrorMessage
        "HAL"     | 9000     || "You should never bar a number"
    }
}'''
    }

    def "Can comment out excluded tests"() {
        when:
        String sample = '''{
  "exercise": "foo-bar",
  "cases": [
    {
      "uuid": "8790a635-e8a8-4343-a29f-7da2929b9378",
      "description": "Foo of a very big number returns nothing",
      "comments": ["Making this test case pass requires using big integer library."],
      "scenarios": ["big-integers"],
      "property": "foo",
      "input": {
        "word": "28948022309329048855892746252171976962977213799489202546401021394546514198529"
      },
      "expected": null
    }
  ]
}'''
        CanonicalDataParser specification = new CanonicalDataParser(sample)
        String renderedTests = TestCasesRenderer.render(specification, [UUID.fromString('8790a635-e8a8-4343-a29f-7da2929b9378')] as Set<UUID>)

        then:
        renderedTests == '''import spock.lang.*

class FooBarSpec extends Specification {
//    def "Foo of a very big number returns nothing"() {
//        expect:
//        FooBar.foo(word) == expectedResult
//
//        where:
//        word                                                                            || expectedResult
//        "28948022309329048855892746252171976962977213799489202546401021394546514198529" || null
//    }
}'''
    }
}
