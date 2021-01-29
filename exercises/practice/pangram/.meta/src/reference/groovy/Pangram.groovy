class Pangram {

    private final static LETTERS = 'a'..'z' as Set

    static boolean isPangram(String sentence) {
        sentence.toLowerCase().toSet().containsAll(LETTERS)
    }

}