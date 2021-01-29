import spock.lang.*

class RunLengthEncodingSpec extends Specification {

    @Unroll
    def "Run-length encode #string"() {
        expect:
        new RunLengthEncoding().encode(string) == expected

        where:
        string                                                  || expected
        ''                                                      || ''
        'XYZ'                                                   || 'XYZ'
        'AABBBCCCC'                                             || '2A3B4C'
        'WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB' || '12WB12W3B24WB'
        '  hsqq qww  '                                          || '2 hs2q q2w2 '
        'aabbbcccc'                                             || '2a3b4c'
    }

    @Ignore
    @Unroll
    def "Run-length decode #string"() {
        expect:
        new RunLengthEncoding().decode(string) == expected

        where:
        string          || expected
        ''              || ''
        'XYZ'           || 'XYZ'
        '2A3B4C'        || 'AABBBCCCC'
        '12WB12W3B24WB' || 'WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB'
        '2 hs2q q2w2 '  || '  hsqq qww  '
        '2a3b4c'        || 'aabbbcccc'
    }

    @Ignore
    def "Encode followed by decode gives original string"() {
        setup:
        RunLengthEncoding run = new RunLengthEncoding()

        expect:
        run.decode(run.encode(string)) == expected

        where:
        string       || expected
        'zzz ZZ  zZ' || 'zzz ZZ  zZ'
    }

}