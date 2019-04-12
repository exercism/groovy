import spock.lang.*

class WordCountSpec extends Specification {

    def "Count one word"() {
        expect:
        new WordCount(sentence).wordCount() == expected

        where:
        sentence || expected
        'word'   || ['word': 1]
    }

    @Ignore
    def "Count one of each"() {
        expect:
        new WordCount(sentence).wordCount() == expected

        where:
        sentence      || expected
        'one of each' || ['one': 1, 'of': 1, 'each': 1]
    }

    @Ignore
    def "Multiple occurrences of a word"() {
        expect:
        new WordCount(sentence).wordCount() == expected

        where:
        sentence                               || expected
        'one fish two fish red fish blue fish' || ['one': 1, 'fish': 4, 'two': 1, 'red': 1, 'blue': 1]
    }

    @Ignore
    def "Handles cramped lists"() {
        expect:
        new WordCount(sentence).wordCount() == expected

        where:
        sentence        || expected
        'one,two,three' || ['one': 1, 'two': 1, 'three': 1]
    }

    @Ignore
    def "Handles expanded lists"() {
        expect:
        new WordCount(sentence).wordCount() == expected

        where:
        sentence            || expected
        'one,\ntwo,\nthree' || ['one': 1, 'two': 1, 'three': 1]
    }

    @Ignore
    def "Count everything only once"() {
        when:
        def wordCount = new WordCount(sentence)

        // call wordCount 2x to verify
        then:
        wordCount.wordCount()

        expect:
        wordCount.wordCount() == expected

        where:
        sentence                                     || expected
        'all the kings horses and all the kings men' || ['all': 2, 'the': 2, 'kings': 2, 'horses': 1, 'and': 1, 'men': 1]
    }

    @Ignore
    def "Ignore punctuation"() {
        expect:
        new WordCount(sentence).wordCount() == expected

        where:
        sentence                                    || expected
        'car : carpet as java : javascript!!&@$%^&' || ['car': 1, 'carpet': 1, 'as': 1, 'java': 1, 'javascript': 1]
    }

    @Ignore
    def "Include numbers"() {
        expect:
        new WordCount(sentence).wordCount() == expected

        where:
        sentence                || expected
        'testing, 1, 2 testing' || ['testing': 2, '1': 1, '2': 1]
    }

    @Ignore
    def "Normalize case"() {
        expect:
        new WordCount(sentence).wordCount() == expected

        where:
        sentence             || expected
        'go Go GO Stop stop' || ['go': 3, 'stop': 2]
    }

    @Ignore
    def "With apostrophes"() {
        expect:
        new WordCount(sentence).wordCount() == expected

        where:
        sentence                               || expected
        "First: don't laugh. Then: don't cry." || ['first': 1, "don't": 2, 'laugh': 1, 'then': 1, 'cry': 1]
    }

    @Ignore
    def "With quotations"() {
        expect:
        new WordCount(sentence).wordCount() == expected

        where:
        sentence                                    || expected
        "Joe can't tell between 'large' and large." || ['joe': 1, "can't": 1, 'tell': 1, 'between': 1, 'large': 2, 'and': 1]
    }

    @Ignore
    def "Multiple spaces not detected as a word"() {
        expect:
        new WordCount(sentence).wordCount() == expected

        where:
        sentence                  || expected
        ' multiple   whitespaces' || ['multiple': 1, 'whitespaces': 1]
    }

    @Ignore
    def "Alternating word separators not detected as a word"() {
        expect:
        new WordCount(sentence).wordCount() == expected

        where:
        sentence                     || expected
        ",\n,one,\n ,two \n 'three'" || ['one': 1, 'two': 1, 'three': 1]
    }
}