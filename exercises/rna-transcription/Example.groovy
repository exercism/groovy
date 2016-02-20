class Complement {
  private def dnaMap = ["G":"C","C":"G","T":"A","A":"U"]
  private def rnaMap = ["C":"G","G":"C","A":"T","U":"A"]

  private def transcribe(seq, seqMap) {
    def result = new String()
    seq.split('').each() {
      result += seqMap[it] 
    }
    return result
  }

  def ofDNA(strand) {
    transcribe(strand, dnaMap)   
  }

  def ofRNA(strand) {
    transcribe(strand, rnaMap) 
  }
}
