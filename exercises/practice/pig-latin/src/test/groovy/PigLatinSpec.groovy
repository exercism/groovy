import spock.lang.*

class PigLatinSpec extends Specification {

    @Unroll
    def "ay is added to words that start with vowels - #label"() {
        expect:
        PigLatin.translate(phrase) == expected

        where:
        label                                               | phrase    || expected
        'word beginning with a'                             | 'apple'   || 'appleay'
        'word beginning with e'                             | 'ear'     || 'earay'
        'word beginning with i'                             | 'igloo'   || 'iglooay'
        'word beginning with o'                             | 'object'  || 'objectay'
        'word beginning with u'                             | 'under'   || 'underay'
        'word beginning with a vowel and followed by a qu'  | 'equal'   || 'equalay'
    }

    @Unroll
    @Ignore
    def "first letter and ay are moved to the end of words that start with consonants - #label"() {
        expect:
        PigLatin.translate(phrase) == expected

        where:
        label                                           | phrase    || expected
        'word beginning with p'                         | 'pig'     || 'igpay'
        'word beginning with k'                         | 'koala'   || 'oalakay'
        'word beginning with x'                         | 'xenon'   || 'enonxay'
        'word beginning with q without a following u'   | 'qat'     || 'atqay'
    }

    @Unroll
    @Ignore
    def "some letter clusters are treated like a single consonant - #label"() {
        expect:
        PigLatin.translate(phrase) == expected

        where:
        label                                               | phrase    || expected
        'word beginning with ch'                            | 'chair'   || 'airchay'
        'word beginning with qu'                            | 'queen'   || 'eenquay'
        'word beginning with qu and a preceding consonant'  | 'square'  || 'aresquay'
        'word beginning with th'                            | 'therapy' || 'erapythay'
        'word beginning with thr'                           | 'thrush'  || 'ushthray'
        'word beginning with sch'                           | 'school'  || 'oolschay'
    }

    @Unroll
    @Ignore
    def "some letter clusters are treated like a single vowel - #label"() {
        expect:
        PigLatin.translate(phrase) == expected

        where:
        label                       | phrase    || expected
        'word beginning with yt'    | 'yttria'  || 'yttriaay'
        'word beginning with xr'    | 'xray'    || 'xrayay'
    }

    @Unroll
    @Ignore
    def "position of y in a word determines if it is a consonant or a vowel - #label"() {
        expect:
        PigLatin.translate(phrase) == expected

        where:
        label                                                           | phrase    || expected
        'y is treated like a consonant at the beginning of a word'      | 'yellow'  || 'ellowyay'
        'y is treated like a vowel at the end of a consonant cluster'   | 'rhythm'  || 'ythmrhay'
        'y as second letter in two letter word'                         | 'my'      || 'ymay'
    }

    @Ignore
    def "phrases are translated - a whole phrase"() {
        expect:
        PigLatin.translate(phrase) == expected

        where:
        phrase              || expected
        'quick fast run'    || 'ickquay astfay unray'
    }
}

