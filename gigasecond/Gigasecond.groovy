import groovy.time.TimeCategory

class Gigasecond {
  def from(dateObject) {
    use ( TimeCategory ) {
      dateObject + ((10**9 / 86400).toInteger()).days
    }
  }
}
