import spock.lang.*

class ListOpsSpec extends Specification {

    @Unroll
    def "append entries to a list and return the new list - #label"() {
        expect:
        ListOps.append(list1, list2) == expected

        where:
        label                   || list1        || list2        || expected
        "empty lists"           || []           || []           || []
        "list to empty list"    || []           || [1, 2, 3, 4] || [1, 2, 3, 4]
        "empty list to list"    || [1, 2, 3, 4] || []           || [1, 2, 3, 4]
        "non-empty-lists"       || [1, 2]       || [2, 3, 4, 5] || [1, 2, 2, 3, 4, 5]
    }

    @Ignore
    @Unroll
    def "concatenate a list of lists - #label"() {
        expect:
        ListOps.concatenate(lists) == expected

        where:
        label                   || lists                                    || expected
        "empty list"            || []                                       || []
        "list of lists"         || [[1, 2], [3], [], [4, 5, 6]]             || [1, 2, 3, 4, 5, 6]
        "list of nested lists"  || [[[1], [2]], [[3]], [[]], [[4, 5, 6]]]   || [[1], [2], [3], [], [4, 5, 6]]
    }

    @Ignore
    @Unroll
    def "filter list returning only values that satisfy the filter function - #label"() {
        expect:
        ListOps.filter(list, { x -> x % 2 == 1 }) == expected

        where:
        label               || list         || expected
        "empty list"        || []           || []
        "non-empty list"    || [1, 2, 3, 5] || [1, 3, 5]
    }

    @Ignore
    @Unroll
    def "return the length of a list - #label"() {
        expect:
        ListOps.length(list) == expected

        where:
        label               || list         || expected
        "empty list"        || []           || 0
        "non-empty list"    || [1, 2, 3, 5] || 4
    }

    @Ignore
    @Unroll
    def "return a list of elements whose values equal the list value transformed by the mapping function - #label"() {
        expect:
        ListOps.map(list, { x -> x + 1 }) == expected

        where:
        label               || list         || expected
        "empty list"        || []           || []
        "non-empty list"    || [1, 3, 5, 7] || [2, 4, 6, 8]
    }

    @Ignore
    @Unroll
    def "folds (reduces) the given list from the left with a function - #label"() {
        expect:
        ListOps.foldl(list, fn, initial) == expected

        where:
        label                                                       || list         || fn                               || initial  || expected
        "empty list"                                                || []           || { acc, el -> el * acc }          || 2        || 2
        "direction independent function applied to non-empty list"  || [1, 2, 3, 4] || { acc, el -> el + acc }          || 5        || 15
        "direction dependent function applied to non-empty list"    || [2, 5]       || { acc, el -> acc.intdiv(el) }    || 5        || 0
    }

    @Ignore
    @Unroll
    def "folds (reduces) the given list from the right with a function - #label"() {
        expect:
        ListOps.foldr(list, fn, initial) == expected

        where:
        label                                                       || list         || fn                               || initial  || expected
        "empty list"                                                || []           || { acc, el -> el * acc }          || 2        || 2
        "direction independent function applied to non-empty list"  || [1, 2, 3, 4] || { acc, el -> el + acc }          || 5        || 15
        "direction dependent function applied to non-empty list"    || [2, 5]       || { acc, el -> acc.intdiv(el) }    || 5        || 0
    }

    @Ignore
    @Unroll
    def "reverse the elements of the list - #label"() {
        expect:
        ListOps.reverse(list) == expected

        where:
        label                               || list                         || expected
        "empty list"                        || []                           || []
        "non-empty list"                    || [1, 3, 5, 7]                 || [7, 5, 3, 1]
        "list of lists is not flattened"    || [[1, 2], [3], [], [4, 5, 6]] || [[4, 5, 6], [], [3], [1, 2]]
    }

}
