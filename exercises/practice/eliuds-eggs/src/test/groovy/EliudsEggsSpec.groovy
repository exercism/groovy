import spock.lang.*

class EliudsEggsSpec extends Specification {

    def "0 eggs"() {
        expect:
        EliudsEggs.eggCount(number) == expected

        where:
        number = 0
        expected = 0
    }

    @Ignore
    def "1 egg"() {
        expect:
        EliudsEggs.eggCount(number) == expected

        where:
        number = 16
        expected = 1
    }

    @Ignore
    def "4 eggs"() {
        expect:
        EliudsEggs.eggCount(number) == expected

        where:
        number = 89
        expected = 4
    }

    @Ignore
    def "13 eggs"() {
        expect:
        EliudsEggs.eggCount(number) == expected

        where:
        number = 2000000000
        expected = 13
    }

}
