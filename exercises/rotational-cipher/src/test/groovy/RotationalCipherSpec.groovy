import spock.lang.*

class RotationalCipherSpec extends Specification {


    def "Rotate a by 0, same output as input"() {
        expect:
        new RotationalCipher(shiftKey).rotate(text) == expected

        where:
        shiftKey | text || expected
        0        | 'a'  || 'a'
    }

    @Ignore
    def "Rotate a by 1"() {
        expect:
        new RotationalCipher(shiftKey).rotate(text) == expected

        where:
        shiftKey | text || expected
        1        | 'a'  || 'b'
    }

    @Ignore
    def "Rotate a by 26, same output as input"() {
        expect:
        new RotationalCipher(shiftKey).rotate(text) == expected

        where:
        shiftKey | text || expected
        26       | 'a'  || 'a'
    }

    @Ignore
    def "Rotate m by 13"() {
        expect:
        new RotationalCipher(shiftKey).rotate(text) == expected

        where:
        shiftKey | text || expected
        13       | 'm'  || 'z'
    }

    @Ignore
    def "Rotate n by 13 with wrap around alphabet"() {
        expect:
        new RotationalCipher(shiftKey).rotate(text) == expected

        where:
        shiftKey | text || expected
        13       | 'n'  || 'a'
    }

    @Ignore
    def "Rotate capital letters"() {
        expect:
        new RotationalCipher(shiftKey).rotate(text) == expected

        where:
        shiftKey | text  || expected
        5        | 'OMG' || 'TRL'
    }

    @Ignore
    def "Rotate spaces"() {
        expect:
        new RotationalCipher(shiftKey).rotate(text) == expected

        where:
        shiftKey | text    || expected
        5        | 'O M G' || 'T R L'
    }

    @Ignore
    def "Rotate numbers"() {
        expect:
        new RotationalCipher(shiftKey).rotate(text) == expected

        where:
        shiftKey | text                    || expected
        4        | 'Testing 1 2 3 testing' || 'Xiwxmrk 1 2 3 xiwxmrk'
    }

    @Ignore
    def "Rotate punctuation"() {
        expect:
        new RotationalCipher(shiftKey).rotate(text) == expected

        where:
        shiftKey | text                  || expected
        21       | "Let's eat, Grandma!" || "Gzo'n zvo, Bmviyhv!"
    }

    @Ignore
    def "Rotate all letters"() {
        expect:
        new RotationalCipher(shiftKey).rotate(text) == expected

        where:
        shiftKey | text                                           || expected
        13       | 'Gur dhvpx oebja sbk whzcf bire gur ynml qbt.' || 'The quick brown fox jumps over the lazy dog.'
    }

}
