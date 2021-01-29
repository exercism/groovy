class SumOfMultiples {

    static int sum(List<Integer> factors, int limit) {
        (1..<limit).findAll { f -> factors.any { h -> h != 0 && f % h == 0 } }.sum(0) as int
    }
}