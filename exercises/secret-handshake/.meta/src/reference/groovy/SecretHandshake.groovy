class SecretHandshake {

    static signals = ['wink', 'double blink', 'close your eyes', 'jump']

    private static final REVERSE_BIT_POSITION = 4

    static private boolean isBitSet(int position, int number) {
        return ((number >> position) & 1) == 1
    }

    static List<String> commands(Integer number) {
        def handshake = signals.withIndex().findAll {
            isBitSet(it[1], number)
        }.collect { it[0] }


        isBitSet(REVERSE_BIT_POSITION, number) ? handshake.reverse() : handshake
    }
}