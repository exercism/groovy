import spock.lang.*

class RomanNumeralsSpec extends Specification {

    // register metaclass on Integers
    def setup() { new RomanNumerals() }

    @Unroll
    def "Can convert arabic #arabic to roman #expected"() {
        expect:
        arabic.roman == expected

        where:
        arabic || expected
        1      || 'I'
        2      || 'II'
        3      || 'III'
        4      || 'IV'
        5      || 'V'
        6      || 'VI'
        9      || 'IX'
        27     || 'XXVII'
        48     || 'XLVIII'
        59     || 'LIX'
        93     || 'XCIII'
        141    || 'CXLI'
        163    || 'CLXIII'
        402    || 'CDII'
        575    || 'DLXXV'
        911    || 'CMXI'
        1024   || 'MXXIV'
        3000   || 'MMM'
    }

}
