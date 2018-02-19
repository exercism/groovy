class PhoneNumber {
    private static NANP_PATTERN =
        ~/^(?:\+?1)?[-.(\s]*([2-9]\d\d)[-.)\s]*\s?([2-9]\d\d)[-.\s]*(\d{4})\s*$/

    final String areaCode, exchange, subscriber, number, prettyNumber

    PhoneNumber(String input) {
        def matcher = (input =~ NANP_PATTERN)
        def groups = matcher ? matcher[0].tail() : ['000', '000', '0000']
        (areaCode, exchange, subscriber) = groups
        number = "${areaCode}${exchange}${subscriber}"
        prettyNumber = "(${areaCode}) ${exchange}-${subscriber}"
    }

    String toString() { prettyNumber }
}
