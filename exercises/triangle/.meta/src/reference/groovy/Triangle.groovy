class Triangle {

    // To be valid, the triangle must have positive sides and satisfy the triangle inequality.
    static boolean isLegal(Number a, Number b, Number c) {
        (a > 0) && (b > 0) && (c > 0) && (a <= b + c) && (b <= c + a) && (c <= a + b)
    }

    // Equilateral triangles have all sides equal.
    static boolean isEquilateral(Number a, Number b, Number c) {
        isLegal(a, b, c) && (a == b) && (b == c)
    }

    // To be isosceles, at least two of the three sides must be equal.
    static boolean isIsosceles(Number a, Number b, Number c) {
        isLegal(a, b, c) && ((a == b) || (b == c) || (c == a))
    }

    // Scalene triangles have all three sides different.
    static boolean isScalene(Number a, Number b, Number c) {
        isLegal(a, b, c) && (a != b) && (b != c) && (c != a)
    }

}
