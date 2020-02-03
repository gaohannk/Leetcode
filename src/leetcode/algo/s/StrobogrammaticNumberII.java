package leetcode.algo.s;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        generateStrobogrammatic(result, "", "", n, n);
        return result;
    }

    private void generateStrobogrammatic(List<String> list, String left, String right, int n, int finalN) {
        // It's even so only join left and right.
        if (n == 0) {
            list.add(left + right);
            return;
        }
        // It's odd, so in the middle we add single strobogrammatic numbers.
        if (n == 1) {
            list.add(left + "0" + right);
            list.add(left + "1" + right);
            list.add(left + "8" + right);
            return;
        }
        // Avoid any invalid number that starts with zero.
        if(finalN != n){
            generateStrobogrammatic(list, left + "0", "0" + right, n - 2, finalN);

        }
        generateStrobogrammatic(list, left + "1", "1" + right, n - 2, finalN);
        generateStrobogrammatic(list, left + "6", "9" + right, n - 2, finalN);
        generateStrobogrammatic(list, left + "8", "8" + right, n - 2, finalN);
        generateStrobogrammatic(list, left + "9", "6" + right, n - 2, finalN);
    }
}
