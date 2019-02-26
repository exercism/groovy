@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class ResistorColorSpec extends Specification {

    def 'colorCode'() {
        expect:
        ResistorColor.colorCode(color) == result

        where:
        color    | result
        "black"  | 0
        "white"  | 9
        "orange" | 3
    }

    def 'Colors'() {
        expect:
        ResistorColor.colors == ["black",
                                 "brown",
                                 "red",
                                 "orange",
                                 "yellow",
                                 "green",
                                 "blue",
                                 "violet",
                                 "grey",
                                 "white"]
    }
}