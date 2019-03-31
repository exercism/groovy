class WordCount {
    String input

    WordCount(s) {
        input = s
    }

    def wordCount() {
        String i = input.toLowerCase().replaceAll("([^A-Za-z0-9']|\\B'|'\\B)", " ")
        i.findAll(/[\w']+/).countBy { it }
    }
}
