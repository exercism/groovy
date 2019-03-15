class ArmstrongNumber {

    static isArmstrongNumber(number) {
        def sNumber = number.toString()
        return sNumber.collect { it ->
            Math.pow(it.toInteger(), sNumber.length()) as int
        }.sum() == number
    }

}