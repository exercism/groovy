import org.junit.Test
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotEquals

class RobotTest {
  @Test
  void testHasName() {
    assert new Robot().name =~ /^[a-zA-Z]{2}\d{3}$/
  }

  @Test
  void testNameSticks() {
    def robot = new Robot()
    robot.name
    assertEquals robot.name, robot.name
  }

  @Test
  void compareRobotNames() {
    def robot1 = new Robot().name
    def robot2 = new Robot().name
    assertNotEquals robot1, robot2
  }

  @Test
  void testResetName() {
    def robot = new Robot()
    def name1 = robot.name
    robot.reset()
    def name2 = robot.name
    assertNotEquals name1, name2
    assert name2 =~ /^[a-zA-Z]{2}\d{3}$/
  }
}
