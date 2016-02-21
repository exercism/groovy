import org.junit.Test
import static org.junit.Assert.assertEquals

class SquaresTest {
  @Test
  void squareOfSumsTo5() {
    assertEquals 225, new Squares(5).squareOfSums()
  }

  @Test
  void sumOfSquaresTo5() {
    assertEquals 55, new Squares(5).sumOfSquares()
  }

  @Test
  void diffOfSumsTo5() {
    assertEquals 170, new Squares(5).difference()
  }

  @Test
  void squareOfSumsTo10() {
    assertEquals 3025, new Squares(10).squareOfSums()
  }

  @Test
  void sumOfSquaresTo10() {
    assertEquals 385, new Squares(10).sumOfSquares()
  }

  @Test
  void diffOfSumsTo10() {
    assertEquals 2640, new Squares(10).difference()
  }

  @Test
  void squareOfSumsTo100() {
    assertEquals 25502500, new Squares(100).squareOfSums()
  }

  @Test
  void sumOfSquaresTo100() {
    assertEquals 338350, new Squares(100).sumOfSquares()
  }

  @Test
  void diffOfSumsTo100() {
    assertEquals 25164150, new Squares(100).difference()
  }
}
