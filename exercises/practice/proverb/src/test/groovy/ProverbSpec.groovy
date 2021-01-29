import spock.lang.*

class ProverbSpec extends Specification {

    def "Zero pieces"() {
        expect:
        Proverb.recite(strings) == expected

        where:
        strings = []
        expected = ''
    }

    @Ignore
    def "One piece"() {
        expect:
        Proverb.recite(strings) == expected

        where:
        strings = [
                'nail'
        ]
        expected = 'And all for the want of a nail.'
    }

    @Ignore
    def "Two pieces"() {
        expect:
        Proverb.recite(strings) == expected

        where:
        strings = [
                'nail',
                'shoe'
        ]
        expected = 'For want of a nail the shoe was lost.\n' +
                'And all for the want of a nail.'
    }

    @Ignore
    def "Three pieces"() {
        expect:
        Proverb.recite(strings) == expected

        where:
        strings = [
                'nail',
                'shoe',
                'horse'
        ]
        expected = 'For want of a nail the shoe was lost.\n' +
                'For want of a shoe the horse was lost.\n' +
                'And all for the want of a nail.'
    }

    @Ignore
    def "Full proverb"() {
        expect:
        Proverb.recite(strings) == expected

        where:
        strings = [
                'nail',
                'shoe',
                'horse',
                'rider',
                'message',
                'battle',
                'kingdom'
        ]
        expected = 'For want of a nail the shoe was lost.\n' +
                'For want of a shoe the horse was lost.\n' +
                'For want of a horse the rider was lost.\n' +
                'For want of a rider the message was lost.\n' +
                'For want of a message the battle was lost.\n' +
                'For want of a battle the kingdom was lost.\n' +
                'And all for the want of a nail.'
    }

    @Ignore
    def "Four pieces modernized"() {
        expect:
        Proverb.recite(strings) == expected

        where:
        strings = [
                'pin',
                'gun',
                'soldier',
                'battle'
        ]
        expected = 'For want of a pin the gun was lost.\n' +
                'For want of a gun the soldier was lost.\n' +
                'For want of a soldier the battle was lost.\n' +
                'And all for the want of a pin.'
    }

}