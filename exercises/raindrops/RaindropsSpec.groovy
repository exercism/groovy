#!/usr/bin/env groovy
@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class RaindropsSpec extends Specification {

    @Shared
    def raindrops = new Raindrops()

    def '1 returns 1'() {
        expect: raindrops.convert(1) == '1'
    }

    @Ignore
    def '3, being divisible by 3, returns "Pling"'() {
        expect: raindrops.convert(3) == 'Pling'
    }

    @Ignore
    def '5, divisible by 5, returns "Plang"'() {
        expect: raindrops.convert(5) == 'Plang'
    }

    @Ignore
    def '7, divisible by 7, returns "Plong"'() {
        expect: raindrops.convert(7) == 'Plong'
    }

    @Ignore
    def '6, divisible by 3, returns "Pling"'() {
        expect: raindrops.convert(6) == 'Pling'
    }

    @Ignore
    def '8 returns the string "8"'() {
        expect: raindrops.convert(8) == '8'
    }

    @Ignore
    def '9, divisible by 3, returns "Pling"'() {
        expect: raindrops.convert(9) == 'Pling'
    }

    @Ignore
    def '10, divisible by 5, returns "Plang"'() {
        expect: raindrops.convert(10) == 'Plang'
    }

    @Ignore
    def '14, divisible by 7, returns "Plong"'() {
        expect: raindrops.convert(14) == 'Plong'
    }

    @Ignore
    def '15, divisible by both 3 and 5, returns "PlingPang"'() {
        expect: raindrops.convert(15) == 'PlingPlang'
    }

    @Ignore
    def '21, divisible by 3 and 7, returns "PlingPlong"'() {
        expect: raindrops.convert(21) == 'PlingPlong'
    }

    @Ignore
    def '25, divisible by 5, returns "Plang"'() {
        expect: raindrops.convert(25) == 'Plang'
    }

    @Ignore
    def '27, divisible by 3, returns "Pling"'() {
        expect: raindrops.convert(27) == 'Pling'
    }

    @Ignore
    def '35, divisible by 5 and 7, returns "PlangPlong"'() {
        expect: raindrops.convert(35) == 'PlangPlong'
    }

    @Ignore
    def '49, divisible by 7, returns "Plong"'() {
        expect: raindrops.convert(49) == 'Plong'
    }

    @Ignore
    def '52 returns the string "52"'() {
        expect: raindrops.convert(52) == '52'
    }

    @Ignore
    def '105 returns "PlingPlangPlong"'() {
        expect: raindrops.convert(105) == 'PlingPlangPlong'
    }

    @Ignore
    def '3125, divisible by 5, returns "Plang"'() {
        expect: raindrops.convert(3125) == 'Plang'
    }

}
