class DifferenceOfSquares {

    final int number

    DifferenceOfSquares(int number) {
        this.number = number
    }

    int squareOfSum() {
        (1..number).sum()**2
    }

    int sumOfSquares() {
        (1..number).collect { it**2 }.sum()
    }

    int difference() {
        squareOfSum() - sumOfSquares()
    }

}
