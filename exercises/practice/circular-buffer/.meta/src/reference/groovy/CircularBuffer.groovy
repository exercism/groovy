class EmptyBufferException extends Exception {}
class FullBufferException extends Exception {}

class CircularBuffer {
    int capacity
    List data

    CircularBuffer(int capacity) {
        this.capacity = capacity
        clear()
    }

    def clear() {
        this.data = []
    }

    def isEmpty() {
        return this.data.isEmpty()
    }

    def read() {
        if (isEmpty())
            throw new EmptyBufferException()
        return this.data.pop()
    }

    def isFull() {
        return this.data.size() == this.capacity
    }

    def write(int item) {
        if (isFull())
            throw new FullBufferException()
        this.data << item
    }

    def overwrite(int item) {
        if (isFull())
            read()
        write(item)
    }
}
