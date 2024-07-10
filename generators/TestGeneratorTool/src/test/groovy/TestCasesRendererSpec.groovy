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

    def "Can render test class with a single test method"() {
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
        FooBar.foo(word) == expected

        where:
        word   || expected
        "time" || "emit"
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
        exceptionThrown.message == "You should never bar a number"

        where:
        firstName | lastName
        "HAL"     | 9000
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
//        FooBar.foo(word) == expected
//
//        where:
//        word                                                                            || expected
//        "28948022309329048855892746252171976962977213799489202546401021394546514198529" || null
//    }
}'''
    }
}
