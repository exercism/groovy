import spock.lang.*

class DoubleLinkedListSpec extends Specification {

    def "pop gets element from the list"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(7)

        then:
        list.pop() == 7
    }

    @Ignore
    def "push/pop respectively add/remove at the end of the list"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(11)
        list.push(13)

        then:
        list.pop() == 13

        and:
        list.pop() == 11
    }

    @Ignore
    def "shift gets an element from the list"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(17)

        then:
        list.shift() == 17
    }

    @Ignore
    def "shift gets first element from the list"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(23)
        list.push(5)

        then:
        list.shift() == 23

        and:
        list.shift() == 5
    }

    @Ignore
    def "unshift adds element at start of the list"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.unshift(23)
        list.unshift(5)

        then:
        list.shift() == 5

        and:
        list.shift() == 23
    }

    @Ignore
    def "pop, push, shift, and unshift can be used in any order"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        given:
        list.push(1)
        list.push(2)
        def a = list.pop()
        list.push(3)
        def b = list.shift()
        list.unshift(4)
        list.push(5)
        def c = list.shift()
        def d = list.pop()
        def e = list.shift()

        expect:
        a == 2
        b == 1
        c == 4
        d == 5
        e == 3
    }

    @Ignore
    def "count an empty list"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        expect:
        list.count() == 0
    }

    @Ignore
    def "count a list with items"() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>()

        when:
        list.push('one')
        list.push('two')

        then:
        list.count() == 2
    }

    @Ignore
    def "count is correct after mutation"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        given:
        list.push(31)
        def a = list.count()
        list.unshift(43)
        def b = list.count()
        list.shift()
        def c = list.count()
        list.pop()
        def d = list.count()

        expect:
        a == 1
        b == 2
        c == 1
        d == 0
    }

    @Ignore
    def "popping to empty doesn't break the list"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(41)
        list.push(59)
        list.pop()
        list.pop()
        list.push(47)

        then:
        list.count() == 1

        and:
        list.pop() == 47
    }

    @Ignore
    def "shifting to empty doesn't break the list"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(41)
        list.push(59)
        list.shift()
        list.shift()
        list.push(47)

        then:
        list.count() == 1

        and:
        list.pop() == 47
    }

    @Ignore
    def "deletes the only element"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(61)
        list.delete(61)

        then:
        list.count() == 0
    }

    @Ignore
    def "deletes the element with the specified value from the list"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(71)
        list.push(83)
        list.push(79)
        list.delete(83)

        then:
        list.count() == 2
        list.pop() == 79
        list.shift() == 71
    }

    @Ignore
    def "deletes the element with the specified value from the list, re-assigns tail"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(71)
        list.push(83)
        list.push(79)
        list.delete(83)

        then:
        list.count() == 2
        list.pop() == 79
        list.pop() == 71
    }

    @Ignore
    def "deletes the element with the specified value from the list, re-assigns head"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(71)
        list.push(83)
        list.push(79)
        list.delete(83)

        then:
        list.count() == 2
        list.shift() == 71
        list.shift() == 79
    }

    @Ignore
    def "deletes the first of two elements"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(97)
        list.push(101)
        list.delete(97)

        then:
        list.count() == 1
        list.pop() == 101
    }

    @Ignore
    def "deletes the second of two elements"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        given:
        list.push(97)
        list.push(101)
        list.delete(101)

        expect:
        list.count() == 1
        list.pop() == 97
    }

    @Ignore
    def "delete does not modify the list if the element is not found"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(89)
        list.delete(103)

        then:
        list.count() == 1
    }

    @Ignore
    def "deletes only the first occurrence"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(73)
        list.push(9)
        list.push(9)
        list.push(107)
        list.delete(9)

        then:
        list.count() == 3
        list.pop() == 107
        list.pop() == 9
        list.pop() == 73
    }
}
