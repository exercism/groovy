class WordCount {
  String input 

  def WordCount(s) {
    input = s
  }

  def wordCount() {
    input.toLowerCase().findAll(/[\w']+/).countBy { it }  
  }
}
