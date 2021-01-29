class ArmstrongNumber {

    static boolean isArmstrongNumber(int number) {
        String n = number.toString()
        n.collect { Math.pow(it as int, n.length()) }.sum() == number
    }

}