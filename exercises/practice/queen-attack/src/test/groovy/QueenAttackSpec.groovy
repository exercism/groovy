import spock.lang.*

class QueenAttackSpec extends Specification {

    // Test creation of Queens with valid and invalid positions

    def "queen with a valid position"() {
        given:
        def row = 2
        def column = 2

        when:
        def queen = new Queen(row, column)

        then:
        queen.row == row
        queen.column == column
    }

    def "queen must have positive row"() {
        when:
        new Queen(-2, 2)

        then:
        thrown(Exception)
    }

    def "queen must have row on board"() {
        when:
        new Queen(8, 4)

        then:
        thrown(Exception)
    }

    def "queen must have positive column"() {
        when:
        new Queen(2, -2)

        then:
        thrown(Exception)
    }

    def "queen must have column on board"() {
        when:
        new Queen(4, 8)

        then:
        thrown(Exception)
    }

    // Test the ability of one queen to attack another

    def "cannot attack"() {
        expect:
        def q1 = new Queen(a, b)
        def q2 = new Queen(c, d)
        QueenAttack.canAttack(q1, q2) == expected

        where:
        a | b | c | d || expected
        2 | 4 | 6 | 6 || false
    }

    def "can attack on same row"() {
        expect:
        def q1 = new Queen(a, b)
        def q2 = new Queen(c, d)
        QueenAttack.canAttack(q1, q2) == expected

        where:
        a | b | c | d || expected
        2 | 4 | 2 | 6 || true
    }

    def "can attack on same column"() {
        expect:
        def q1 = new Queen(a, b)
        def q2 = new Queen(c, d)
        QueenAttack.canAttack(q1, q2) == expected

        where:
        a | b | c | d || expected
        4 | 5 | 2 | 5 || true
    }

    def "can attack on first diagonal"() {
        expect:
        def q1 = new Queen(a, b)
        def q2 = new Queen(c, d)
        QueenAttack.canAttack(q1, q2) == expected

        where:
        a | b | c | d || expected
        2 | 2 | 0 | 4 || true
    }

    def "can attack on second diagonal"() {
        expect:
        def q1 = new Queen(a, b)
        def q2 = new Queen(c, d)
        QueenAttack.canAttack(q1, q2) == expected

        where:
        a | b | c | d || expected
        2 | 2 | 3 | 1 || true
    }

    def "can attack on third diagonal"() {
        expect:
        def q1 = new Queen(a, b)
        def q2 = new Queen(c, d)
        QueenAttack.canAttack(q1, q2) == expected

        where:
        a | b | c | d || expected
        2 | 2 | 1 | 1 || true
    }

    def "can attack on fourth diagonal"() {
        expect:
        def q1 = new Queen(a, b)
        def q2 = new Queen(c, d)
        QueenAttack.canAttack(q1, q2) == expected

        where:
        a | b | c | d || expected
        1 | 7 | 0 | 6 || true
    }

    def "cannot attack if falling diagonals are only the same when reflected across the longest falling diagonal"() {
        expect:
        def q1 = new Queen(a, b)
        def q2 = new Queen(c, d)
        QueenAttack.canAttack(q1, q2) == expected

        where:
        a | b | c | d || expected
        4 | 1 | 2 | 5 || false
    }
}
