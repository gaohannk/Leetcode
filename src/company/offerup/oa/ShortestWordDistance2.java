package company.offerup.oa;

public class ShortestWordDistance2 {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null)
            return 0;
        int idx1 = -1, idx2 = -1;
        int diff = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                idx1 = i;
            else if (words[i].equals(word2))
                idx2 = i;
            if (idx1 != -1 && idx2 != -1) {
                diff = Math.min(diff, Math.abs(idx1 - idx2));
            }
        }
        return diff;
    }
}
