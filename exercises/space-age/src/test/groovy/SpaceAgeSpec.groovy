import spock.lang.*

class SpaceAgeSpec extends Specification {

    def "Age on Earth"() {
        expect:
        SpaceAge.age(planet, seconds) == expected

        where:
        planet  | seconds    || expected
        'Earth' | 1000000000 || 31.69
    }

    @Ignore
    def "Age on Mercury"() {
        expect:
        SpaceAge.age(planet, seconds) == expected

        where:
        planet    | seconds    || expected
        'Mercury' | 2134835688 || 280.88
    }

    @Ignore
    def "Age on Venus"() {
        expect:
        SpaceAge.age(planet, seconds) == expected

        where:
        planet  | seconds   || expected
        'Venus' | 189839836 || 9.78
    }

    @Ignore
    def "Age on Mars"() {
        expect:
        SpaceAge.age(planet, seconds) == expected

        where:
        planet | seconds    || expected
        'Mars' | 2129871239 || 35.88
    }

    @Ignore
    def "Age on Jupiter"() {
        expect:
        SpaceAge.age(planet, seconds) == expected

        where:
        planet    | seconds   || expected
        'Jupiter' | 901876382 || 2.41
    }

    @Ignore
    def "Age on Saturn"() {
        expect:
        SpaceAge.age(planet, seconds) == expected

        where:
        planet   | seconds    || expected
        'Saturn' | 2000000000 || 2.15
    }

    @Ignore
    def "Age on Uranus"() {
        expect:
        SpaceAge.age(planet, seconds) == expected

        where:
        planet   | seconds    || expected
        'Uranus' | 1210123456 || 0.46
    }

    @Ignore
    def "Age on Neptune"() {
        expect:
        SpaceAge.age(planet, seconds) == expected

        where:
        planet    | seconds    || expected
        'Neptune' | 1821023456 || 0.35
    }

}