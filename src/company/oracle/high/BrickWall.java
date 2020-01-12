package company.oracle.high;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                max = Math.max(map.get(sum), max);
            }
        }
        return wall.size() - max;
    }
}
