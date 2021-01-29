class PerfectNumbers {

    static Classification classify(int num) {
        if (num <= 0) {
            throw new ArithmeticException("You must supply a natural number (positive integer)")
        }

        final int aliquotSum = (1..<num).findAll { num % it == 0 }.sum(0) as int

        if (aliquotSum == num) {
            Classification.PERFECT
        } else if (aliquotSum > num) {
            Classification.ABUNDANT
        } else {
            Classification.DEFICIENT
        }
    }
}