@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class PhoneNumberSpec extends Specification {
    def 'cleans the number'() {
        expect: new PhoneNumber('(223) 456-7890').number == '2234567890'
    }

    @Ignore
    def 'cleans numbers with dots'() {
        expect: new PhoneNumber('223.456.7890').number == '2234567890'
    }

    @Ignore
    def 'cleans numbers with multiple spaces'() {
        expect: new PhoneNumber('223 456   7890   ').number == '2234567890'
    }

    @Ignore
    def 'invalid when 9 digits'() {
        expect: new PhoneNumber('123456789').number == '0000000000'
    }

    @Ignore
    def 'invalid when 11 digits does not start with a 1'() {
        expect: new PhoneNumber('22234567890').number == '0000000000'
    }

    @Ignore
    def 'valid when 11 digits and starting with 1'() {
        expect: new PhoneNumber('12234567890').number == '2234567890'
    }

    @Ignore
    def 'valid when 11 digits and starting with 1 even with punctuation'() {
        expect: new PhoneNumber('+1 (223) 456-7890').number == '2234567890'
    }

    @Ignore
    def 'invalid when more than 11 digits'() {
        expect: new PhoneNumber('321234567890').number == '0000000000'
    }

    @Ignore
    def 'invalid with letters'() {
        expect: new PhoneNumber('123-abc-7890').number == '0000000000'
    }

    @Ignore
    def 'invalid with punctuations'() {
        expect: new PhoneNumber('123-@:!-7890').number == '0000000000'
    }

    @Ignore
    def 'invalid if area code starts with 0'() {
        expect: new PhoneNumber('(023) 456-7890').number == '0000000000'
    }

    @Ignore
    def 'invalid if area code starts with 1'() {
        expect: new PhoneNumber('(123) 456-7890').number == '0000000000'
    }

    @Ignore
    def 'invalid if exchange code starts with 0'() {
        expect: new PhoneNumber('(223) 056-7890').number == '0000000000'
    }

    @Ignore
    def 'invalid if exchange code starts with 1'() {
        expect: new PhoneNumber('(223) 156-7890').number == '0000000000'
    }

    @Ignore
    def 'can extract an area code from a phone number'() {
        expect: new PhoneNumber('9876543210').areaCode == '987'
    }

    @Ignore
    def 'can pretty print a phone number'() {
        expect: new PhoneNumber('5552234567').toString() == '(555) 223-4567'
    }

    @Ignore
    def 'can pretty print a full U.S. phone number'() {
        expect: new PhoneNumber('12234567890').toString() == '(223) 456-7890'
    }
}
