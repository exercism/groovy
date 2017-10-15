import spock.lang.*

class GrainsSpec extends Specification {

    @Shared
    def grains = new Grains()

    def 'square of 1' () {
        expect: 1 == grains.square(1)
    }

    def 'square of 2' () {
        expect: 2 == grains.square(2)
    }

    def 'square of 3' () {
        expect: 4 == grains.square(3)
    }


    def 'square of 4' () {
        expect: 8 == grains.square(4)
    }

    def 'square of 16' () {
        expect: 32768 == grains.square(16)
    }

    // GROOVY-7129
    def 'square of 32' () {
        expect: 2147483648 == grains.square(32)
    }

    def 'square of 64' () {
        expect: 9223372036854775808 == grains.square(64)
    }

    def 'test total' () {
        expect:
        18446744073709551615 == grains.total()
    }
}