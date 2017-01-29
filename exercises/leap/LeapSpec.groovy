@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class LeapSpec extends Specification {

    def 'a year not divisible by 4 is not a leap year'() {
        expect: new Year(2015).isLeapYear() == false
    }

    @Ignore
    def 'a year divisible by 4, but not 100, is a leap year'() {
        expect: new Year(2016).isLeapYear() == true
    }

    @Ignore
    def 'a year divisible by 100, but not 400, is not a leap year'() {
        expect: new Year(2100).isLeapYear() == false
    }

    @Ignore
    def 'a year divisible by 400 is a leap year'() {
        expect: new Year(2000).isLeapYear() == true
    }

}
