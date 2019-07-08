class WordCount {
    private static final REPLACE_PATTERN = ~/[^\w']|'\B|\B'/

    String sentence

    WordCount(String sentence) {
        this.sentence = sentence
    }

    def wordCount() {
        sentence.toLowerCase()
                .replaceAll(REPLACE_PATTERN, ' ')
                .tokenize()
                .countBy { it }
    }
}
