class Hamming {
  def compute(strand1, strand2) {
   (0..[strand1.size(), strand2.size()].min() - 1).step(1).count() {
     strand1[it] != strand2[it]
   }
  }
}
