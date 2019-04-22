class Bob {

    private static boolean isSilence(String input) {
        input.isEmpty()
    }

    private static boolean isShout(String input) {
        input.toUpperCase() == input && input.toLowerCase() != input
    }

    private static boolean isQuestion(String input) {
        input.endsWith('?')
    }

    static String response(String input) {
        final String clean = input.trim()
        if (isSilence(clean)) {
            return 'Fine. Be that way!'
        }
        if (isShout(clean) && isQuestion(clean)) {
            return 'Calm down, I know what I\'m doing!'
        }
        if (isShout(clean)) {
            return 'Whoa, chill out!'
        }
        if (isQuestion(clean)) {
            return 'Sure.'
        }
        return 'Whatever.'
    }

}