class PhoneNumber {
    private final static NANP_PATTERN =
            ~/^(?:\+?1)?[-.(\s]*([2-9]\d\d)[-.)\s]*\s?([2-9]\d\d)[-.\s]*(\d{4})\s*$/

    static String clean(String input) {
        def matcher = input =~ NANP_PATTERN
        if (!matcher) throw new Exception('Invalid phone number')
        def (areaCode, exchange, subscriber) = matcher[0].tail()

        "${areaCode}${exchange}${subscriber}"
    }
}
