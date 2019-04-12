import spock.lang.*

class DoubleLinkedListSpec extends Specification {

    def "Can push and pop"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.push(10)
        list.push(20)

        then:
        list.pop() == 20

        and:
        list.pop() == 10
    }

    @Ignore
    def "Can push and shift"() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>()

        when:
        list.push('10')
        list.push('20')

        then:
        list.shift() == '10'

        and:
        list.shift() == '20'
    }

    @Ignore
    def "Can unshift an shift"() {
        DoubleLinkedList<Character> list = new DoubleLinkedList<>()

        when:
        list.unshift('1')
        list.unshift('2')

        then:
        list.shift() == '2'

        and:
        list.shift() == '1'
    }

    @Ignore
    def "Can unshift and pop"() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>()

        when:
        list.unshift(10)
        list.unshift(20)

        then:
        list.pop() == 10

        and:
        list.pop() == 20
    }

    @Ignore
    def "Complete example"() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>()

        when:
        list.push('ten')
        list.push('twenty')

        then:
        list.pop() == 'twenty'

        when:
        list.push('thirty')

        then:
        list.shift() == 'ten'

        when:
        list.unshift('forty')
        list.push('fifty')

        then:
        list.shift() == 'forty'
        list.pop() == 'fifty'
        list.shift() == 'thirty'
    }
}
