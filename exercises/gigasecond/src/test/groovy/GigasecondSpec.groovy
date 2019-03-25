import spock.lang.*

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month

class GigasecondSpec extends Specification {

    @Shared
    def gigasecond = new Gigasecond()

    def 'date only specification of time'() {
        expect:
        expected == gigasecond.add(moment)

        where:
        moment = LocalDate.of(2011, Month.APRIL, 25)
        expected = LocalDateTime.of(2043, Month.JANUARY, 1, 1, 46, 40)
    }

    @Ignore
    def 'second test for date only specification of time'() {
        expect:
        expected == gigasecond.add(moment)

        where:
        moment = LocalDate.of(1977, Month.JUNE, 13)
        expected = LocalDateTime.of(2009, Month.FEBRUARY, 19, 1, 46, 40)
    }

    @Ignore
    def 'third test for date only specification of time'() {
        expect:
        expected == gigasecond.add(moment)

        where:
        moment = LocalDate.of(1959, Month.JULY, 19)
        expected = LocalDateTime.of(1991, Month.MARCH, 27, 1, 46, 40)
    }

    @Ignore
    def 'full time specified'() {
        expect:
        expected == gigasecond.add(moment)

        where:
        moment = LocalDateTime.of(2015, Month.JANUARY, 24, 22, 0, 0)
        expected = LocalDateTime.of(2046, Month.OCTOBER, 2, 23, 46, 40)
    }

    @Ignore
    def 'full time with day roll-over'() {
        expect:
        expected == gigasecond.add(moment)

        where:
        moment = LocalDateTime.of(2015, Month.JANUARY, 24, 23, 59, 59)
        expected = LocalDateTime.of(2046, Month.OCTOBER, 3, 1, 46, 39)
    }


}
