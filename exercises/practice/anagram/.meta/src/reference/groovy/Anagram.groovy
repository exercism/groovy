class Anagram {

    private final String subject

    Anagram(String subject) {
        this.subject = subject
    }

    private boolean isAnagram(String other) {
        subject.toLowerCase().collect().sort() == other.toLowerCase().collect().sort()
    }

    private boolean isDuplicate(String other) {
        subject.equalsIgnoreCase(other)
    }

    List<String> find(List<String> candidates) {
        candidates.findAll { isAnagram(it) && !isDuplicate(it) }
    }
}