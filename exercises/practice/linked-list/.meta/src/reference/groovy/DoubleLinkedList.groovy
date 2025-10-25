class DoubleLinkedList<T> {

    Element<T> head
    int n = 0

    int count() {
        n
    }

    void push(T value) {
        n++
        if (!head) {
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
        n--
        T value = head.value

        def newHead = head.next
        def newTail = head.prev

        if (newHead.is(head)) {
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

    void delete(T value) {
        if (n == 1) {
            if (head.value == value) {
                head = null
                n--
            }
        } else if (n > 1) {
            Element<T> node = head 
            while (true) {
                if (node.value == value) {
                    n--
                    node.prev.next = node.next
                    node.next.prev = node.prev
                    if (head.is(node)) {
                        head = node.next
                    }
                    return
                }
                node = node.next
                if (node.is(head)) break
            }
        }
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
