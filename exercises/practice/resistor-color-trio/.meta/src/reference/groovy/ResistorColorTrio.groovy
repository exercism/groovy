class ResistorColorTrio {

    static final colors = ['black',
                           'brown',
                           'red',
                           'orange',
                           'yellow',
                           'green',
                           'blue',
                           'violet',
                           'grey',
                           'white']

    static String label(List<String> colorsInput) {
        def (tens, ones, zeros) = colorsInput
        int value = (colors.indexOf(tens) * 10 + colors.indexOf(ones)) * (10**colors.indexOf(zeros))

        value < 1000 ? "${value} ohms" : "${value / 1000} kiloohms"
    }

}