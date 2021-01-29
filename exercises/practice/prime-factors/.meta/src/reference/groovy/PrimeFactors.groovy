class PrimeFactors {

    static List<Long> factors(Long value) {
        List<Long> factors = []
        Long divisor = 2

        while (value > 1) {
            while (value % divisor == 0) {
                factors << divisor
                value /= divisor
            }
            divisor++
        }

        factors
    }
}
