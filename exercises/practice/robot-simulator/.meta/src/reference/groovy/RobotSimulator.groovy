class RobotSimulator {
    private int pos_x
    private int pos_y
    private String direction

    static allowed_directions = ['north', 'east', 'south', 'west']

    /**
     * Returns the current position of the robot relative to the X axis
     */
    int getX() {
        return pos_x
    }

    /**
     * Returns the current position of the robot relative to the Y axis
     */
    int getY() {
        return pos_y
    }

    /**
     * Returns the direction that the robot is currently facing
     */
    String getDirection() {
        return direction
    }

    RobotSimulator(int pos_x, int pos_y, String direction) {
        this.pos_x = pos_x
        this.pos_y = pos_y
        this.direction = direction
    }

    def move(String commands) {
        commands.each {
            switch (it) {
                case "L":
                    def i = allowed_directions.indexOf(direction)
                    direction = allowed_directions[i - 1]
                    break
                case "R":
                    def i = allowed_directions.indexOf(direction)
                    i = (i + 1) % 4
                    direction = allowed_directions[i]
                    break
                case "A":
                    switch (direction) {
                        case 'north':
                            pos_y += 1
                            break
                        case 'east':
                            pos_x += 1
                            break
                        case 'south':
                            pos_y -= 1
                            break
                        case 'west':
                            pos_x -= 1
                            break
                        default:
                            break
                    }
                    break
                default:
                    break
            }
        }
    }
}
