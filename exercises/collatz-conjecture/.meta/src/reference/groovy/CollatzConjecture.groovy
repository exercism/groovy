class CollatzConjecture {

    static int steps(int number) {
        if (number < 1) throw new ArithmeticException("Only positive numbers are allowed")

        int result = 0
        int n = number
        while (n != 1) {
            n = n % 2 == 0 ? n / 2 : 3 * n + 1
            result += 1
        }

        result
    }
}