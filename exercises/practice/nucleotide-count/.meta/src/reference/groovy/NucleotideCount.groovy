class NucleotideCount {

    static final nucleotide = ["A", "C", "G", "T"]

    static count(String strand) {
        if (!strand.isEmpty() && !strand.split('').every { it in nucleotide }) {
            throw new Exception('Invalid nucleotide in strand')
        }

        nucleotide.collectEntries { [(it): strand.count(it)] }
    }
}