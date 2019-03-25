import spock.lang.*

class FlattenArraySpec extends Specification {

    @Shared
    def flattener = new FlattenArray()

    def 'Flat list is preserved'() {
        expect:
        flattener.flatten(array) == expected

        where:
        array           | expected
        [0, '1', 'two'] | [0, '1', 'two']
    }

    @Ignore
    def 'single level of nesting without nulls'() {
        expect:
        flattener.flatten(array) == expected

        where:
        array                              | expected
        [1, ['2', 3, 4, 5, 'six', '7'], 8] | [1, '2', 3, 4, 5, 'six', '7', 8]
    }

    @Ignore
    def 'five levels of nesting without nulls'() {
        expect:
        flattener.flatten(array) == expected

        where:
        array = [0, '2', [[2, 'three'], '8', 100, 'four', [[[50]]], '-2']]
        expected = [0, '2', 2, 'three', '8', 100, 'four', 50, '-2']
    }

    @Ignore
    def 'six levels of nesting without nulls'() {
        expect:
        flattener.flatten(array) == expected

        where:
        array = ['one', ['2', [[3]], ['4', [[5]]], 'six', 7], '8']
        expected = ['one', '2', 3, '4', 5, 'six', 7, '8']
    }

    @Ignore
    def 'six levels of nesting with nulls'() {
        expect:
        flattener.flatten(array) == expected

        where:
        array = ['0', 2, [['two', '3'], '8', [['one hundred']], null, [[null]]], 'negative two']
        expected = ['0', 2, 'two', '3', '8', 'one hundred', 'negative two']
    }

    @Ignore
    def 'nested lists full of nulls only'() {
        expect:
        flattener.flatten(array) == expected

        where:
        array                                                      | expected
        [null, [[[null]]], null, null, [[null, null], null], null] | []
    }
}
