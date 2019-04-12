import spock.lang.*

class IsbnVerifierSpec extends Specification {

    def "Valid isbn number"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn            || expected
        '3-598-21508-8' || true
    }

    @Ignore
    def "Invalid isbn check digit"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn            || expected
        '3-598-21508-9' || false
    }

    @Ignore
    def "Valid isbn number with a check digit of 10"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn            || expected
        '3-598-21507-X' || true
    }

    @Ignore
    def "Check digit is a character other than X"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn            || expected
        '3-598-21507-A' || false
    }

    @Ignore
    def "Invalid character in isbn"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn            || expected
        '3-598-P1581-X' || false
    }

    @Ignore
    def "X is only valid as a check digit"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn            || expected
        '3-598-2X507-9' || false
    }

    @Ignore
    def "Valid isbn without separating dashes"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn         || expected
        '3598215088' || true
    }

    @Ignore
    def "Isbn without separating dashes and X as check digit"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn         || expected
        '359821507X' || true
    }

    @Ignore
    def "Isbn without check digit and dashes"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn        || expected
        '359821507' || false
    }

    @Ignore
    def "Too long isbn and no dashes"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn        || expected
        '359821507' || false
    }

    @Ignore
    def "Too short isbn"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn || expected
        '00' || false
    }

    @Ignore
    def "Isbn without check digit"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn          || expected
        '3-598-21507' || false
    }

    @Ignore
    def "Check digit of X should not be used for 0"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn            || expected
        '3-598-21515-X' || false
    }

    @Ignore
    def "Empty isbn"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn || expected
        ''   || false
    }

    @Ignore
    def "Input is 9 characters"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn        || expected
        '134456729' || false
    }

    @Ignore
    def "Invalid characters are not ignored"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn         || expected
        '3132P34035' || false
    }

    @Ignore
    def "Input is too long but contains a valid isbn"() {
        expect:
        IsbnVerifier.isValid(isbn) == expected

        where:
        isbn          || expected
        '98245726788' || false
    }
}