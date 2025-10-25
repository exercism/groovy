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
        'solemn' | ['lemons', 'cherry', 'melons'] || ['lemons', 'melons']
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
    def "Detects multiple anagrams with different case"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject = 'nose'
        candidates = ['Eons', 'ONES']
        expected = ['Eons', 'ONES']
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
    def "Does not detect an anagram if the original word is repeated"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject | candidates || expected
        'go'    | ['goGoGO'] || []
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
    def "Words are not anagrams of themselves"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject  | candidates || expected
        'BANANA' | ['BANANA'] || []
    }

    @Ignore
    def "Words are not anagrams of themselves even if the letter case is partially different"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject  | candidates || expected
        'BANANA' | ['Banana'] || []
    }

    @Ignore
    def "Words are not anagrams of themselves even if the letter case is completely different"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject  | candidates || expected
        'BANANA' | ['banana'] || []
    }

    @Ignore
    def "Words other than themselves can be anagrams"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject  | candidates           || expected
        'LISTEN' | ['Listen', 'Silent'] || ['Silent']
    }

    @Ignore
    def "Handles case of greek letters"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject  | candidates                   || expected
        'ΑΒΓ'    | ['ΒΓΑ', 'ΒΓΔ', 'γβα', 'αβγ'] || ['ΒΓΑ', 'γβα']
    }

    @Ignore
    def "Different characters may have the same bytes"() {
        expect:
        new Anagram(subject).find(candidates) == expected

        where:
        subject  | candidates || expected
        'a⬂'     | ['€a']     || []
    }

}
