class Series {

    static List<String> slices(String series, int sliceLength) {
        if (sliceLength < 1 || sliceLength > series.size()) {
            throw new ArithmeticException('invalid slice length')
        }

        series.collect().collate(sliceLength, 1, false).collect { it.join() }
    }
}