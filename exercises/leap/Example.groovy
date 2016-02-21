class Year {
  def isLeap(i) {
    (i % 4) == 0 && ((i % 400) == 0 || (i % 100) != 0)
  }
}
