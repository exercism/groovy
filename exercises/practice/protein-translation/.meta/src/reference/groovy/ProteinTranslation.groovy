class ProteinTranslation {

    private static final STOP = 'STOP'
    private static final INVALID = 'INVALID'

    private static final PROTEINS = [
            'AUG': 'Methionine',
            'UUU': 'Phenylalanine',
            'UUC': 'Phenylalanine',
            'UUA': 'Leucine',
            'UUG': 'Leucine',
            'UCU': 'Serine',
            'UCC': 'Serine',
            'UCA': 'Serine',
            'UCG': 'Serine',
            'UAU': 'Tyrosine',
            'UAC': 'Tyrosine',
            'UGU': 'Cysteine',
            'UGC': 'Cysteine',
            'UGG': 'Tryptophan',
            'UAA': STOP,
            'UAG': STOP,
            'UGA': STOP
    ].withDefault { INVALID }

    static List<String> proteins(String strand) {
        List<String> result = []
        while (strand != "") {
            def protein = PROTEINS[strand.take(3)]
            if (protein == INVALID) throw new Exception('Invalid codon')
            if (protein == STOP) break
            result.add(protein)
            strand = strand.drop(3)
        }
        result
    }
}
