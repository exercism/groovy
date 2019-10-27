import spock.lang.*

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month

class GigasecondSpec extends Specification {

    def "Date only specification of time"() {
        expect:
        Gigasecond.add(moment) == expected

        where:
        moment = LocalDate.of(2011, Month.APRIL, 25)
        expected = LocalDateTime.of(2043, Month.JANUARY, 1, 1, 46, 40)
    }

    @Ignore
    def "Second test for date only specification of time"() {
        expect:
        Gigasecond.add(moment) == expected

        where:
        moment = LocalDate.of(1977, Month.JUNE, 13)
        expected = LocalDateTime.of(2009, Month.FEBRUARY, 19, 1, 46, 40)
    }

    @Ignore
    def "Third test for date only specification of time"() {
        expect:
        Gigasecond.add(moment) == expected

        where:
        moment = LocalDate.of(1959, Month.JULY, 19)
        expected = LocalDateTime.of(1991, Month.MARCH, 27, 1, 46, 40)
    }

    @Ignore
    def "Full time specified"() {
        expect:
        Gigasecond.add(moment) == expected

        where:
        moment = LocalDateTime.of(2015, Month.JANUARY, 24, 22, 0, 0)
        expected = LocalDateTime.of(2046, Month.OCTOBER, 2, 23, 46, 40)
    }

    @Ignore
    def "Full time with day roll-over"() {
        expect:
        Gigasecond.add(moment) == expected

        where:
        moment = LocalDateTime.of(2015, Month.JANUARY, 24, 23, 59, 59)
        expected = LocalDateTime.of(2046, Month.OCTOBER, 3, 1, 46, 39)
    }

}
