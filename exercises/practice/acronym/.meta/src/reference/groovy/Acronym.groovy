class Acronym {

    static String abbreviate(String phrase) {
        phrase.replace('_', '')
                .split(/(?!')\W/)
                .findAll { !it.isEmpty() }
                .collect { it[0] }
                .join()
                .toUpperCase()
    }

}