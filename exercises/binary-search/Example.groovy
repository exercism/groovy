class BinarySearch {

    List data

    // You may assume for this exercise that the input data is sorted in ascending order.
    BinarySearch(List data) {
        this.data = data
    }

    int indexOf(item) {
        if (data.empty) { return -1 }
        if (item < data.first()) { return -1 }
        if (item > data.last()) { return -1 }
        
        int left = 0
        int right = data.size() - 1

        while (true) {
            int middle = (left + right) / 2
            def value = data[middle]

            if (item == value) {
                // Found it, return index.
                return middle
            }

            if (left >= right) {
                // Nothing left to search!
                return -1
            }

            if (item < value) {
                // Search left half.
                right = middle - 1
            }
            else {
                // Search right half.
                left = middle + 1
            }
        }
    }

}
