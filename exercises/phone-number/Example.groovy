class PhoneNumber {

    private static def REGEX = ~/^1?[\s\.\-\(]*(\d{3})[\s\.\-\)]*\s?(\d{3})[\s\.\-]*(\d{4})$/

    String areaCode = '000', exchange = '000', subscriber = '0000'

    public PhoneNumber(String input) {
        def matcher = REGEX.matcher(input)
        if ( matcher.matches() ) {
            areaCode   = "${matcher.group(1)}"
            exchange   = "${matcher.group(2)}"
            subscriber = "${matcher.group(3)}"
        }
    }

    String getNumber() { "${areaCode}${exchange}${subscriber}" }

    String toString() { "(${areaCode}) ${exchange}-${subscriber}" }

}
