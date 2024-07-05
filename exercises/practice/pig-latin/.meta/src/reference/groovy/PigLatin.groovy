class PigLatin {

    static String translate(String phrase) {
        def words = phrase.split(' ')

        def vowelSound = ~"^([aeiou]|xr|yt)"
        def consonantSound = ~"^([^aeiou]+(?=y)|[^aeiou]?qu|[^aeiou]+)([a-z]+)" 

        def results = []
        for (word in words) {
            def m = word =~ vowelSound

            if (m) {
                results << word + "ay"
            } else {
                word.replaceAll(consonantSound) { match, consonant, rest ->
                    results << rest + consonant + "ay"
                }
            }
        }

        return results.join(" ")
    }
}

