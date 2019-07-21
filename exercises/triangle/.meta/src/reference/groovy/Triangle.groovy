class Triangle {
    private int distinctSideCount
    private boolean isLegal

    Triangle(Number a, Number b, Number c) {
        def list = [a, b, c]
        this.isLegal = 2 * list.max() < list.sum()
        this.distinctSideCount = list.toSet().size()
    }

    boolean isEquilateral() {
        isLegal && distinctSideCount == 1
    }

    boolean isIsosceles() {
        isLegal && distinctSideCount <= 2
    }

    boolean isScalene() {
        isLegal && distinctSideCount == 3
    }

}
