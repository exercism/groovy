import spock.lang.*

class ProteinTranslationSpec extends Specification {

    def "Methionine RNA sequence"() {
        expect:
        ProteinTranslation.proteins(strand) == expected

        where:
        strand || expected
        'AUG'  || ['Methionine']
    }

    @Ignore
    def "Phenylalanine RNA sequence"() {
        expect:
        ProteinTranslation.proteins(strand) == expected

        where:
        strand || expected
        'UUU'  || ['Phenylalanine']
        'UUC'  || ['Phenylalanine']
    }

    @Ignore
    def "Leucine RNA sequence"() {
        expect:
        ProteinTranslation.proteins(strand) == expected

        where:
        strand || expected
        'UUA'  || ['Leucine']
        'UUG'  || ['Leucine']
    }

    @Ignore
    def "Serine RNA sequence"() {
        expect:
        ProteinTranslation.proteins(strand) == expected

        where:
        strand || expected
        'UCU'  || ['Serine']
        'UCC'  || ['Serine']
        'UCA'  || ['Serine']
        'UCG'  || ['Serine']
    }

    @Ignore
    def "Tyrosine RNA sequence"() {
        expect:
        ProteinTranslation.proteins(strand) == expected

        where:
        strand || expected
        'UAU'  || ['Tyrosine']
        'UAC'  || ['Tyrosine']
    }

    @Ignore
    def "Cysteine RNA sequence"() {
        expect:
        ProteinTranslation.proteins(strand) == expected

        where:
        strand || expected
        'UGU'  || ['Cysteine']
        'UGC'  || ['Cysteine']
    }

    @Ignore
    def "Tryptophan RNA sequence"() {
        expect:
        ProteinTranslation.proteins(strand) == expected

        where:
        strand || expected
        'UGG'  || ['Tryptophan']
    }

    @Ignore
    def "STOP codon RNA sequence"() {
        expect:
        ProteinTranslation.proteins(strand) == expected

        where:
        strand || expected
        'UAA'  || []
        'UAG'  || []
        'UGA'  || []
    }

    @Ignore
    def "Translate RNA strand into correct protein list"() {
        expect:
        ProteinTranslation.proteins(strand) == expected

        where:
        strand      || expected
        'AUGUUUUGG' || ['Methionine', 'Phenylalanine', 'Tryptophan']
    }

    @Ignore
    def "Translation stops if STOP codon at beginning of sequence"() {
        expect:
        ProteinTranslation.proteins(strand) == expected

        where:
        strand   || expected
        'UAGUGG' || []
    }

    @Ignore
    def "Translation stops if STOP codon at end of two-codon sequence"() {
        expect:
        ProteinTranslation.proteins(strand) == expected

        where:
        strand   || expected
        'UGGUAG' || ['Tryptophan']
    }

    @Ignore
    def "Translation stops if STOP codon at end of three-codon sequence"() {
        expect:
        ProteinTranslation.proteins(strand) == expected

        where:
        strand      || expected
        'AUGUUUUAA' || ['Methionine', 'Phenylalanine']
    }

    @Ignore
    def "Translation stops if STOP codon in middle of three-codon sequence"() {
        expect:
        ProteinTranslation.proteins(strand) == expected

        where:
        strand      || expected
        'UGGUAGUGG' || ['Tryptophan']
    }

    @Ignore
    def "Translation stops if STOP codon in middle of six-codon sequence"() {
        expect:
        ProteinTranslation.proteins(strand) == expected

        where:
        strand               || expected
        'UGGUGUUAUUAAUGGUUU' || ['Tryptophan', 'Cysteine', 'Tyrosine']
    }

}