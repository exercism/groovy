class ListOps {

    static append(list1, list2) {
        if(list1.size == 0) {
            list2
        } else {
            def first = list1.pop()
            [first] + append(list1, list2)
        }
    }

    static concatenate(lists) {
        foldl(lists, this.&append, [])
    }

    static filter(list, fn) {
        def results = []
        for (elt in list) {
            if(fn(elt)) {
                results << elt
            }
        }
        results
    }

    static length(list) {
        foldl(list, { acc, elt -> acc + 1 }, 0)
    }
    static map(list, fn) {
        def results = []
        for (elt in list) {
            results << fn(elt)
        }
        results
    }

    static foldl(list, fn, initial) {
        def results = initial
        for (item in list) {
            results = fn(results, item)
        }
        results
    }

    static foldr(list, fn, initial) {
        if(list.size == 0) {
            initial
        } else {
            def last = list.removeLast()
            foldr(list, fn, fn(initial, last))
        }
    }

    static reverse(list) {
        def results = []
        def end = list.size -1
        end.step(-1, -1) { results << list[it] }
        results
    }

}
