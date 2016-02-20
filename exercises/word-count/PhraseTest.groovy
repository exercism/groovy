import org.junit.Test
import static org.junit.Assert.assertEquals

class PhraseTest {
  @Test
  void countOneWord() {
    def phrase = new Phrase("word")
    def counts = ["word":1]
    assertEquals counts, phrase.wordCount()
  }

  @Test
  void countOneOfEach() {
    def phrase = new Phrase("one of each")
    def counts = ["one":1,"of":1,"each":1]
    assertEquals counts, phrase.wordCount()
  }

  @Test
  void countMultipleOccurrences() {
    def phrase = new Phrase("one fish two fish red fish blue fish")
    def counts = ["one":1,"fish":4,"two":1,"red":1,"blue":1]
    assertEquals counts, phrase.wordCount()
  }

  @Test
  void countEverythingOnlyOnce() {
    def phrase = new Phrase("all the kings horses and all the kings men") 
    def counts = ["all":2,"the":2,"kings":2,"horses":1,"and":1,"men":1]
    // call wordCount 2x to verify 
    phrase.wordCount()
    assertEquals counts, phrase.wordCount()
  }

  @Test
  void ignorePunctuation() {
    def phrase = new Phrase('car : carpet as java : javascript!!&@$%^&')
    def counts = ["car":1,"carpet":1,"as":1,"java":1,"javascript":1]
    assertEquals counts, phrase.wordCount()
  }

  @Test
  void handleNoSpaces() {
    def phrase = new Phrase("one,two,three") 
    def counts = ["one":1,"two":1,"three":1]
    assertEquals counts, phrase.wordCount()
  }

  @Test
  void includeNumbers() {
    def phrase = new Phrase("testing, 1, 2 testing")
    def counts = ["testing":2,"1":1,"2":1]
    assertEquals counts, phrase.wordCount()
  }

  @Test
  void normalizeCase() {
    def phrase = new Phrase("go Go GO")
    def counts = ["go":3]
    assertEquals counts, phrase.wordCount()
  }

  @Test
  void handleApostrophes() {
    def phrase = new Phrase("First: don't laugh. Then: don't cry.") 
    def counts = ["first":1,"don't":2,"laugh":1,"then":1,"cry":1]
    assertEquals counts, phrase.wordCount()
  }
}
