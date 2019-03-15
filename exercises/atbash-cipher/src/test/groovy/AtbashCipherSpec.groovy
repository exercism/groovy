import spock.lang.*

class AtbashCipherSpec extends Specification {

    def 'encode yes'() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase | expected
        "yes"  | "bvh"
    }

    @Ignore
    def 'encode no'() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase | expected
        "no"   | "ml"
    }

    @Ignore
    def 'encode OMG'() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase | expected
        "OMG"  | "lnt"
    }

    @Ignore
    def 'encode spaces'() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase  | expected
        "O M G" | "lnt"
    }

    @Ignore
    def 'encode mindblowingly'() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase          | expected
        "mindblowingly" | "nrmwy oldrm tob"
    }

    @Ignore
    def 'encode numbers'() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase                    | expected
        "Testing,1 2 3, testing." | "gvhgr mt123 gvhgr mt"
    }

    @Ignore
    def 'encode deep thought'() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase              | expected
        "Truth is fiction." | "gifgs rhurx grlm"
    }

    @Ignore
    def 'encode all the letters'() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase                                         | expected
        "The quick brown fox jumps over the lazy dog." | "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt"
    }

    @Ignore
    def 'decode exercism'() {
        expect:
        AtbashCipher.decode(phrase) == expected

        where:
        phrase      | expected
        "vcvix rhn" | "exercism"
    }

    @Ignore
    def 'decode a sentence'() {
        expect:
        AtbashCipher.decode(phrase) == expected

        where:
        phrase                                  | expected
        "zmlyh gzxov rhlug vmzhg vkkrm thglm v" | "anobstacleisoftenasteppingstone"
    }

    @Ignore
    def 'decode numbers'() {
        expect:
        AtbashCipher.decode(phrase) == expected

        where:
        phrase                 | expected
        "gvhgr mt123 gvhgr mt" | "testing123testing"
    }

    @Ignore
    def 'decode all the letters'() {
        expect:
        AtbashCipher.decode(phrase) == expected

        where:
        phrase                                      | expected
        "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt" | "thequickbrownfoxjumpsoverthelazydog"
    }

    @Ignore
    def 'decode with too many spaces'() {
        expect:
        AtbashCipher.decode(phrase) == expected

        where:
        phrase           | expected
        "vc vix    r hn" | "exercism"
    }

    @Ignore
    def 'decode with no spaces'() {
        expect:
        AtbashCipher.decode(phrase) == expected

        where:
        phrase                            | expected
        "zmlyhgzxovrhlugvmzhgvkkrmthglmv" | "anobstacleisoftenasteppingstone"

    }

}