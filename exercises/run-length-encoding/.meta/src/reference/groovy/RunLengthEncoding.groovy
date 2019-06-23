class RunLengthEncoding {

    static String encode(String input) {
        input.replaceAll(/(.)\1*/) { group, letter -> group.length() > 1 ? "${group.length()}${letter}" : letter }
    }

    static String decode(String input) {
        input.replaceAll(/(\d+)(\D)/) { _, count, letter -> letter * (count as int) }
    }
}