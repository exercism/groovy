import spock.lang.*

class ETLSpec extends Specification {

    def "A single letter"() {
        expect:
        ETL.transform(input) == expected

        where:
        input = ['1': ['A']]
        expected = ['a': 1]
    }

    @Ignore
    def "Single score with multiple letters"() {
        expect:
        ETL.transform(input) == expected

        where:
        input = ['1': ['A', 'E', 'I', 'O', 'U']]
        expected = ['a': 1, 'e': 1, 'i': 1, 'o': 1, 'u': 1]
    }

    @Ignore
    def "Multiple scores with multiple letters"() {
        expect:
        ETL.transform(input) == expected

        where:
        input = ['1': ['A', 'E'],
                 '2': ['D', 'G']]
        expected = ['a': 1, 'd': 2, 'e': 1, 'g': 2]
    }

    @Ignore
    def "Multiple scores with differing numbers of letters"() {
        expect:
        ETL.transform(input) == expected

        where:
        input = ['1' : ['A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'],
                 '2' : ['D', 'G'],
                 '3' : ['B', 'C', 'M', 'P'],
                 '4' : ['F', 'H', 'V', 'W', 'Y'],
                 '5' : ['K'],
                 '8' : ['J', 'X'],
                 '10': ['Q', 'Z']]
        expected = ['a': 1, 'b': 3, 'c': 3, 'd': 2, 'e': 1,
                    'f': 4, 'g': 2, 'h': 4, 'i': 1, 'j': 8,
                    'k': 5, 'l': 1, 'm': 3, 'n': 1, 'o': 1,
                    'p': 3, 'q': 10, 'r': 1, 's': 1, 't': 1,
                    'u': 1, 'v': 4, 'w': 4, 'x': 8, 'y': 4,
                    'z': 10]
    }
}