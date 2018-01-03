package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by gaohan on 8/9/17.
 */
//TLE
public class TwoKeysKeyboard {
    public static int minSteps(int n) {
        int[] minStep = new int[n + 1];
        HashMap<Integer, HashSet<Integer>> pasteNum = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            helper(minStep, pasteNum, i);
        }
        return minStep[n];
    }

    public static void helper(int[] minStep, HashMap<Integer, HashSet<Integer>> pasteNum, int n) {
        if (n == 1) {
            minStep[1] = 0;
            HashSet<Integer> set = new HashSet<>();
            pasteNum.put(1,set);
            return;
        }
        if (n == 2) {
            minStep[2] = 2;
            HashSet<Integer> set = new HashSet<>();
            set.add(1);
            pasteNum.put(2, set);
            return;
        }
        int min = Integer.MAX_VALUE;
        LinkedList<Integer> tempLastCopyNum = new LinkedList<>();
        LinkedList<Integer> tempMin = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = n - 1; i >= n / 2 ; i--) {
            for (Integer lastCopyNum : pasteNum.get(i)) {
                int count = 1;
                while (i + lastCopyNum * count < n) {
                    count++;
                }
                if (i + lastCopyNum * count == n) {
                    if (min >= minStep[i] + count) {
                        min = minStep[i] + count;
                        tempLastCopyNum.add(lastCopyNum);
                        tempMin.add(min);
                    }
                }
                if (i + i == n) {
                    if (min >= minStep[i] + 2) {
                        min = minStep[i] + 2;
                        tempLastCopyNum.add(i);
                        tempMin.add(min);
                    }
                }
            }
        }
        for (int i = 0; i < tempMin.size(); i++) {
            if (tempMin.get(i) == min)
                set.add(tempLastCopyNum.get(i));
        }

        pasteNum.put(n, set);
        minStep[n] = min;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(minSteps(1000));
        System.out.println("Time: " + String.valueOf(System.currentTimeMillis() - start));
    }
}
