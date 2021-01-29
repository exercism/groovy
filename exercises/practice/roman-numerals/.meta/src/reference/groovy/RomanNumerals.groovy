class RomanNumerals {
    private final romanMappings = [
            1000: 'M',
            900 : 'CM',
            500 : 'D',
            400 : 'CD',
            100 : 'C',
            90  : 'XC',
            50  : 'L',
            40  : 'XL',
            10  : 'X',
            9   : 'IX',
            5   : 'V',
            4   : 'IV',
            1   : 'I'
    ]

    RomanNumerals() {
        Integer.metaClass.getRoman = { ->
            StringBuilder roman = new StringBuilder()
            Integer num = delegate as Integer

            romanMappings.each() { k, v ->
                while (num >= k) {
                    roman <<= v
                    num -= k
                }
            }

            roman.toString()
        }
    }
}
