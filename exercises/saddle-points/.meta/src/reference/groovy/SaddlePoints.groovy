class SaddlePoints {

    static getSaddlePoints(matrix) {
        def result = []

        if (!matrix.isEmpty()) {
            for (row in 0..matrix.size - 1) {
                for (col in 0..matrix[0].size - 1) {
                    int value = matrix[row][col]

                    int rowMax = matrix[row].max()
                    int columnMin = matrix.collect { it[col] }.min()

                    if (value == rowMax && value == columnMin) {
                        result.add([row, col])
                    }
                }
            }
        }
        return result
    }
}