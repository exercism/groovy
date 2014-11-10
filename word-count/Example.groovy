class Phrase {
  String input 

  def Phrase(s) {
    input = s
  }

  def wordCount() {
    input.toLowerCase().findAll(/[\w']+/).countBy { it }  
  }
}
