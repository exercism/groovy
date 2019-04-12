import spock.lang.*

class NucleotideCountSpec extends Specification {

    def "Empty strand"() {
        expect:
        NucleotideCount.count(strand) == expected

        where:
        strand || expected
        ''     || ['A': 0, 'C': 0, 'G': 0, 'T': 0]
    }

    @Ignore
    def "Can count one nucleotide in single-character input"() {
        expect:
        NucleotideCount.count(strand) == expected

        where:
        strand || expected
        'G'    || ['A': 0, 'C': 0, 'G': 1, 'T': 0]
    }

    @Ignore
    def "Strand with repeated nucleotide"() {
        expect:
        NucleotideCount.count(strand) == expected

        where:
        strand    || expected
        'GGGGGGG' || ['A': 0, 'C': 0, 'G': 7, 'T': 0]
    }

    @Ignore
    def "Strand with multiple nucleotides"() {
        expect:
        NucleotideCount.count(strand) == expected

        where:
        strand = 'AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC'
        expected = ['A': 20, 'C': 12, 'G': 17, 'T': 21]
    }

    @Ignore
    def "Strand with invalid nucleotides"() {
        when:
        NucleotideCount.count('AGXXACT')

        then:
        thrown(ArithmeticException)
    }
}