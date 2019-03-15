class Darts {

    static int score(x, y) {
        def hypot = Math.hypot(x, y)

        if (hypot <= 1) {
            10
        } else if (hypot <= 5) {
            5
        } else if (hypot <= 10) {
            1
        } else {
            0
        }
    }
}