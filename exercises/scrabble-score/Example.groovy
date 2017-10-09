class ScrabbleScore {

    static final letterValues = [
        'D': 2, 'G': 2,
        'B': 3, 'C': 3, 'M': 3, 'P': 3,
        'F': 4, 'H': 4, 'V': 4, 'W': 4, 'Y': 4,
        'K': 5,
        'J': 8, 'X': 8,
        'Q': 10, 'Z': 10
    ].withDefault { 1 }

    static scoreWord(String word) {
        word.toUpperCase().inject(0) { total, letter ->
            total + letterValues[letter]
        }
    }

}
