class DoubleLinkedList<T> {

    Element<T> head

    void push(T value) {
        if(!head) {
            head = new Element<>(value, null, null)
            head.next = head
            head.prev = head
            return
        }

        def oldTail = head.prev
        def tail = new Element<>(value, oldTail, head)
        oldTail.next = tail
        head.prev = tail
    }

    T pop() {
        head = head.prev
        shift()
    }

    T shift() {
        T value = head.value

        def newHead = head.next
        def newTail = head.prev

        if(newHead.is(head)) {
            head = null
        } else {
            newHead.prev = newTail
            newTail.next = newHead
            head = newHead
        }

        value
    }

    void unshift(T value) {
        push(value)
        head = head.prev
    }

    private static final class Element<T> {
        final T value
        Element<T> prev
        Element<T> next

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value
            this.prev = prev
            this.next = next
        }
    }
}
