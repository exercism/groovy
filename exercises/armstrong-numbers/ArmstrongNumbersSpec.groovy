@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*
import static java.util.Calendar.*

class ArmstrongNumbersSpec extends Specification {

    def ArmstrongNumber = new ArmstrongNumber()

    def 'Single digit numbers are Armstrong numbers'() {
        given:
            def input = 5
        when:
            def result = ArmstrongNumber.isArmstrongNumber(input)
        then:
            result == true
    }

    def 'There are no 2 digit Armstrong numbers'() {
        given:
            def input = 10
        when:
            def result = ArmstrongNumber.isArmstrongNumber(input)
        then:
            result == false
    }

    def 'Three digit number that is an Armstrong number'() {
        given:
            def input = 153
        when:
            def result = ArmstrongNumber.isArmstrongNumber(input)
        then:
            result == true
    }

    def 'Three digit number that is not an Armstrong number'() {
        given:
            def input = 100
        when:
            def result = ArmstrongNumber.isArmstrongNumber(input)
        then:
            result == false
    }

    def 'Four digit number that is an Armstrong number'() {
        given:
            def input = 9474
        when:
            def result = ArmstrongNumber.isArmstrongNumber(input)
        then:
            result == true
    }

    def 'Four digit number that is not an Armstrong number'() {
        given:
            def input = 9475
        when:
            def result = ArmstrongNumber.isArmstrongNumber(input)
        then:
            result == false
    }

    def 'Seven digit number that is an Armstrong number'() {
        given:
            def input = 9926315
        when:
            def result = ArmstrongNumber.isArmstrongNumber(input)
        then:
            result == true
    }

    def 'Seven digit number that is not an Armstrong number'() {
        given:
            def input = 9926314
        when:
            def result = ArmstrongNumber.isArmstrongNumber(input)
        then:
            result == false
    }
}
