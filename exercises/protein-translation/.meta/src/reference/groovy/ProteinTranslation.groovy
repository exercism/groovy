class ProteinTranslation {

    private static final STOP = 'STOP'

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
            'UGG': 'Tryptophan'
    ].withDefault { STOP }

    static List<String> proteins(String strand) {
        strand.split('').collate(3).collect { PROTEINS[it.join()] }.takeWhile { it != STOP }
    }
}