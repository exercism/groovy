class Yacht {

    static Integer score(List<Integer> dice, String category) {

        if (category == "yacht") {
            return dice.unique().size() == 1 ? 50 : 0
        }
        if (category == "ones") {
            return dice.findAll { it == 1 }.sum() ?: 0
        }
        if (category == "twos") {
            return dice.findAll { it == 2 }.sum() ?: 0
        }
        if (category == "threes") {
            return dice.findAll { it == 3 }.sum() ?: 0
        }
        if (category == "fours") {
            return dice.findAll { it == 4 }.sum() ?: 0
        }
        if (category == "fives") {
            return dice.findAll { it == 5 }.sum() ?: 0
        }
        if (category == "sixes") {
            return dice.findAll { it == 6 }.sum() ?: 0
        }
        if (category == "full house") {
            def counts = dice.countBy { it }
            return counts.containsValue(3) && counts.containsValue(2) ? dice.sum() : 0
        }
        if (category == "four of a kind") {
            def counts = dice.countBy { it }
            return (counts.find { it.value >= 4 }?.key ?: 0) * 4
        }
        if (category == "little straight") {
            return dice.sort() == [1, 2, 3, 4, 5] ? 30 : 0
        }
        if (category == "big straight") {
            return dice.sort() == [2, 3, 4, 5, 6] ? 30 : 0
        }
        if (category == "choice") {
            return dice.sum()
        }
    }
}

