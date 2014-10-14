import org.junit.Test
import static org.junit.Assert.assertEquals

class HammingTest extends GroovyTestCase {
  @Test
  void testIdenticalStrands() {
    assertEquals 0, new Hamming().compute('A','A')
  }

  @Test
  void testCompleteDistanceForSingleNucleotideStrand() {
   assertEquals 1, new Hamming().compute('A','G')
  }

  
  @Test
  void testCompleteDistanceForSmallStrand() {
    assertEquals 2, new Hamming().compute('AG','CT')
  }

  
  @Test
  void testSmallHammingDistance() {
    assertEquals 1, new Hamming().compute('AT','CT')
  }

  
  @Test
  void testSmallHammingDistanceInLongerStrand() {
    assertEquals 1, new Hamming().compute('GGACG','GGTCG')
  }

  
  @Test
  void testIgnoreLengthOnFirstStrandWhenLonger() {
    assertEquals 1, new Hamming().compute('AGAGACTTA','AAA')
  }

  
  @Test
  void testIgnoreLengthOnOtherStrandWhenLonger() {
    assertEquals 2, new Hamming().compute('AGG','AAAACTGACCCACCCCAGG')
  }

  
  @Test
  void testLargeHammingDistance() {
    assertEquals 4, new Hamming().compute('GATACA','GCATAA')
  }

  
  @Test
  void testVeryLongHammingDistance() {
    assertEquals 9, new Hamming().compute('GGACGGATTCTG','AGGACGGATTCT')
  }
}
