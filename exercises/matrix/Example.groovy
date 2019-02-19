class Matrix {
    private int[][] matrix

    private static final String ROW_SEPARATOR = '\n'
    private static final String COL_SEPARATOR = ' '

    Matrix(String asString) {
        String[] rows = asString.split(ROW_SEPARATOR)
        matrix = new int[rows.length][rows[0].split(COL_SEPARATOR).length]
        int i = 0
        rows.each { row ->
            String[] cells = row.split(COL_SEPARATOR)
            int j = 0
            cells.each { cell ->
                matrix[i][j] = Integer.parseInt(cell)
                j++
            }
            i++
        }
    }

    int[] row(int rowNumber) {
        matrix[rowNumber]
    }

    int[] column(columnNumber) {
        matrix.collect { row ->
            row[columnNumber]
        }
    }
}
