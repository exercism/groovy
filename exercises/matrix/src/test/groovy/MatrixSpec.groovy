import spock.lang.*

class MatrixSpec extends Specification {

    def 'Extract row from one number matrix'() {
        expect:
        new Matrix(string).row(index) == expected

        where:
        string | index | expected
        "1"    | 0     | [1]
    }

    @Ignore
    def 'Extract row from matrix'() {
        expect:
        new Matrix(string).row(index) == expected

        where:
        string     | index | expected
        "1 2\n3 4" | 1     | [3, 4]
    }

    @Ignore
    def 'Extract row with cells having different lengths'() {
        expect:
        new Matrix(string).row(index) == expected

        where:
        string        | index | expected
        "1 2\n30 400" | 1     | [30, 400]
    }

    @Ignore
    def 'Extract row from non square matrix'() {
        expect:
        new Matrix(string).row(index) == expected

        where:
        string                       | index | expected
        "1 2 3\n4 5 6\n7 8 9\n8 7 6" | 2     | [7, 8, 9]
    }

    @Ignore
    def 'Extract column from one number matrix'() {
        expect:
        new Matrix(string).row(index) == expected

        where:
        string | index | expected
        "1"    | 0     | [1]
    }

    @Ignore
    def 'Extract column from matrix'() {
        expect:
        new Matrix(string).column(index) == expected

        where:
        string                | index | expected
        "1 2 3\n4 5 6\n7 8 9" | 0     | [1, 4, 7]
    }

    @Ignore
    def 'extract column row with cells having different lengths'() {
        expect:
        new Matrix(string).column(index) == expected

        where:
        string                       | index | expected
        "89 1903 3\n18 3 1\n9 4 800" | 0     | [89, 18, 9]
    }

    @Ignore
    def 'extract column from non square matrix'() {
        expect:
        new Matrix(string).column(index) == expected

        where:
        string                       | index | expected
        "1 2 3\n4 5 6\n7 8 9\n8 7 6" | 2     | [3, 6, 9, 6]
    }
}
