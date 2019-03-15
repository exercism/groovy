import spock.lang.*

class ResistorColorSpec extends Specification {

    @Unroll
    def '#color'() {
        expect:
        ResistorColor.colorCode(color) == result

        where:
        color    | result
        "black"  | 0
        "white"  | 9
        "orange" | 3
    }

    @Ignore
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