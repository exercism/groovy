class Proverb {

    static String recite(List<String> strings) {
        if (strings.isEmpty()) {
            return ''
        }

        strings.collate(2, 1, false)
                .collect { a, b -> "For want of a $a the $b was lost.\n" }
                .join('') + "And all for the want of a ${strings.first()}."
    }
}