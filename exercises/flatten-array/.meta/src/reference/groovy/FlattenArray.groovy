class FlattenArray {
    static List flatten(List l) {
        if (l.isEmpty()) {
            return l
        }

        List ret = new ArrayList()
        def head = l[0]
        def tail = l.subList(1, l.size())

        if (head instanceof List) {
            ret.addAll(flatten((List) head))
        } else {
            ret.add(head)
        }

        ret.addAll(flatten(tail))
        ret.removeAll { it == null }
        ret
    }
}
