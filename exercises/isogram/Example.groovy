class Isogram {
    static boolean isIsogram(String phrase) {
        def p = phrase
                .toLowerCase()
                .toCharArray()
                .findAll { it.isLetter() }

        p.size() == p.toSet().size()
    }
}