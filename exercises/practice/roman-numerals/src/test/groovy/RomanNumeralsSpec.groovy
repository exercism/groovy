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
        16     || 'XVI'
        27     || 'XXVII'
        48     || 'XLVIII'
        49     || 'XLIX'
        59     || 'LIX'
        66     || 'LXVI'
        93     || 'XCIII'
        141    || 'CXLI'
        163    || 'CLXIII'
        166    || 'CLXVI'
        402    || 'CDII'
        575    || 'DLXXV'
        666    || 'DCLXVI'
        911    || 'CMXI'
        1024   || 'MXXIV'
        1666   || 'MDCLXVI'
        3000   || 'MMM'
        3001   || 'MMMI'
        3888   || 'MMMDCCCLXXXVIII'
        3999   || 'MMMCMXCIX'
    }

}
