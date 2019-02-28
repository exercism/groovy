@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class DartsSpec extends Specification {

    def 'A dart lands outside the target'() {
        expect:
        Darts.score(-9, 9) == 0
    }

    def 'A dart lands just in the border of the target'() {
        expect:
        Darts.score(0, 10) == 1
    }

    def 'A dart lands in the outer circle'() {
        expect:
        Darts.score(4, 4) == 1
    }

    def 'A dart lands right in the border between outer and middle circles'() {
        expect:
        Darts.score(5, 0) == 5
    }

    def 'A dart lands in the middle circle'() {
        expect:
        Darts.score(0.8, -0.8) == 5
    }

    def 'A dart lands right in the border between middle and inner circles'() {
        expect:
        Darts.score(0, -1) == 10
    }

    def 'A dart lands in the inner circle'() {
        expect:
        Darts.score(-0.1, -0.1) == 10
    }

}