class Sieve {

    static primes(Integer limit) {
        if (limit < 2) {
            return []
        }

        def results = []
        def nums = (2..limit).collect()
        while (nums.size() > 0) {
            def (head, tail) = [nums.head(), nums.tail()]
            results.add(head)
            nums = tail.findAll { it % head != 0 }
        }

        results
    }

}
