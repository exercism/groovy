@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class FlattenArraySpec extends Specification {

    def flattener

    def setup() {
        flattener = new FlattenArray()
    }

    def "flat list is preserved"() {
        when:
            def l = [0, '1', 'two']
        then:
            flattener.flatten(l) == [0, '1', 'two']
    }

    @Ignore
    def "single level of nesting without nulls"() {
        when:
            def l = [1, ['2', 3, 4, 5, 'six', '7'], 8]
        then:
            flattener.flatten(l) == [1, '2', 3, 4, 5, 'six', '7', 8]
    }

    @Ignore
    def "five levels of nesting without nulls"() {
        when:
            def l = [0, '2', [[2, 'three'], '8', 100, 'four', [[[50]]], '-2']]
        then:
            flattener.flatten(l) == [0, '2', 2, 'three', '8', 100, 'four', 50, '-2']
    }

    @Ignore
    def "six levels of nesting without nulls"() {
        when:
            def l = ['one', ['2', [[3]], ['4', [[5]]], 'six', 7], '8']
        then:
            flattener.flatten(l) == ['one', '2', 3, '4', 5, 'six', 7, '8']
    }

    @Ignore
    def "six levels of nesting with nulls"() {
        when:
            def l = ['0', 2, [['two', '3'], '8', [['one hundred']], null, [[null]]], 'negative two']
        then:
            flattener.flatten(l) == ['0', 2, 'two', '3', '8', 'one hundred', 'negative two']
    }

    @Ignore
    def "nested lists full of nulls only"() {
        when:
            def l = [null, [[[null]]], null, null, [[null, null], null], null]
        then:
            flattener.flatten(l) == []
    }
}
