import org.junit.Test
import static org.junit.Assert.assertEquals

class NthPrimeTest {
  @Test
  void testFirst() {
    assertEquals 2, new Prime().nth(1)
  }

  @Test
  void testSecond() {
    assertEquals 3, new Prime().nth(2)
  }

  @Test
  void testSixth() {
    assertEquals 13, new Prime().nth(6)
  }

  @Test
  void testBigPrime() {
    assertEquals 104743, new Prime().nth(10001)
  }

  @Test(expected=ArithmeticException)
  void testLessThan1 () {
    new Prime().nth(0)  
  }
}
