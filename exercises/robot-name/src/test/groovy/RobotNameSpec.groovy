import spock.lang.*

class RobotNameSpec extends Specification {

    def "Generates a name"() {
        expect:
        new RobotName().name =~ /^[a-zA-Z]{2}\d{3}$/
    }

    @Ignore
    def "Generates the same name when called again"() {
        given:
        def robot = new RobotName()

        expect:
        robot.name == robot.name
    }

    @Ignore
    def "Different robots generate different names"() {
        given:
        def robot = new RobotName()
        def other_robot = new RobotName()

        expect:
        robot.name != other_robot.name
    }

    @Ignore
    def "Can be reset to generate another name"() {
        given:
        def robot = new RobotName()
        def name_before_reset = robot.name
        robot.reset()
        def name_after_reset = robot.name

        expect:
        name_before_reset != name_after_reset
    }

}
