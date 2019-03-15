class Grains {
    static square(num) {
        2**(num - 1)
    }

    static total() {
        (1..64).inject() { sum, n -> sum + square(n) }
    }
}
