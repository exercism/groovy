class PascalsTriangle {

    static rows(count) {
        def lines = []

        for (int i = 0; i < count; i++) {
            def row = []
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1)
                } else {
                    row.add(lines[i - 1][j - 1] + lines[i - 1][j])
                }
            }
            lines.add(row)
        }

        return lines
    }
}
