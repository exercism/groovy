class Grains {
    static square(int num) {
        if (num < 1 || num > 64) throw new ArithmeticException("Square must be between 1 and 64")
        2**(num - 1)
    }

    static total() {
        (1..64).inject() { sum, n -> sum + square(n) }
    }
}
