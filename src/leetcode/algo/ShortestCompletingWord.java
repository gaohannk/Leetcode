package leetcode.algo;

public class ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = getCounts(licensePlate);
        String ans = "";
        for (String word : words) {
            if (compare(getCounts(word.toLowerCase()), target)) {
                if (word.length() < ans.length() || ans.equals("")) {
                    ans = word;
                }
            }
        }
        return ans;
    }

    public boolean compare(int[] count1, int[] count2) {
        for (int i = 0; i < 26; ++i)
            if (count1[i] < count2[i])
                return false;
        return true;
    }

    public int[] getCounts(String word) {
        int[] ans = new int[26];
        for (char letter : word.toCharArray()) {
            int index = Character.toLowerCase(letter) - 'a';
            if (0 <= index && index < 26)
                ans[index]++;
        }
        return ans;
    }
}
