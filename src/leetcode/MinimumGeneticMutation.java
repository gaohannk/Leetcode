package leetcode;

/**
 * A gene string can be represented by an 8-character long string, with choices from "A","C","G","T".
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
 * <p>
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 * <p>
 * NOTE: 1. Starting point is assumed to be valid, so it might not be included in the bank. 2. If multiple mutations are needed, all mutations during in the sequence must be valid. For example,
 * bank: "AACCGGTA"
 * start: "AACCGGTT"
 * end: "AACCGGTA"
 * return: 1
 * <p>
 * bank: "AACCGGTA", "AACCGCTA", "AAACGGTA"
 * start: "AACCGGTT"
 * end: "AAACGGTA"
 * return: 2
 * bank: "AAAACCCC", "AAACCCCC", "AACCCCCC"
 * start: "AAAAACCC"
 * end: "AACCCCCC"
 * return: 3
 */
public class MinimumGeneticMutation {

    public static int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || start.length() != end.length())
            return -1;
        StringBuilder cur = new StringBuilder(start);
        int[] min = {Integer.MAX_VALUE};
        for (int i = 0; i < start.length(); i++) {
            if (cur.charAt(i) != end.charAt(i)) {
                char c = cur.charAt(i);
                cur = cur.replace(i, i + 1, end.charAt(i) + "");
                if (exist(cur, bank)) {
                    dfs(start, end, bank, cur, 1, min);
                }
                cur = cur.replace(i, i + 1, c + "");
            }
        }
        return min[0] == Integer.MAX_VALUE ? -1 : min[0];
    }

    private static boolean exist(StringBuilder replace, String[] bank) {
        for (int i = 0; i < bank.length; i++) {
            if (replace.toString().equals(bank[i]))
                return true;
        }
        return false;
    }

    private static void dfs(String start, String end, String[] bank, StringBuilder cur, int depth, int[] min) {
        if (cur.toString().equals(end))
            min[0] = min[0] > depth ? depth : min[0];
        for (int i = 0; i < start.length(); i++) {
            if (cur.charAt(i) != end.charAt(i)) {
                char c = cur.charAt(i);
                cur = cur.replace(i, i + 1, end.charAt(i) + "");
                if (exist(cur, bank)) {
                    dfs(start, end, bank, cur, depth + 1, min);
                }
                cur = cur.replace(i, i + 1, c + "");
            }
        }
    }

    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AACCGCTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.print(minMutation(start, end, bank));
    }
}
