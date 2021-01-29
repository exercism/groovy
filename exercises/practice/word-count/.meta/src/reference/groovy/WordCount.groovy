class WordCount {
    private final REPLACE_PATTERN = ~/[^\w']|'\B|\B'/
    private final String sentence

    WordCount(String sentence) {
        this.sentence = sentence
    }

    def countWords() {
        sentence.toLowerCase()
                .replaceAll(REPLACE_PATTERN, ' ')
                .tokenize()
                .countBy { it }
    }
}
