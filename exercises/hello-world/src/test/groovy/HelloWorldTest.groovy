import org.junit.Test
import static org.junit.Assert.assertTrue

class HelloWorldTest {
  @Test
  void testNoName() {
    assertTrue new HelloWorld().hello() == 'Hello, World!'
  }

  @Test
  void testSampleName() {
    assertTrue new HelloWorld().hello('Alice') == 'Hello, Alice!'
  }

  @Test
  void testAnotherSampleName() {
    assertTrue new HelloWorld().hello('Bob') == 'Hello, Bob!'
  }
}
