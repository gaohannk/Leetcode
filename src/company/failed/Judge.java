package company.failed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// leetcode 277
// If someone be a judge,
// 1 evenyone else should trust him
// 2 he should not trust anyone
// trust(A,B) test if A trust B
public class Judge {
    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static int findJudge(int n) {
        int judge = 0;
        for (int i = 1; i < n; i++) {
            if (judge != i && trust(judge, i)) {
                judge = i;
            }
        }
        System.out.println(judge);
        for (int i = 0; i < n; i++) {
            if (judge != i && (trust(judge, i) || !trust(i, judge))) {
                return -1;
            }
        }
        return judge;
    }

    public static boolean trust(int A, int B) {
        if (map.get(A) == null) {
            return false;
        }
        if (!map.get(A).contains(B)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        map.put(1, List.of(0, 2, 3));
        map.put(2, List.of(0, 3));
        map.put(3, List.of(0));
        System.out.println(findJudge(4));
    }
}
