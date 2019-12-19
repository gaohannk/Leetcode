package leetcode.algo.x;


import java.util.HashMap;
import java.util.Map;

public class XofaKindinaDeckofCards2 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : deck) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int g = map.values().iterator().next();
        for (int value : map.values()) {
            g = gcd(g, value);
        }
        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
