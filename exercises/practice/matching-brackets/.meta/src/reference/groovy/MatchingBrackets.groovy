class MatchingBrackets {
    private final static MAP = ['}': '{', ']': '[', ')': '(']

    static boolean isPaired(String value) {
        List<String> clean = value.findAll { MAP.containsValue(it) || MAP.containsKey(it) }
        List<String> stack = []
        for (i in clean) {
            if (MAP.containsValue(i)) {
                stack << i
            } else if (!stack.isEmpty() && MAP.get(i) == stack.last()) {
                stack.removeLast()
            } else {
                return false
            }
        }
        stack.isEmpty()
    }
}