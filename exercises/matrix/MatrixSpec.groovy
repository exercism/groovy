@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
import spock.lang.*

class MatrixSpec extends Specification {

    def 'extract row from one number matrix'() {
        given:
            String matrixAsString = '1'
            int rowIndex = 0
            int[] expected = [1]

        when:
            Matrix matrix = new Matrix(matrixAsString)

        then:
            matrix.row(rowIndex) == expected
    }

    @Ignore
    def 'extract row from matrix'() {
        given:
            String matrixAsString = '1 2\n3 4'
            int rowIndex = 1
            int[] expected = [3, 4]

        when:
            Matrix matrix = new Matrix(matrixAsString)

        then:
            matrix.row(rowIndex) == expected
    }

    @Ignore
    def 'extract row with cells having different lengths'() {
        given:
            String matrixAsString = '1 2\n30 400'
            int rowIndex = 1
            int[] expected = [30, 400]

        when:
            Matrix matrix = new Matrix(matrixAsString)

        then:
            matrix.row(rowIndex) == expected
    }

    @Ignore
    def 'extract row from non square matrix'() {
        given:
            String matrixAsString = '1 2 3\n4 5 6\n7 8 9\n8 7 6'
            int rowIndex = 2
            int[] expected = [7, 8, 9]

        when:
            Matrix matrix = new Matrix(matrixAsString)

        then:
            matrix.row(rowIndex) == expected
    }

    @Ignore
    def 'extract column from one number matrix'() {
        given:
            String matrixAsString = '1'
            int columnIndex = 0
            int[] expected = [1]

        when:
            Matrix matrix = new Matrix(matrixAsString)

        then:
            matrix.column(columnIndex) == expected
    }

    @Ignore
    def 'extract column from matrix'() {
        given:
            String matrixAsString = '1 2 3\n4 5 6\n7 8 9'
            int columnIndex = 0
            int[] expected = [1, 4, 7]

        when:
            Matrix matrix = new Matrix(matrixAsString)

        then:
            matrix.column(columnIndex) == expected
    }

    @Ignore
    def 'extract column row with cells having different lengths'() {
        given:
            String matrixAsString = '89 1903 3\n18 3 1\n9 4 800'
            int columnIndex = 0
            int[] expected = [89, 18, 9]

        when:
            Matrix matrix = new Matrix(matrixAsString)

        then:
            matrix.column(columnIndex) == expected
    }

    @Ignore
    def 'extract column from non square matrix'() {
        given:
            String matrixAsString = '1 2 3\n4 5 6\n7 8 9\n8 7 6'
            int columnIndex = 2
            int[] expected = [3, 6, 9, 6]

        when:
            Matrix matrix = new Matrix(matrixAsString)

        then:
            matrix.column(columnIndex) == expected
    }
}
