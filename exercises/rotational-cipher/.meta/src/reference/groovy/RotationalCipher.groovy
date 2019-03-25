class RotationalCipher {
    private int key

    RotationalCipher(int key) {
        this.key = key
    }

    String rotate(String cipherText) {
        StringBuilder ret = new StringBuilder()
        cipherText.each { c -> ret.append(convert(c)) }
        ret.toString()
    }

    /*
     * 'a' == 97
     * 'z' == 122
     * 'A' == 65
     * 'Z' == 90
     * For reference, see http://www.asciitable.com
     */

    private char convert(String s) {
        char c = s as Character
        int cInt = c as Integer
        int convertedInt = cInt + key
        if (c.isLetter()) {
            if (c.isLowerCase() && convertedInt > 122) {
                (96 + (convertedInt % 122)) as Character
            } else if (c.isUpperCase() && convertedInt > 90) {
                (64 + (convertedInt % 90)) as Character
            } else {
                convertedInt as Character
            }
        } else {
            c
        }

    }
}
