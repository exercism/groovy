import spock.lang.*

class PhoneNumberSpec extends Specification {
    def "Cleans the number"() {
        expect:
        PhoneNumber.clean(phrase) == expected

        where:
        phrase           || expected
        '(223) 456-7890' || '2234567890'
    }

    @Ignore
    def "Cleans numbers with dots"() {
        expect:
        PhoneNumber.clean(phrase) == expected

        where:
        phrase         || expected
        '223.456.7890' || '2234567890'
    }

    @Ignore
    def "Cleans numbers with multiple spaces"() {
        expect:
        PhoneNumber.clean(phrase) == expected

        where:
        phrase              || expected
        '223 456   7890   ' || '2234567890'
    }

    @Ignore
    def "Invalid when 9 digits"() {
        when:
        PhoneNumber.clean(phrase)

        then:
        thrown(Exception)

        where:
        phrase = '123456789'
    }

    @Ignore
    def "Invalid when 11 digits does not start with a 1"() {
        when:
        PhoneNumber.clean(phrase)

        then:
        thrown(Exception)

        where:
        phrase = '22234567890'
    }

    @Ignore
    def "Valid when 11 digits and starting with 1"() {
        expect:
        PhoneNumber.clean(phrase) == expected

        where:
        phrase        || expected
        '12234567890' || '2234567890'
    }

    @Ignore
    def "Valid when 11 digits and starting with 1 even with punctuation"() {
        expect:
        PhoneNumber.clean(phrase) == expected

        where:
        phrase              || expected
        '+1 (223) 456-7890' || '2234567890'
    }

    @Ignore
    def "Invalid when more than 11 digits"() {
        when:
        PhoneNumber.clean(phrase)

        then:
        thrown(Exception)

        where:
        phrase = '321234567890'
    }

    @Ignore
    def "Invalid with letters"() {
        when:
        PhoneNumber.clean(phrase)

        then:
        thrown(Exception)

        where:
        phrase = '523-abc-7890'
    }

    @Ignore
    def "Invalid with punctuations"() {
        when:
        PhoneNumber.clean(phrase)

        then:
        thrown(Exception)

        where:
        phrase = '523-@:!-7890'
    }

    @Ignore
    def "Invalid if area code starts with 0"() {
        when:
        PhoneNumber.clean(phrase)

        then:
        thrown(Exception)

        where:
        phrase = '(023) 456-7890'
    }

    @Ignore
    def "invalid if area code starts with 1"() {
        when:
        PhoneNumber.clean(phrase)

        then:
        thrown(Exception)

        where:
        phrase = '(123) 456-7890'
    }

    @Ignore
    def "Invalid if exchange code starts with 0"() {
        when:
        PhoneNumber.clean(phrase)

        then:
        thrown(Exception)

        where:
        phrase = '(223) 056-7890'
    }

    @Ignore
    def "Invalid if exchange code starts with 1"() {
        when:
        PhoneNumber.clean(phrase)

        then:
        thrown(Exception)

        where:
        phrase = '(223) 156-7890'
    }

    @Ignore
    def "Invalid if area code starts with 0 on valid 11-digit number"() {
        when:
        PhoneNumber.clean(phrase)

        then:
        thrown(Exception)

        where:
        phrase = '1 (023) 456-7890'
    }

    @Ignore
    def "Invalid if area code starts with 1 on valid 11-digit number"() {
        when:
        PhoneNumber.clean(phrase)

        then:
        thrown(Exception)

        where:
        phrase = '1 (123) 456-7890'
    }

    @Ignore
    def "Invalid if exchange code starts with 0 on valid 11-digit number"() {
        when:
        PhoneNumber.clean(phrase)

        then:
        thrown(Exception)

        where:
        phrase = '1 (223) 056-7890'
    }

    @Ignore
    def "Invalid if exchange code starts with 1 on valid 11-digit number"() {
        when:
        PhoneNumber.clean(phrase)

        then:
        thrown(Exception)

        where:
        phrase = '1 (223) 156-7890'
    }
    
}
