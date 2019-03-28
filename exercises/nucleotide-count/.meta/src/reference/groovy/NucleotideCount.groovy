class NucleotideCount {

    static final nucleotide = ["A", "C", "G", "T"]

    static count(strand) {
        if (!strand.isEmpty() && !strand.split('').every { it in nucleotide }) {
            throw new ArithmeticException()
        }

        nucleotide.collectEntries { [(it): strand.count(it)] }
    }
}