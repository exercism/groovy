class Allergies {

    private int score

    final ALLERGIES = ["eggs",
                       "peanuts",
                       "shellfish",
                       "strawberries",
                       "tomatoes",
                       "chocolate",
                       "pollen",
                       "cats"]

    Allergies(int score) {
        this.score = score
    }

    boolean allergicTo(String substance) {
        (this.score & 1 << ALLERGIES.findIndexOf { it == substance }) != 0
    }

    def list() {
        ALLERGIES.findAll { allergicTo(it) }
    }

}