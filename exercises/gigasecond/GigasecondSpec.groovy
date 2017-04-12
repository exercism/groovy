#!/usr/bin/env groovy
@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*
import static java.util.Calendar.*

class GigasecondSpec extends Specification {

    def gigasecond = new Gigasecond()

    def 'calculates one gigasecond after a date'() {
        given:
            def start = Date.parse('yyyy-MMM-dd', '2011-Apr-25')
        when:
            def result = gigasecond.from(start)
        then:
            result == Date.parse('yyyy-MMM-dd hh:mm:ss', '2043-Jan-01 00:46:40')
    }

    @Ignore
    def 'calculates one gigasecond after a date with hours and minutes'() {
        given:
            def start = Date.parse('yyyy-MMM-dd hh:mm', '1959-Jul-19 12:31')
        when:
            def result = gigasecond.from(start)
        then:
            result == Date.parse('yyyy-MMM-dd hh:mm:ss', '1991-Mar-27 01:17:40')
    }

    @Ignore
    def 'calculates one gigasecond after a date with hours and minutes and seconds'() {
        given:
            def start = Date.parse('yyyy-MMM-dd hh:mm:ss', '1977-Jun-13 02:15:45')
        when:
            def result = gigasecond.from(start)
        then:
            result == Date.parse('yyyy-MMM-dd hh:mm:ss', '2009-Feb-19 03:02:25')
    }

}
