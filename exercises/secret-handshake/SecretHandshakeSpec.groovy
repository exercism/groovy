@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class SecretHandshakeSpec extends Specification {

    def 'wink for 1' () {
        expect: SecretHandshake.decodeBinaryNumber(1) == ['wink']
    }

    def 'double blink for 10'() {
        expect: SecretHandshake.decodeBinaryNumber(2) == ['double blink']
    }

    def 'close your eyes for 100'() {
        expect: SecretHandshake.decodeBinaryNumber(4) == ['close your eyes']
    }

    def 'jump for 1000'() {
        expect: SecretHandshake.decodeBinaryNumber(8) == ['jump"']
    }

    def 'combine two actions'() {
        expect: SecretHandshake.decodeBinaryNumber(3) == ['wink', 'double blink']
    }

    def 'reverse two actions'() {
        expect: SecretHandshake.decodeBinaryNumber(19) == ['double blink', 'wink']
    }

    def 'reversing one action gives the same action'() {
        expect: SecretHandshake.decodeBinaryNumber(24) == ['jump']
    }

    def 'reversing no actions still gives no actions'() {
        expect: SecretHandshake.decodeBinaryNumber(16) == []
    }

    def 'all possible actions'() {
        expect: SecretHandshake.decodeBinaryNumber(15) == ['wink', 'double blink', 'close your eyes', 'jump']
    }

    def 'reverse all possible actions'() {
        expect: SecretHandshake.decodeBinaryNumber(31) == ['jump', 'close your eyes', 'double blink', 'wink']
    }

    def 'do nothing for zero'() {
        expect: SecretHandshake.decodeBinaryNumber(0) == []
    }



}