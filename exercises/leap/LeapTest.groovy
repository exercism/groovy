import org.junit.Test
import static org.junit.Assert.assertTrue
import static org.junit.Assert.assertFalse

class LeapTest {
  @Test
  void testLeapYear() {
    assertTrue new Year().isLeap(1996)
  }

  @Test
  void testNonLeapYear() {
    assertFalse new Year().isLeap(1997)
  }

  @Test
  void testNonLeapYearEven() {
   assertFalse new Year().isLeap(1998) 
  }

  @Test
  void testCentury() {
    assertFalse new Year().isLeap(1900)
  }

  @Test
  void testFourthCentury() {
    assertTrue new Year().isLeap(2400)
  }
}
