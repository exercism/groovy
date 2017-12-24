class DifferenceOfSquares {

    def naturalNum

    DifferenceOfSquares(Integer number) {
        this.naturalNum = number
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