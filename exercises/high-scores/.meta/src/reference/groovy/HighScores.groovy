class HighScores {
    final List<Integer> scores

    HighScores(List<Integer> scores) {
        this.scores = scores
    }

    int latest() {
        scores.last()
    }

    int personalBest() {
        scores.max()
    }

    List<Integer> personalTopThree() {
        scores.sort { -it }.take(3)
    }
}