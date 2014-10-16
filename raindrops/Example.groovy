class Raindrops {
  private def primeSounds = [ 3:'Pling', 5:'Plang', 7:'Plong']

  def convert(num) {
    def result = new String()

    primeSounds.each({ k, v ->
      if ((num % k).equals(0)) { result += v }
    })

    result.isEmpty() ? num.toString() : result
  }
}
