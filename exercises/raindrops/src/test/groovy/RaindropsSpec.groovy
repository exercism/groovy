import spock.lang.*

class RaindropsSpec extends Specification {

    @Shared
    def raindrops = new Raindrops()

    def "The sound for 1 is 1"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        1      || '1'
    }

    @Ignore
    def "The sound for 3 is Pling"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        3      || 'Pling'
    }

    @Ignore
    def "The sound for 5 is Plang"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        5      || 'Plang'
    }

    @Ignore
    def "The sound for 7 is Plong"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        7      || 'Plong'
    }

    @Ignore
    def "The sound for 6 is Pling as it has a factor 3"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        6      || 'Pling'
    }

    @Ignore
    def "2 to the power 3 does not make a raindrop sound as 3 is the exponent not the base"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        8      || '8'
    }

    @Ignore
    def "The sound for 9 is Pling as it has a factor 3"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        9      || 'Pling'
    }

    @Ignore
    def "The sound for 10 is Plang as it has a factor 5"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        10     || 'Plang'
    }

    @Ignore
    def "The sound for 14 is Plong as it has a factor of 7"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        14     || 'Plong'
    }

    @Ignore
    def "The sound for 15 is PlingPlang as it has factors 3 and 5"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        15     || 'PlingPlang'
    }

    @Ignore
    def "The sound for 21 is PlingPlong as it has factors 3 and 7"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        21     || 'PlingPlong'
    }

    @Ignore
    def "The sound for 25 is Plang as it has a factor 5"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        25     || 'Plang'
    }

    @Ignore
    def "The sound for 27 is Pling as it has a factor 3"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        27     || 'Pling'
    }

    @Ignore
    def "The sound for 35 is PlangPlong as it has factors 5 and 7"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        35     || 'PlangPlong'
    }

    @Ignore
    def "The sound for 49 is Plong as it has a factor 7"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        49     || 'Plong'
    }

    @Ignore
    def "The sound for 52 is 52"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        52     || '52'
    }

    @Ignore
    def "The sound for 105 is PlingPlangPlong as it has factors 3, 5 and 7"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        105    || 'PlingPlangPlong'
    }

    @Ignore
    def "The sound for 3125 is Plang as it has a factor 5"() {
        expect:
        raindrops.convert(number) == expected

        where:
        number || expected
        3125   || 'Plang'
    }

}
