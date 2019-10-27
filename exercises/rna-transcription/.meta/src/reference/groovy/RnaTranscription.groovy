class RnaTranscription {
    private final static String SOURCE = 'GCTA'
    private final static String REPLACEMENT = 'CGAU'

    static String toRna(String strand) {
        strand.tr(SOURCE, REPLACEMENT)
    }

}
