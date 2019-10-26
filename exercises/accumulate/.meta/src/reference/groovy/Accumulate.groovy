class Accumulate {

    static accumulate(Collection collection, Closure func) {
        def results = []
        collection.each {
            results << func(it)
        }
        results
    }

}