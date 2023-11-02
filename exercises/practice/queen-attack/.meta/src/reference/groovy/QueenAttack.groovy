class QueenAttack {

    static canAttack(Queen q1, Queen q2) {
        int rowDelta = (q1.row - q2.row).abs()
        int columnDelta = (q1.column - q2.column).abs()
        return rowDelta == 0 || columnDelta == 0 || rowDelta == columnDelta
    }
}
