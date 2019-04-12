import spock.lang.*

class LeapSpec extends Specification {

    def "Year not divisible by 4 in common year"() {
        expect:
        new Leap(year).isLeapYear() == expected

        where:
        year || expected
        2015 || false
    }

    @Ignore
    def "Year divisible by 2, not divisible by 4 in common year"() {
        expect:
        new Leap(year).isLeapYear() == expected

        where:
        year || expected
        1970 || false
    }

    @Ignore
    def "Year divisible by 4, not divisible by 100 in leap year"() {
        expect:
        new Leap(year).isLeapYear() == expected

        where:
        year || expected
        1996 || true
    }

    @Ignore
    def "Year divisible by 100, not divisible by 400 in common year"() {
        expect:
        new Leap(year).isLeapYear() == expected

        where:
        year || expected
        2100 || false
    }

    @Ignore
    def "Year divisible by 400 in leap year"() {
        expect:
        new Leap(year).isLeapYear() == expected

        where:
        year || expected
        2000 || true
    }

    @Ignore
    def "Year divisible by 200, not divisible by 400 in common year"() {
        expect:
        new Leap(year).isLeapYear() == expected

        where:
        year || expected
        1800 || false
    }

}
