import spock.lang.*

class SaddlePointsSpec extends Specification {

    def "Can identify single saddle point"() {
        expect:
        SaddlePoints.getSaddlePoints(matrix) == expected

        where:
        matrix = [
                [9, 8, 7],
                [5, 3, 2],
                [6, 6, 7]
        ]
        expected = [[1, 0]]
    }

    @Ignore
    def "Can identify that empty matrix has no saddle points"() {
        expect:
        SaddlePoints.getSaddlePoints(matrix) == expected

        where:
        matrix = []
        expected = []
    }

    @Ignore
    def "Can identify lack of saddle points when there are none"() {
        expect:
        SaddlePoints.getSaddlePoints(matrix) == expected

        where:
        matrix = [
                [1, 2, 3],
                [3, 1, 2],
                [2, 3, 1]
        ]
        expected = []
    }

    @Ignore
    def "Can identify multiple saddle points in a column"() {
        expect:
        SaddlePoints.getSaddlePoints(matrix) == expected

        where:
        matrix = [
                [4, 5, 4],
                [3, 5, 5],
                [1, 5, 4]
        ]
        expected = [[0, 1],
                    [1, 1],
                    [2, 1]]
    }

    @Ignore
    def "Can identify multiple saddle points in a row"() {
        expect:
        SaddlePoints.getSaddlePoints(matrix) == expected

        where:
        matrix = [
                [6, 7, 8],
                [5, 5, 5],
                [7, 5, 6]
        ]
        expected = [[1, 0],
                    [1, 1],
                    [1, 2]]
    }

    @Ignore
    def "Can identify saddle point in bottom right corner"() {
        expect:
        SaddlePoints.getSaddlePoints(matrix) == expected

        where:
        matrix = [
                [8, 7, 9],
                [6, 7, 6],
                [3, 2, 5]
        ]
        expected = [[2, 2]]
    }

    @Ignore
    def "Can identify saddle points in a non square matrix"() {
        expect:
        SaddlePoints.getSaddlePoints(matrix) == expected

        where:
        matrix = [
                [3, 1, 3],
                [3, 2, 4]
        ]
        expected = [[0, 0],
                    [0, 2]]

    }

    @Ignore
    def "Can identify that saddle points in a single column matrix are those with the minimum value"() {
        expect:
        SaddlePoints.getSaddlePoints(matrix) == expected

        where:
        matrix = [
                [2],
                [1],
                [4],
                [1]
        ]
        expected = [[1, 0],
                    [3, 0]]

    }

    @Ignore
    def "Can identify that saddle points in a single row matrix are those with the maximum value"() {
        expect:
        SaddlePoints.getSaddlePoints(matrix) == expected

        where:
        matrix = [
                [2, 5, 3, 5]
        ]
        expected = [[0, 1],
                    [0, 3]]

    }

}
