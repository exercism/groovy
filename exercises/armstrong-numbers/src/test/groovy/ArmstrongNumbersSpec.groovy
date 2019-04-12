import spock.lang.*

class ArmstrongNumbersSpec extends Specification {

    def "Zero is an Armstrong number"() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == expected

        where:
        number || expected
        0      || true
    }

    @Ignore
    def "Single digit numbers are Armstrong numbers"() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == expected

        where:
        number || expected
        5      || true
    }

    @Ignore
    def "There are no 2 digit Armstrong numbers"() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == expected

        where:
        number || expected
        10     || false
    }

    @Ignore
    def "Three digit number that is an Armstrong number"() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == expected

        where:
        number || expected
        153    || true
    }

    @Ignore
    def "Three digit number that is not an Armstrong number"() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == expected

        where:
        number || expected
        100    || false
    }

    @Ignore
    def "Four digit number that is an Armstrong number"() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == expected

        where:
        number || expected
        9474   || true
    }

    @Ignore
    def "Four digit number that is not an Armstrong number"() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == expected

        where:
        number || expected
        9475   || false
    }

    @Ignore
    def "Seven digit number that is an Armstrong number"() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == expected

        where:
        number  || expected
        9926315 || true
    }

    @Ignore
    def "Seven digit number that is not an Armstrong number"() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == expected

        where:
        number  || expected
        9926314 || false
    }
}
