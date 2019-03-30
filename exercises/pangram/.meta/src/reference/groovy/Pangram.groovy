class Pangram {

    private final static LETTERS = "abcdefghijklmnopqrstuvwxyz".toSet()

    static boolean isPangram(String sentence) {
        sentence.toLowerCase().toSet().containsAll(LETTERS)
    }

}