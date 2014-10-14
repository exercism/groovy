class Gigasecond {
  def from(dateObject) {
    dateObject.plus((10**9 / 86400).toInteger()) 
  }
}
