@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class WordCountSpec extends Specification {

    def 'count one word' () {
        expect: ["word":1] == new WordCount("word").wordCount()
    }

    def 'count one of each' () {
        expect: ["one":1,"of":1,"each":1] == new WordCount("one of each").wordCount()
    }

    def 'count multiple occurrences' () {
        def wordCount = new WordCount("one fish two fish red fish blue fish")
        expect: ["one":1,"fish":4,"two":1,"red":1,"blue":1] == wordCount.wordCount()
    }

    def 'count everything only once' () {
        def wordCount = new WordCount("all the kings horses and all the kings men")
        // call wordCount 2x to verify
        wordCount.wordCount()
        expect: ["all":2,"the":2,"kings":2,"horses":1,"and":1,"men":1] == wordCount.wordCount()
    }

    def 'ignore punctuation' () {
        def wordCount = new WordCount('car : carpet as java : javascript!!&@$%^&')
        expect: ["car":1,"carpet":1,"as":1,"java":1,"javascript":1] == wordCount.wordCount()
    }

    def 'handle no spaces' () {
        expect: ["one":1,"two":1,"three":1] == new WordCount("one,two,three").wordCount()
    }

    def 'include numbers' () {
        expect: ["testing":2,"1":1,"2":1] == new WordCount("testing, 1, 2 testing").wordCount()
    }

    def 'normalize case' () {
        expect: ["go":3] == new WordCount("go Go GO").wordCount()
    }

    def 'handle apostrophes' () {
        def wordCount = new WordCount("First: don't laugh. Then: don't cry.")
        expect: ["first":1,"don't":2,"laugh":1,"then":1,"cry":1] == wordCount.wordCount()
    }
}