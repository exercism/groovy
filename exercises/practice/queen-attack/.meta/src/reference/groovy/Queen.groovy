class Queen {
    final int row
    final int column

    Queen(int row, int column) {
        if (row < 0 || row > 7)
            throw new Exception("invalid row")
        if (column < 0 || column > 7)
            throw new Exception("invalid column")

        this.row = row
        this.column = column
    }
}
