/**
 * An identifier.
 */
class Identifier {
    String[] words

    /**
     * Store identifier as array of each word in identifier.
     * @param words The words which make up an identifier.
     */
    private Identifier(String[] words) {
        this.words = words
    }

    /**
     * Create identifier from its string representation, taking into account its casing.
     * @param identifier Identifier as string.
     * @param casing The casing of identifier.
     * @return Parsed identifier.
     */
    static Identifier of(String identifier, Casing casing) {
        String[] tokens

        switch (casing) {
            case Casing.PascalCase:
                tokens = (~/[A-Z][a-z]*/)
                        .matcher(identifier).results()
                        .map({ it.group() })
                        .toArray(String[]::new)
                break

            case Casing.KebabCase:
                tokens = identifier.split("-")
                break

            default:
                throw new IllegalArgumentException("Suggested casing not implemented.")
        }

        new Identifier(tokens)
    }

    /**
     * Convert identifier to the specified casing.
     * @param casing Desired casing of identifier.
     * @return Identifier in the specified casing.
     */
    String toCase(Casing casing) {
        String result

        switch (casing) {

            case Casing.PascalCase:
                result = words.collect({ it[0..<1].toUpperCase() + it[1..-1].toLowerCase() }).join('')
                break

            case Casing.KebabCase:
                result = words.collect({ it.toLowerCase() }).join('-')
                break

            default:
                throw new IllegalArgumentException("Suggested casing not implemented.")
        }

        result
    }
}
