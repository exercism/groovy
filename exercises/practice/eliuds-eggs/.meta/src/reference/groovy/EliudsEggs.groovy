class EliudsEggs {

    static eggCount(int number) {
        int count = 0
        int remaining = number

        while (remaining != 0) {
            if (remaining % 2 != 0) {
                count += 1
            }
            remaining /= 2
        }

        return count
    }

}
