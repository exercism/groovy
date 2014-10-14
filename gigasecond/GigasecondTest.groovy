import org.junit.Test
import static org.junit.Assert.assertEquals
import static java.util.Calendar.*

class GigasecondTest {
  @Test
  void test1() {
    def gs = new Gigasecond().from(new GregorianCalendar(2011, APRIL, 25).time)
    assertEquals new GregorianCalendar(2043, JANUARY, 1).time, gs
  }

  @Test
  void test2() {
    def gs = new Gigasecond().from(new GregorianCalendar(1977, JUNE, 13).time)
    assertEquals new GregorianCalendar(2009, FEBRUARY, 19).time, gs
  }

  @Test
  void test3() {
    def gs = new Gigasecond().from(new GregorianCalendar(1959, JULY, 19).time)
    assertEquals new GregorianCalendar(1991, MARCH, 27).time, gs
  }
}
