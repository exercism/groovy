class SaddlePoints {

    static List<List<Integer>> getSaddlePoints(List<List<Integer>> matrix) {
        List<List<Integer>> result = []

        (0..<matrix.size()).each { row ->
            (0..<matrix[0].size()).each { col ->
                int value = matrix[row][col]

                int rowMax = matrix[row].max()
                int columnMin = matrix.collect { it[col] }.min()

                if (value == rowMax && value == columnMin) {
                    result << [row, col]
                }
            }
        }
        result
    }
}