class Matrix {
    private int[][] matrix

    private static final String ROW_SEPARATOR = '\n'
    private static final String COL_SEPARATOR = ' '

    Matrix(String m) {
        matrix = m.split(ROW_SEPARATOR).collect {
            row -> row.split(COL_SEPARATOR).collect { cell -> cell as int }
        }
    }

    int[] row(int rowNumber) {
        matrix[rowNumber]
    }

    int[] column(int columnNumber) {
        matrix.collect { it[columnNumber] }
    }
}