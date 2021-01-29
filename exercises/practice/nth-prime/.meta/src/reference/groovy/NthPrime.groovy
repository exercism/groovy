class NthPrime {

    private static boolean isPrime(int n) {
        def sqrt = Math.ceil(Math.sqrt(n))
        for (int i = 3; i <= sqrt; i += 1) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }

    static int nth(int n) {
        // handle stuff that doesn't need
        // additional calculations
        if (n < 1) throw new ArithmeticException()
        if (n == 1) return 2

        int lastValue = 0
        int count = 1
        int i = 3

        while (count < n) {
            if (isPrime(i)) {
                lastValue = i
                count += 1
            }
            i += 2
        }
        return lastValue
    }
}
