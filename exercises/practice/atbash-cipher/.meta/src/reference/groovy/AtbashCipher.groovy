class AtbashCipher {

    static plain = "abcdefghijklmnopqrstuvwxyz"
    static cipher = plain.reverse()

    static String encode(String phrase) {
        phrase
                .toLowerCase()
                .tr(plain, cipher)
                .chars
                .findAll { Character.isLetterOrDigit(it) }
                .collate(5)
                .collect { it.join("") }
                .join(" ")
    }

    static String decode(String phrase) {
        phrase
                .tr(plain, cipher)
                .chars
                .findAll { Character.isLetterOrDigit(it) }
                .join("")
    }

}