class RotationalCipher {
    private int key
    private char a = 'a'
    private char A = 'A'

    RotationalCipher(int key) {
        this.key = key
    }

    private char rotateChar(char c) {
        if (!c.isLetter()) {
            return c
        }
        char base = c.isUpperCase() ? A : a
        (c - base + this.key) % 26 + base
    }

    String rotate(String cipherText) {
        cipherText.toCharArray().collect { rotateChar(it) }.join()
    }

}
