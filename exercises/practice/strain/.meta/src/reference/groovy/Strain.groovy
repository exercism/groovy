import groovy.transform.TailRecursive

class Strain {

    @TailRecursive
    static Collection keep(Collection collection, Closure predicate, Collection results = []) {
        if (collection.isEmpty()) {
            return results
        }
        keep(collection.tail(), predicate, (predicate(collection.head()) ? [*results, collection.head()] : results))
    }

    static Collection discard(Collection collection, Closure predicate) {
        keep(collection, { !predicate(it) })
    }

}