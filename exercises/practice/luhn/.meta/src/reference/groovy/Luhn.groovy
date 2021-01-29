class Luhn {

    static boolean valid(String value) {
        def clean = value.findAll { !it.isAllWhitespace() }

        if (clean.size() <= 1 || clean.any { !it.isNumber() }) return false

        def double_every_second = clean
                .reverse()
                .collect { it as int }
                .indexed()
                .collect { i, d ->
                    int b = i % 2 != 0 ? d * 2 : d
                    b > 9 ? b - 9 : b
                }

        double_every_second.sum() % 10 == 0
    }

}
