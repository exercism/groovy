import spock.lang.*

class MatrixSpec extends Specification {

    def "Extract row from one number matrix"() {
        expect:
        new Matrix(string).row(index) == expected

        where:
        string | index || expected
        '1'    | 0     || [1]
    }

    @Ignore
    def "Can extract row"() {
        expect:
        new Matrix(string).row(index) == expected

        where:
        string     | index || expected
        '1 2\n3 4' | 1     || [3, 4]
    }

    @Ignore
    def "Extract row where numbers have different widths"() {
        expect:
        new Matrix(string).row(index) == expected

        where:
        string       | index || expected
        '1 2\n10 20' | 1     || [10, 20]
    }

    @Ignore
    def "Can extract row from non-square matrix"() {
        expect:
        new Matrix(string).row(index) == expected

        where:
        string                       | index || expected
        '1 2 3\n4 5 6\n7 8 9\n8 7 6' | 2     || [7, 8, 9]
    }

    @Ignore
    def "Extract column from one number matrix"() {
        expect:
        new Matrix(string).row(index) == expected

        where:
        string | index || expected
        '1'    | 0     || [1]
    }

    @Ignore
    def "Can extract column"() {
        expect:
        new Matrix(string).column(index) == expected

        where:
        string                | index || expected
        '1 2 3\n4 5 6\n7 8 9' | 2     || [3, 6, 9]
    }

    @Ignore
    def "Can extract column from non-square matrix"() {
        expect:
        new Matrix(string).column(index) == expected

        where:
        string                       | index || expected
        '1 2 3\n4 5 6\n7 8 9\n8 7 6' | 2     || [3, 6, 9, 6]
    }

    @Ignore
    def "Extract column where numbers have different widths"() {
        expect:
        new Matrix(string).column(index) == expected

        where:
        string                       | index || expected
        '89 1903 3\n18 3 1\n9 4 800' | 1     || [1903, 3, 4]
    }
}
