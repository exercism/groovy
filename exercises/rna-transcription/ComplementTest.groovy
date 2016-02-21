import org.junit.Test
import static org.junit.Assert.assertEquals

class ComplementTest {
  @Test
  void testCytosineRNAComplement() {
    assertEquals 'G', new Complement().ofDNA('C')
  }

  @Test
  void testGuanineRNAComplement() {
    assertEquals 'C', new Complement().ofDNA('G')
  }

  @Test
  void testThymineRNAComplement() {
    assertEquals 'A', new Complement().ofDNA('T')
  }

  @Test
  void testAdenineRNAComplement() {
    assertEquals 'U', new Complement().ofDNA('A')
  }

  @Test
  void testRNAComplement() {
    assertEquals 'UGCACCAGAAUU', new Complement().ofDNA('ACGTGGTCTTAA')
  }

  @Test
  void testCytosineDNAComplement() {
    assertEquals 'G', new Complement().ofRNA('C')
  }

  @Test
  void testGuanineDNAComplement() {
    assertEquals 'C', new Complement().ofRNA('G')
  }

  @Test
  void testUracilDNAComplement() {
    assertEquals 'A', new Complement().ofRNA('U')
  }

  @Test
  void testAdenineDNAComplement() {
    assertEquals 'T', new Complement().ofRNA('A')
  }

  @Test
  void testDNAComplement() {
    assertEquals 'ACTTGGGCTGTAC', new Complement().ofRNA('UGAACCCGACAUG')
  }

}
