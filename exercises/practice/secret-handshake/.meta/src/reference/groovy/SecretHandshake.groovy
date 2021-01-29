class SecretHandshake {

    private static final SIGNALS = [
            1: 'wink',
            2: 'double blink',
            4: 'close your eyes',
            8: 'jump'
    ]

    private static final REVERSE_BIT_POSITION = 16

    static List<String> commands(int number) {
        List<String> handshake = SIGNALS.findAll { number & it.key }*.value
        number & REVERSE_BIT_POSITION ? handshake.reverse() : handshake
    }
}