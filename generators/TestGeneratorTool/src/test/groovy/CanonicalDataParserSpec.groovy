import spock.lang.*

class CanonicalDataParserSpec extends Specification {

    @Shared
    String sample

    def setupSpec() {
        sample = '''{
  "exercise": "foo-bar",
  "comments": [
    " Comments are always optional and can be used almost anywhere.      ",
    "                                                                    ",
    " They usually document how the exercise's readme ('description.md') ",
    " is generally interpreted in test programs across different         ",
    " languages.                                                         ",
    "                                                                    ",
    " In addition to a mainstream implementation path, this information  ",
    " can also document significant variations.                          "
  ],
  "cases": [
    {
      "comments": [
        " A test case must have 'uuid', 'description', 'property', ",
        " 'input' and 'expected' properties. The rest is optional. ",
        "                                                          ",
        " The 'property' is a string in lowerCamelCase identifying ",
        " the type of test, but most of the times it is just the   ",
        " name of a function being tested.                         ",
        "                                                          ",
        " Test cases can have any number of additional keys, and   ",
        " most of them also have an 'expected' one, defining the   ",
        " value a test should return.                              "
      ],
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
      "comments": [
        " Test cases can be arbitrarily grouped with a description ",
        " to make organization easier.                             "
      ],
      "description": "Abnormal inputs: numbers",
      "cases": [
        {
          "uuid": "f22d7a03-e752-4f14-9231-4eae9f128cef",
          "description": "Foo of a number returns nothing",
          "property": "foo",
          "input": {
            "word": 42
          },
          "expected": null
        },
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
        },
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
    }
  ]
}'''
    }

    def "Can retrieve exercise slug"() {
        expect:
        new CanonicalDataParser(sample).exerciseSlug == 'foo-bar'
    }

    def "Can retrieve data for each test case"() {
        when:
        CanonicalDataParser specification = new CanonicalDataParser(sample)
        ArrayList<LabeledTestCase> testCases = specification.labeledTestCases

        then:
        testCases.size() == 5
        testCases[0].identifier == UUID.fromString('31e9db74-86b9-4b14-a320-9ea910337289')
        testCases[1].property == 'bar'
        testCases[2].input == [word: 42]
        testCases[3].description == 'Foo of a very big number returns nothing'
        testCases[4].expected == [error: 'You should never bar a number']
    }
}
