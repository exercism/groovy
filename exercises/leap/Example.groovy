class Year {

    Integer year

    Year(Integer year) {
        this.year = year
    }

    def isLeapYear() {
        (year % 4) == 0 && ((year % 400) == 0 || (year % 100) != 0)
    }

}
