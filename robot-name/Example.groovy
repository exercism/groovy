class Robot {
  String name

  private def letters = "A".."Z"
  private def rand = new Random()
  private def usedNames = new ArrayList()

  def Robot() {
    reset()
  }

  def reset() {
    name = new String()
    
    0.upto(1) {
      name += letters[rand.nextInt(letters.size())]
    }
    
    name += rand.nextInt(999).toString()
    
    if ( usedNames.contains(name) ) {
      reset()
    }
    
    usedNames.add(name)
  }

}
