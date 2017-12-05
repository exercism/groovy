@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class RotationalCipherSpec extends Specification {
private RotationalCipher
    private RotationalCipher rotationalCipher

    def 'rotate single character by 1'() {
        rotationalCipher = new RotationalCipher(1)
        expect: rotationalCipher.rotate("a") == "b"
    }

    @Ignore
    def 'rotate single character by 26'() {
        rotationalCipher = new RotationalCipher(26)
        expect: rotationalCipher.rotate("a") == "a"
    }

    @Ignore
    def 'rotate single character by 0'() {
        rotationalCipher = new RotationalCipher(0)
        expect: rotationalCipher.rotate("a") == "a"
    }

    @Ignore
    def 'rotate single character with wrap around'() {
        rotationalCipher = new RotationalCipher(13)
        expect: rotationalCipher.rotate("n") == "a"
    }

    @Ignore
    def 'rotate capital letters'() {
        rotationalCipher = new RotationalCipher(5)
        expect: rotationalCipher.rotate("OMG") == "TRL"
    }

    @Ignore
    def 'rotate spaces'() {
        rotationalCipher = new RotationalCipher(5)
        expect: rotationalCipher.rotate("O M G") == "T R L"
    }

    @Ignore
    def 'rotate numbers'() {
        rotationalCipher = new RotationalCipher(4)
        expect:
            rotationalCipher.rotate("Testing 1 2 3 testing") ==
            "Xiwxmrk 1 2 3 xiwxmrk"
    }

    @Ignore
    def 'rotate punctuation'() {
        rotationalCipher = new RotationalCipher(21)
        expect:
            rotationalCipher.rotate("Let's eat, Grandma!") ==
            "Gzo'n zvo, Bmviyhv!"
    }

    @Ignore
    def 'rotate all letters'() {
        rotationalCipher = new RotationalCipher(13)
        expect:
            rotationalCipher.rotate(
                "Gur dhvpx oebja sbk whzcf bire gur ynml qbt.") ==
                "The quick brown fox jumps over the lazy dog."
    }

}
