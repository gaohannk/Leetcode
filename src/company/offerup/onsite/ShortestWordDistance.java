package company.offerup.onsite;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, diff = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
            } else if (words[i].equals(word2)) {
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                diff = Math.min(diff, Math.abs(p2 - p1));
            }
        }
        return diff;
    }
}
