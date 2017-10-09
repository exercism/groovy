@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class ScrabbleScoreSpec extends Specification {

    def 'lowercase letter'() {
        expect:
        ScrabbleScore.scoreWord('a') == 1
    }

    def 'uppercase letter'() {
        expect:
        ScrabbleScore.scoreWord('A') == 1
    }

    def 'valuable letter'() {
        expect:
        ScrabbleScore.scoreWord('f') == 4
    }

    def 'empty input'() {
        expect:
        ScrabbleScore.scoreWord('') == 0
    }

    @Unroll
    def 'score for word #word should be #expectedScore'() {
        when:
        def score = ScrabbleScore.scoreWord(word)

        then:
        score == expectedScore

        where:
        word                         | expectedScore
        'at'                         | 2
        'zoo'                        | 12
        'street'                     | 6
        'quirky'                     | 22
        'OxyphenButazone'            | 41
        'pinata'                     | 8
        'abcdefghijklmnopqrstuvwxyz' | 87
    }

}
