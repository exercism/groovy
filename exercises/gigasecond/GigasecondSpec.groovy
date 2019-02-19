@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*
import static java.util.Calendar.*

class GigasecondSpec extends Specification {

    def gigasecond = new Gigasecond()

    def 'calculates one gigasecond after a date'() {
        given:
            def start = Date.parse('yyyy-MMM-dd z', '2011-Apr-25 UTC')
        when:
            def result = gigasecond.from(start)
        then:
            result == Date.parse('yyyy-MMM-dd hh:mm:ss z', '2043-Jan-01 01:46:40 UTC')
    }

    @Ignore
    def 'calculates one gigasecond after a date with hours and minutes'() {
        given:
            def start = Date.parse('yyyy-MMM-dd hh:mm z', '1959-Jul-19 12:31 UTC')
        when:
            def result = gigasecond.from(start)
        then:
            result == Date.parse('yyyy-MMM-dd hh:mm:ss z', '1991-Mar-27 02:17:40 UTC')
    }

    @Ignore
    def 'calculates one gigasecond after a date with hours and minutes and seconds'() {
        given:
            def start = Date.parse('yyyy-MMM-dd hh:mm:ss z', '1977-Jun-13 02:15:45 UTC')
        when:
            def result = gigasecond.from(start)
        then:
            result == Date.parse('yyyy-MMM-dd hh:mm:ss z', '2009-Feb-19 04:02:25 UTC')
    }

}
