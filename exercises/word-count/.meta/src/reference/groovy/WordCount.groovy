class WordCount {
    String input

    WordCount(s) {
        input = s
    }

    def wordCount() {
        input.toLowerCase().findAll(/[\w']+/).countBy { it }
    }
}
