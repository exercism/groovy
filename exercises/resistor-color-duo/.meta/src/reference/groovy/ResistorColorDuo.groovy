class ResistorColorDuo {

    static final colors = ["black",
                           "brown",
                           "red",
                           "orange",
                           "yellow",
                           "green",
                           "blue",
                           "violet",
                           "grey",
                           "white"]

    static int value(List<String> colorsInput) {
        colorsInput.take(2).collect { colors.indexOf(it) }.join() as int
    }
}