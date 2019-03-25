import spock.lang.*

class HammingSpec extends Specification {

    @Shared
    def hamming = new Hamming()

    def 'empty strands'() {
        expect:
        hamming.distance(strand1, strand2) == expected

        where:
        strand1 | strand2 | expected
        ""      | ""      | 0
    }

    def 'single letter identical strands'() {
        expect:
        hamming.distance(strand1, strand2) == expected

        where:
        strand1 | strand2 | expected
        "A"     | "A"     | 0
    }

    @Ignore
    def 'single letter different strands'() {
        expect:
        hamming.distance(strand1, strand2) == expected

        where:
        strand1 | strand2 | expected
        "G"     | "T"     | 1
    }

    @Ignore
    def 'long identical strands'() {
        expect:
        hamming.distance(strand1, strand2) == expected

        where:
        strand1         | strand2         | expected
        "GGACTGAAATCTG" | "GGACTGAAATCTG" | 0
    }

    @Ignore
    def 'long different strands'() {
        expect:
        hamming.distance(strand1, strand2) == expected

        where:
        strand1        | strand2        | expected
        "GGACGGATTCTG" | "AGGACGGATTCT" | 9
    }

    @Ignore
    def 'disallow first strand longer'() {
        when:
        hamming.distance(strand1, strand2)

        then:
        thrown(ArithmeticException)

        where:
        strand1 | strand2
        "AATG"  | "AAA"
    }

    @Ignore
    def 'disallow second strand longer'() {
        when:
        hamming.distance(strand1, strand2)

        then:
        thrown(ArithmeticException)

        where:
        strand1 | strand2
        "ATA"   | "AGTG"
    }

    @Ignore
    def 'disallow left empty strand'() {
        when:
        hamming.distance(strand1, strand2)

        then:
        thrown(ArithmeticException)

        where:
        strand1 | strand2
        ""      | "G"
    }

    @Ignore
    def 'disallow right empty strand'() {
        when:
        hamming.distance(strand1, strand2)

        then:
        thrown(ArithmeticException)

        where:
        strand1 | strand2
        "G"     | ""
    }

}
