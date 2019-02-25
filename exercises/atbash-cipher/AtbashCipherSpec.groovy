@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class AtbashCipherSpec extends Specification {

    def 'encode yes'() {
        given:
        def input = "yes"

        when:
        def result = AtbashCipher.encode(input)

        then:
        result == "bvh"
    }

    def 'encode no'() {
        given:
        def input = "no"

        when:
        def result = AtbashCipher.encode(input)

        then:
        result == "ml"
    }

    def 'encode OMG'() {
        given:
        def input = "OMG"

        when:
        def result = AtbashCipher.encode(input)

        then:
        result == "lnt"
    }

    def 'encode spaces'() {
        given:
        def input = "O M G"

        when:
        def result = AtbashCipher.encode(input)

        then:
        result == "lnt"
    }

    def 'encode mindblowingly'() {
        given:
        def input = "mindblowingly"

        when:
        def result = AtbashCipher.encode(input)

        then:
        result == "nrmwy oldrm tob"
    }

    def 'encode numbers'() {
        given:
        def input = "Testing,1 2 3, testing."

        when:
        def result = AtbashCipher.encode(input)

        then:
        result == "gvhgr mt123 gvhgr mt"
    }

    def 'encode deep thought'() {
        given:
        def input = "Truth is fiction."

        when:
        def result = AtbashCipher.encode(input)

        then:
        result == "gifgs rhurx grlm"
    }

    def 'encode all the letters'() {
        given:
        def input = "The quick brown fox jumps over the lazy dog."

        when:
        def result = AtbashCipher.encode(input)

        then:
        result == "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt"
    }

    def 'decode exercism'() {
        given:
        def input = "vcvix rhn"

        when:
        def result = AtbashCipher.decode(input)

        then:
        result == "exercism"
    }

    def 'decode a sentence'() {
        given:
        def input = "zmlyh gzxov rhlug vmzhg vkkrm thglm v"

        when:
        def result = AtbashCipher.decode(input)

        then:
        result == "anobstacleisoftenasteppingstone"
    }

    def 'decode numbers'() {
        given:
        def input = "gvhgr mt123 gvhgr mt"

        when:
        def result = AtbashCipher.decode(input)

        then:
        result == "testing123testing"
    }

    def 'decode all the letters'() {
        given:
        def input = "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt"

        when:
        def result = AtbashCipher.decode(input)

        then:
        result == "thequickbrownfoxjumpsoverthelazydog"
    }

    def 'decode with too many spaces'() {
        given:
        def input = "vc vix    r hn"

        when:
        def result = AtbashCipher.decode(input)

        then:
        result == "exercism"
    }

    def 'decode with no spaces'() {
        given:
        def input = "zmlyhgzxovrhlugvmzhgvkkrmthglmv"

        when:
        def result = AtbashCipher.decode(input)

        then:
        result == "anobstacleisoftenasteppingstone"
    }

}