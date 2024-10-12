class LargestSeriesProduct {
    static int largestProduct(String digits, final int span) {
        if (span < 0) throw new IllegalArgumentException("span must not be negative")
        if (span > digits.length()) throw new IllegalArgumentException("span must be smaller than string length")
        if (!digits.chars().allMatch(Character::isDigit)) throw new IllegalArgumentException("digits input must only contain digits")
        int maximum = 0
        for (i in 0..digits.length() - span) {
            int product = 1
            for (j in 0..<span) {
                product *= Character.getNumericValue(digits.charAt(i + j))
            }
            if (product > maximum) maximum = product
        }
        maximum
    }
}