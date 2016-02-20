import org.junit.Test
import static org.junit.Assert.assertEquals

class GrainsTest {
  @Test
  void testSquare1() {
    assertEquals 1, new Grains().square(1)
  }

  @Test
  void testSquare2() {
    assertEquals 2, new Grains().square(2)
  }

  @Test
  void testSquare3() {
    assertEquals 4, new Grains().square(3)
  }

  @Test
  void testSquare4() {
    assertEquals 8, new Grains().square(4)
  }

  @Test
  void testSquare16() {
    assertEquals 32768, new Grains().square(16)
  }

  @Test
  void testSquare32() {
    // GROOVY-7129
    assertEquals 2147483648, new Grains().square(32).toLong()
  }

  @Test
  void testSquare64() {
    assertEquals 9223372036854775808, new Grains().square(64)
  }

  @Test
  void testTotal() {
    assertEquals 18446744073709551615, new Grains().total()
  }
}
