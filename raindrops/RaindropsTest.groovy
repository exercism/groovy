import org.junit.Test
import static org.junit.Assert.assertEquals

class RaindropsTest {
  @Test
  void test1() {
    assertEquals '1', new Raindrops().convert(1)
  }

  @Test
  void test3() {
    assertEquals 'Pling', new Raindrops().convert(3)
  }

  @Test
  void test5() {
    assertEquals 'Plang', new Raindrops().convert(5)
  }

  @Test
  void test6() {
    assertEquals 'Pling', new Raindrops().convert(6)
  }

  @Test
  void test7() {
    assertEquals 'Plong', new Raindrops().convert(7)
  }

  @Test
  void test9() {
    assertEquals 'Pling', new Raindrops().convert(9)
  }

  @Test
  void test10() {
    assertEquals 'Plang', new Raindrops().convert(10)
  }

  @Test
  void test14() {
    assertEquals 'Plong', new Raindrops().convert(14)
  }

  @Test
  void test15() {
    assertEquals 'PlingPlang', new Raindrops().convert(15)
  }

  @Test
  void test21() {
    assertEquals 'PlingPlong', new Raindrops().convert(21)
  }

  @Test
  void test25() {
    assertEquals 'Plang', new Raindrops().convert(25)
  }

  @Test
  void test35() {
    assertEquals 'PlangPlong', new Raindrops().convert(35)
  }

  @Test
  void test49() {
    assertEquals 'Plong', new Raindrops().convert(49)
  }

  @Test
  void test52() {
    assertEquals '52', new Raindrops().convert(52)
  }

  @Test
  void test105() {
    assertEquals 'PlingPlangPlong', new Raindrops().convert(105)
  }

  @Test
  void test12121() {
    assertEquals '12121', new Raindrops().convert(12121)
  }
}
