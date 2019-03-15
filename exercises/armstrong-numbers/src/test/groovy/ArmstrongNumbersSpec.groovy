import spock.lang.*

class ArmstrongNumbersSpec extends Specification {

    def 'Single digit numbers are Armstrong numbers'() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == result

        where:
        number | result
        5      | true
    }

    @Ignore
    def 'There are no 2 digit Armstrong numbers'() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == result

        where:
        number | result
        10     | false
    }

    @Ignore
    def 'Three digit number that is an Armstrong number'() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == result

        where:
        number | result
        153    | true
    }

    @Ignore
    def 'Three digit number that is not an Armstrong number'() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == result

        where:
        number | result
        100    | false
    }

    @Ignore
    def 'Four digit number that is an Armstrong number'() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == result

        where:
        number | result
        9474   | true
    }

    @Ignore
    def 'Four digit number that is not an Armstrong number'() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == result

        where:
        number | result
        9475   | false
    }

    @Ignore
    def 'Seven digit number that is an Armstrong number'() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == result

        where:
        number  | result
        9926315 | true
    }

    @Ignore
    def 'Seven digit number that is not an Armstrong number'() {
        expect:
        ArmstrongNumber.isArmstrongNumber(number) == result

        where:
        number  | result
        9926314 | false
    }
}
