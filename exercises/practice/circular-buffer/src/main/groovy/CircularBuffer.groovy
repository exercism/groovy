class EmptyBufferException extends Exception {}
class FullBufferException extends Exception {}

class CircularBuffer {

    CircularBuffer(int capacity) {
        throw new UnsupportedOperationException('Constructor implementation is missing')
    }

    def clear() {
        throw new UnsupportedOperationException('Clear implementation is missing')
    }

    def read() {
        throw new UnsupportedOperationException('Read implementation is missing')
    }

    def write(int item) {
        throw new UnsupportedOperationException('Write implementation is missing')
    }

    def overwrite(int item) {
        throw new UnsupportedOperationException('Overwrite implementation is missing')
    }
}
