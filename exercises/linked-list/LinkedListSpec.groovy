@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class DoubleLinkedListSpec extends Specification {

    def 'can push and pop'() {
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
    def 'can push and shift'() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>()
        when:
            list.push("10")
            list.push("20")
        then:
            list.shift() == "10"
        and:
            list.shift() == "20"
    }

    @Ignore
    def 'can unshift an shift'() {
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
    def 'can unshift and pop'() {
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
    def 'complete example'() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>()
        when:
            list.push("ten")
            list.push("twenty")

        then:
            list.pop() == "twenty"

        when:
            list.push("thirty")

        then:
            list.shift() == "ten"

        when:
            list.unshift("forty")
            list.push("fifty")

        then:
            list.shift() == "forty"
            list.pop() == "fifty"
            list.shift() == "thirty"

    }
}
