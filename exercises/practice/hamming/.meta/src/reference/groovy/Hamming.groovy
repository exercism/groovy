class Hamming {

    static distance(strand1, strand2) {
        if (strand1.isEmpty() && strand2.isEmpty()) {
            return 0
        }
        if (strand1.size() != strand2.size()) {
            throw new ArithmeticException()
        }

        (0..<strand1.size()).count() {
            strand1[it] != strand2[it]
        }
    }

}
