@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class RomanSpec extends Specification {

    // register metaclass on Integers
    def setup() { new Roman() }

    @Unroll
    def "can convert arabic #arabic to roman #roman"() {
        expect:
            arabic.toRoman() == roman
        where:
            arabic | roman
            1      | 'I'
            2      | 'II'
            3      | 'III'
            4      | 'IV'
            5      | 'V'
            6      | 'VI'
            9      | 'IX'
            27     | 'XXVII'
            48     | 'XLVIII'
            59     | 'LIX'
            93     | 'XCIII'
            141    | 'CXLI'
            163    | 'CLXIII'
            402    | 'CDII'
            575    | 'DLXXV'
            911    | 'CMXI'
            1024   | 'MXXIV'
            3000   | 'MMM'
    }

}
