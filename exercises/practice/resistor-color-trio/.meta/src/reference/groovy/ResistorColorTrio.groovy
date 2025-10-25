class ResistorColorTrio {

    static final colors = ['black',
                           'brown',
                           'red',
                           'orange',
                           'yellow',
                           'green',
                           'blue',
                           'violet',
                           'grey',
                           'white']

    static String label(List<String> colorsInput) {
        def (tens, ones, zeros) = colorsInput.take(3)
                                             .collect { colors.indexOf(it) }
                                             .collect { BigInteger.valueOf(it) }

        def value = (10 * tens + ones) * BigInteger.TEN.pow(zeros)

        def idx = 0
        while (value > 0 && value % 1000 == 0) {
            idx++
            value /= 1000
        }

        def prefix = ['', 'kilo', 'mega', 'giga'][idx]

        "${value} ${prefix}ohms"
    }

}
