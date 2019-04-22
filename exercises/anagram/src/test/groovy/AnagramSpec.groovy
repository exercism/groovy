import spock.lang.*

class AnagramSpec extends Specification {

    def "No matches"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject  | candidates                             || expected
        'diaper' | ['hello', 'world', 'zombies', 'pants'] || []
    }

    @Ignore
    def "Detects two anagrams"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject  | candidates                     || expected
        'master' | ['stream', 'pigeon', 'maters'] || ['stream', 'maters']
    }

    @Ignore
    def "Does not detect anagram subsets"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject | candidates       || expected
        'good'  | ['dog', 'goody'] || []
    }

    @Ignore
    def "Detects anagram"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject  | candidates                                || expected
        'listen' | ['enlists', 'google', 'inlets', 'banana'] || ['inlets']
    }

    @Ignore
    def "Detects three anagrams"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject = 'allergy'
        candidates = ['gallery',
                      'ballerina',
                      'regally',
                      'clergy',
                      'largely',
                      'leading']
        expected = ['gallery', 'regally', 'largely']
    }

    @Ignore
    def "Does not detect non-anagrams with identical checksum"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject | candidates || expected
        'mass'  | ['last']   || []
    }

    @Ignore
    def "Detects anagrams case-insensitively"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject     | candidates                                || expected
        'Orchestra' | ['cashregister', 'Carthorse', 'radishes'] || ['Carthorse']
    }

    @Ignore
    def "Detects anagrams using case-insensitive subject"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject     | candidates                                || expected
        'Orchestra' | ['cashregister', 'carthorse', 'radishes'] || ['carthorse']
    }

    @Ignore
    def "Detects anagrams using case-insensitive possible matches"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject     | candidates                                || expected
        'orchestra' | ['cashregister', 'Carthorse', 'radishes'] || ['Carthorse']
    }

    @Ignore
    def "Does not detect a anagram if the original word is repeated"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject | candidates   || expected
        'go'    | ['go Go GO'] || []
    }

    @Ignore
    def "Anagrams must use all letters exactly once"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject  | candidates || expected
        'tapper' | ['patter'] || []
    }

    @Ignore
    def "Words are not anagrams of themselves (case-insensitive)"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject  | candidates                     || expected
        'BANANA' | ['BANANA', 'Banana', 'banana'] || []
    }

}