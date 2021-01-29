import spock.lang.*

class AllYourBaseSpec extends Specification {

    def "Single bit one to decimal"() {
        given:
        def base = new AllYourBase(inputBase, digits)

        expect:
        base.rebase(outputBase) == expected

        where:
        inputBase | digits | outputBase || expected
        2         | [1]    | 10         || [1]
    }

    @Ignore
    def "Single decimal to binary"() {
        given:
        def base = new AllYourBase(inputBase, digits)

        expect:
        base.rebase(outputBase) == expected

        where:
        inputBase | digits | outputBase || expected
        10        | [5]    | 2          || [1, 0, 1]
    }

    @Ignore
    def "Binary to multiple decimal"() {
        given:
        def base = new AllYourBase(inputBase, digits)

        expect:
        base.rebase(outputBase) == expected

        where:
        inputBase | digits             | outputBase || expected
        2         | [1, 0, 1, 0, 1, 0] | 10         || [4, 2]
    }

    @Ignore
    def "Decimal to binary"() {
        given:
        def base = new AllYourBase(inputBase, digits)

        expect:
        base.rebase(outputBase) == expected

        where:
        inputBase | digits | outputBase || expected
        10        | [4, 2] | 2          || [1, 0, 1, 0, 1, 0]
    }

    @Ignore
    def "Trinary to hexadecimal"() {
        given:
        def base = new AllYourBase(inputBase, digits)

        expect:
        base.rebase(outputBase) == expected

        where:
        inputBase | digits       | outputBase || expected
        3         | [1, 1, 2, 0] | 16         || [2, 10]
    }

    @Ignore
    def "Hexadecimal to trinary"() {
        given:
        def base = new AllYourBase(inputBase, digits)

        expect:
        base.rebase(outputBase) == expected

        where:
        inputBase | digits  | outputBase || expected
        16        | [2, 10] | 3          || [1, 1, 2, 0]
    }

    @Ignore
    def "15-bit integer"() {
        given:
        def base = new AllYourBase(inputBase, digits)

        expect:
        base.rebase(outputBase) == expected

        where:
        inputBase | digits      | outputBase || expected
        97        | [3, 46, 60] | 73         || [6, 10, 45]
    }

    @Ignore
    def "Empty list"() {
        given:
        def base = new AllYourBase(inputBase, digits)

        expect:
        base.rebase(outputBase) == expected

        where:
        inputBase | digits | outputBase || expected
        2         | []     | 10         || [0]
    }

    @Ignore
    def "Single zero"() {
        given:
        def base = new AllYourBase(inputBase, digits)

        expect:
        base.rebase(outputBase) == expected

        where:
        inputBase | digits | outputBase || expected
        10        | [0]    | 2          || [0]
    }

    @Ignore
    def "Multiple zeros"() {
        given:
        def base = new AllYourBase(inputBase, digits)

        expect:
        base.rebase(outputBase) == expected

        where:
        inputBase | digits    | outputBase || expected
        10        | [0, 0, 0] | 2          || [0]
    }

    @Ignore
    def "Leading zeros"() {
        given:
        def base = new AllYourBase(inputBase, digits)

        expect:
        base.rebase(outputBase) == expected

        where:
        inputBase | digits    | outputBase || expected
        7         | [0, 6, 0] | 10         || [4, 2]
    }

    @Ignore
    def "Input base is one"() {
        when:
        new AllYourBase(inputBase, digits).rebase(outputBase)

        then:
        thrown(ArithmeticException)

        where:
        inputBase | digits | outputBase
        1         | [0]    | 10
    }

    @Ignore
    def "Input base is zero"() {
        when:
        new AllYourBase(inputBase, digits).rebase(outputBase)

        then:
        thrown(ArithmeticException)

        where:
        inputBase | digits | outputBase
        1         | []     | 10
    }

    @Ignore
    def "Input base is negative"() {
        when:
        new AllYourBase(inputBase, digits).rebase(outputBase)

        then:
        thrown(ArithmeticException)

        where:
        inputBase | digits | outputBase
        -2        | [1]    | 10
    }

    @Ignore
    def "Negative digit"() {
        when:
        new AllYourBase(inputBase, digits).rebase(outputBase)

        then:
        thrown(ArithmeticException)

        where:
        inputBase | digits              | outputBase
        2         | [1, -1, 1, 0, 1, 0] | 10
    }

    @Ignore
    def "Invalid positive digit"() {
        when:
        new AllYourBase(inputBase, digits).rebase(outputBase)

        then:
        thrown(ArithmeticException)

        where:
        inputBase | digits             | outputBase
        2         | [1, 2, 1, 0, 1, 0] | 10
    }

    @Ignore
    def "Output base is one"() {
        when:
        new AllYourBase(inputBase, digits).rebase(outputBase)

        then:
        thrown(ArithmeticException)

        where:
        inputBase | digits             | outputBase
        2         | [1, 0, 1, 0, 1, 0] | 1
    }

    @Ignore
    def "Output base is zero"() {
        when:
        new AllYourBase(inputBase, digits).rebase(outputBase)

        then:
        thrown(ArithmeticException)

        where:
        inputBase | digits | outputBase
        10        | [7]    | 0
    }

    @Ignore
    def "Output base is negative"() {
        when:
        new AllYourBase(inputBase, digits).rebase(outputBase)

        then:
        thrown(ArithmeticException)

        where:
        inputBase | digits | outputBase
        2         | [1]    | -7
    }

    @Ignore
    def "Both bases are negative"() {
        when:
        new AllYourBase(inputBase, digits).rebase(outputBase)

        then:
        thrown(ArithmeticException)

        where:
        inputBase | digits | outputBase
        -2        | [1]    | -7
    }

}