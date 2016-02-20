class Example {
  def from(Date dateObject) {
    def seconds = dateObject.getTime() / 1000
    def gs = seconds + 10**9
    new Date((long) gs * 1000)
  }
}