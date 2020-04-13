package company.microsoft.oa;

import java.util.ArrayList;
import java.util.List;

public class MinAdjSwapstoGroupRedBalls {
    public static int solution(String s) {
        List<Integer> redIndices = getRedIndices(s);
        int mid = redIndices.size() / 2;
        int minSwaps = 0;
        for (int i = 0; i < redIndices.size(); i++) {
            // number of swaps for each R is the distance to mid, minus the number of R's between them
            minSwaps += Math.abs(redIndices.get(mid) - redIndices.get(i)) - Math.abs(mid - i);
        }
        return minSwaps;
    }

    private static List<Integer> getRedIndices(String s) {
        List<Integer> indices = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                indices.add(i);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        System.out.println(solution("RRWRWRR"));
    }
}
