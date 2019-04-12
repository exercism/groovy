import spock.lang.*

class PhoneNumberSpec extends Specification {
    def "Cleans the number"() {
        expect:
        new PhoneNumber(phrase).number == expected

        where:
        phrase           || expected
        '(223) 456-7890' || '2234567890'
    }

    @Ignore
    def "Cleans numbers with dots"() {
        expect:
        new PhoneNumber(phrase).number == expected

        where:
        phrase         || expected
        '223.456.7890' || '2234567890'
    }

    @Ignore
    def "Cleans numbers with multiple spaces"() {
        expect:
        new PhoneNumber(phrase).number == expected

        where:
        phrase              || expected
        '223 456   7890   ' || '2234567890'
    }

    @Ignore
    def "invalid when 9 digits"() {
        expect:
        new PhoneNumber(phrase).number == expected

        where:
        phrase      || expected
        '123456789' || '0000000000'
    }

    @Ignore
    def "invalid when 11 digits does not start with a 1"() {
        expect:
        new PhoneNumber(phrase).number == expected

        where:
        phrase        || expected
        '22234567890' || '0000000000'
    }

    @Ignore
    def "valid when 11 digits and starting with 1"() {
        expect:
        new PhoneNumber(phrase).number == expected

        where:
        phrase        || expected
        '12234567890' || '2234567890'
    }

    @Ignore
    def "valid when 11 digits and starting with 1 even with punctuation"() {
        expect:
        new PhoneNumber(phrase).number == expected

        where:
        phrase              || expected
        '+1 (223) 456-7890' || '2234567890'
    }

    @Ignore
    def "invalid when more than 11 digits"() {
        expect:
        new PhoneNumber(phrase).number == expected

        where:
        phrase         || expected
        '321234567890' || '0000000000'
    }

    @Ignore
    def "invalid with letters"() {
        expect:
        new PhoneNumber(phrase).number == expected

        where:
        phrase         || expected
        '123-abc-7890' || '0000000000'
    }

    @Ignore
    def "invalid with punctuations"() {
        expect:
        new PhoneNumber(phrase).number == expected

        where:
        phrase         || expected
        '123-@:!-7890' || '0000000000'
    }

    @Ignore
    def "invalid if area code starts with 0"() {
        expect:
        new PhoneNumber(phrase).number == expected

        where:
        phrase           || expected
        '(023) 456-7890' || '0000000000'
    }

    @Ignore
    def "invalid if area code starts with 1"() {
        expect:
        new PhoneNumber(phrase).number == expected

        where:
        phrase           || expected
        '(123) 456-7890' || '0000000000'
    }

    @Ignore
    def "invalid if exchange code starts with 0"() {
        expect:
        new PhoneNumber(phrase).number == expected

        where:
        phrase           || expected
        '(223) 056-7890' || '0000000000'
    }

    @Ignore
    def "invalid if exchange code starts with 1"() {
        expect:
        new PhoneNumber(phrase).number == expected

        where:
        phrase           || expected
        '(223) 156-7890' || '0000000000'
    }

    @Ignore
    def "Can extract an area code from a phone number"() {
        expect:
        new PhoneNumber(phrase).areaCode == expected

        where:
        phrase       || expected
        '9876543210' || '987'
    }

    @Ignore
    def "Can pretty print a phone number"() {
        expect:
        new PhoneNumber(phrase).toString() == expected

        where:
        phrase       || expected
        '5552234567' || "(555) 223-4567"
    }

    @Ignore
    def "Can pretty print a full U.S. phone number"() {
        expect:
        new PhoneNumber(phrase).toString() == expected

        where:
        phrase        || expected
        '12234567890' || "(223) 456-7890"
    }
}
