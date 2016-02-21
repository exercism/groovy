import org.junit.Test
import static org.junit.Assert.assertEquals
import static java.util.Calendar.*

/**
 * Test suite for the Gigasecond exercise.
 * To ignore a test case while you work the problem, simply comment out the method or add the @Ignore annotation.
 */
class GigasecondTest {

  @Test
  void gigasecondFromDate() {
    def gs = new Gigasecond().from(new GregorianCalendar(2011, APRIL, 25).time)
    assertEquals new GregorianCalendar(2043, JANUARY, 1, 0, 46, 40).time, gs
  }

  @Test
  void gigasecondFromDateWithHoursAndMinutes() {
    def gs = new Gigasecond().from(new GregorianCalendar(1959, JULY, 19, 12, 31).time)
    assertEquals new GregorianCalendar(1991, MARCH, 27, 13, 17, 40).time, gs
  }

  @Test
  void gigasecondFromDateWithHoursAndMinutesAndSeconds() {
    def gs = new Gigasecond().from(new GregorianCalendar(1977, JUNE, 13, 2, 15, 45).time)
    assertEquals new GregorianCalendar(2009, FEBRUARY, 19, 3, 2, 25).time, gs
  }

}
