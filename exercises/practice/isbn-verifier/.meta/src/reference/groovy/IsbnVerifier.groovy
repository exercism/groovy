class IsbnVerifier {
    static boolean isValid(String isbn) {
        if (!isbn.matches(~/^\d-?\d{3}-?\d{5}-?[\dX]$/)) {
            return false
        }

        isbn.findAll { (it as char).isLetterOrDigit() }.withIndex().collect { c, i ->
            c == 'X' ? 10 : c.toInteger() * (10 - i)
        }.sum() % 11 == 0
    }
}