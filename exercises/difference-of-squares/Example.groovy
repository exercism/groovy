class Squares {
  def naturalNum

  def Squares(num) {
    this.naturalNum = num
  }

  def squareOfSums() {
    (1..naturalNum).inject(0) {result, i -> result += i } ** 2
  }

  def sumOfSquares() {
    (1..naturalNum).inject(0) {result, i ->
      result += i ** 2
    }  
  }

  def difference() {
    squareOfSums() - sumOfSquares() 
  }
}
