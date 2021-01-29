class AllYourBase {
    private final int inputBase
    private final List<Integer> digits

    AllYourBase(int inputBase, List<Integer> digits) {
        if (inputBase < 2) throw new ArithmeticException('Invalid input base.')

        if (digits.any { it < 0 || it >= inputBase }) {
            throw new ArithmeticException('Invalid input digit.')
        }

        this.inputBase = inputBase
        this.digits = digits
    }

    private List<Integer> convertToOutputBase(int number, int base) {
        List<Integer> result = []
        while (number >= base) {
            result << number % base
            number /= base
        }
        result << number % base
        result.reverse()
    }

    List<Integer> rebase(int outputBase) {
        if (outputBase < 2) throw new ArithmeticException('Invalid output base.')

        int number = this.digits.reverse().indexed().collect { i, d ->
            d * this.inputBase**i
        }.sum(0) as int

        convertToOutputBase(number, outputBase)
    }
}