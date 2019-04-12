import spock.lang.*

class AtbashCipherSpec extends Specification {

    def "Encode yes"() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase || expected
        'yes'  || 'bvh'
    }

    @Ignore
    def "Encode no"() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase || expected
        'no'   || 'ml'
    }

    @Ignore
    def "Encode OMG"() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase || expected
        'OMG'  || 'lnt'
    }

    @Ignore
    def "Encode spaces"() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase  || expected
        'O M G' || 'lnt'
    }

    @Ignore
    def "Encode mindblowingly"() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase          || expected
        'mindblowingly' || 'nrmwy oldrm tob'
    }

    @Ignore
    def "Encode numbers"() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase                    || expected
        'Testing,1 2 3, testing.' || 'gvhgr mt123 gvhgr mt'
    }

    @Ignore
    def "Encode deep thought"() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase              || expected
        'Truth is fiction.' || 'gifgs rhurx grlm'
    }

    @Ignore
    def "Encode all the letters"() {
        expect:
        AtbashCipher.encode(phrase) == expected

        where:
        phrase                                         || expected
        'The quick brown fox jumps over the lazy dog.' || 'gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt'
    }

    @Ignore
    def "Decode exercism"() {
        expect:
        AtbashCipher.decode(phrase) == expected

        where:
        phrase      || expected
        'vcvix rhn' || 'exercism'
    }

    @Ignore
    def "Decode a sentence"() {
        expect:
        AtbashCipher.decode(phrase) == expected

        where:
        phrase                                  || expected
        'zmlyh gzxov rhlug vmzhg vkkrm thglm v' || 'anobstacleisoftenasteppingstone'
    }

    @Ignore
    def "Decode numbers"() {
        expect:
        AtbashCipher.decode(phrase) == expected

        where:
        phrase                 || expected
        'gvhgr mt123 gvhgr mt' || 'testing123testing'
    }

    @Ignore
    def "Decode all the letters"() {
        expect:
        AtbashCipher.decode(phrase) == expected

        where:
        phrase                                      || expected
        'gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt' || 'thequickbrownfoxjumpsoverthelazydog'
    }

    @Ignore
    def "Decode with too many spaces"() {
        expect:
        AtbashCipher.decode(phrase) == expected

        where:
        phrase           || expected
        'vc vix    r hn' || 'exercism'
    }

    @Ignore
    def "Decode with no spaces"() {
        expect:
        AtbashCipher.decode(phrase) == expected

        where:
        phrase                            || expected
        'zmlyhgzxovrhlugvmzhgvkkrmthglmv' || 'anobstacleisoftenasteppingstone'

    }

}