class Identifier {
    String[] tokens

    private Identifier(String[] tokens) {
        this.tokens = tokens
    }

    static Identifier of(String identifier, Casing casing) {
        String[] tokens

        switch(casing){
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

    String toCase(Casing casing) {
        String result

        switch(casing){
            case Casing.PascalCase:
                result = tokens.collect({ it[0..<1].toUpperCase() + it[1..-1].toLowerCase() }).join('')
                break
            case Casing.KebabCase:
                result = tokens.collect({ it.toLowerCase() }).join('-')
                break
            default:
                throw new IllegalArgumentException("Suggested casing not implemented.")
        }

        result
    }
}
