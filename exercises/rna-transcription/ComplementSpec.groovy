@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class ComplementTest extends Specification {

    @Shared
    def complement = new Complement()

    def 'the rna complement of cytosine is guanine'() {
        expect: complement.ofDNA('C') == 'G'
    }

    @Ignore
    def 'the rna complement of guanine is cytosine'() {
        expect: complement.ofDNA('G') == 'C'
    }

    @Ignore
    def 'the rna complement of thymine is adenine'() {
        expect: complement.ofDNA('T') == 'A'
    }

    @Ignore
    def 'the rna complement of adenine is uracil'() {
        expect: complement.ofDNA('A') == 'U'
    }

    @Ignore
    def 'can calculate long strand complement'() {
        expect: complement.ofDNA('ACGTGGTCTTAA') == 'UGCACCAGAAUU'
    }

    @Ignore
    def 'correctly handles invalid input'() {
        when: complement.ofDNA('U')
        then: thrown(IllegalArgumentException)
    }

    @Ignore
    def 'correctly handles completely invalid input'() {
        when: complement.ofDNA('XXX')
        then: thrown(IllegalArgumentException)
    }

    @Ignore
    def 'correctly handles partially invalid input'() {
        when: complement.ofDNA('ACGTXXXCTTAA')
        then: thrown(IllegalArgumentException)
    }

}
