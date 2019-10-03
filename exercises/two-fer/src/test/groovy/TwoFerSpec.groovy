import spock.lang.*

class TwoFerSpec extends Specification {

    def "No name given"() {
        expect:
        TwoFer.twoFer() == 'One for you, one for me.'
    }

    @Ignore
    def "Empty name given"() {
        expect:
        TwoFer.twoFer(name) == expected

        where:
        name || expected
        ''   || 'One for you, one for me.'
    }

    @Ignore
    def "A name given"() {
        expect:
        TwoFer.twoFer(name) == expected

        where:
        name    || expected
        'Alice' || 'One for Alice, one for me.'
    }

    @Ignore
    def "Another name given"() {
        expect:
        TwoFer.twoFer(name) == expected

        where:
        name  || expected
        'Bob' || 'One for Bob, one for me.'
    }
}