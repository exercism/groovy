class Leap {

    private final int year

    Leap(int year) {
        this.year = year
    }

    boolean isLeapYear() {
        (year % 4) == 0 && ((year % 400) == 0 || (year % 100) != 0)
    }

}
