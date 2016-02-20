import org.junit.Test
import static org.junit.Assert.assertEquals

class RomanTest {
  def roman = new Roman()

  @Test
  void test1() {
    assertEquals "I", 1.toRoman()
  }

  @Test
  void test2() {
    assertEquals "II", 2.toRoman()
  }

  @Test
  void test3() {
    assertEquals "III", 3.toRoman()
  }

  @Test
  void test4() {
    assertEquals "IV", 4.toRoman()
  }

  @Test
  void test5() {
    assertEquals "V", 5.toRoman()
  }

  @Test
  void test6() {
    assertEquals "VI", 6.toRoman()
  }

  @Test
  void test9() {
    assertEquals "IX", 9.toRoman()
  }

  @Test
  void test27() {
    assertEquals "XXVII", 27.toRoman()
  }

  @Test
  void test48() {
    assertEquals "XLVIII", 48.toRoman()
  }

  @Test
  void test59() {
    assertEquals "LIX", 59.toRoman()
  }

  @Test
  void test93() {
    assertEquals "XCIII", 93.toRoman()
  }

  @Test
  void test141() {
    assertEquals "CXLI", 141.toRoman()
  }

  @Test
  void test163() {
    assertEquals "CLXIII", 163.toRoman()
  }

  @Test
  void test402() {
    assertEquals "CDII", 402.toRoman()
  }

  @Test
  void test575() {
    assertEquals "DLXXV", 575.toRoman()
  }

  @Test
  void test911() {
    assertEquals "CMXI", 911.toRoman()
  }

  @Test
  void test1024() {
    assertEquals "MXXIV", 1024.toRoman()
  }

  @Test
  void test3000() {
    assertEquals "MMM", 3000.toRoman()
  }
}
