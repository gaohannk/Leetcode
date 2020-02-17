package company.amazon.oa;

import java.util.*;

public class AirplaneCapacity {
    public List<List<Integer>> solution(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList) {
        int max = 0;
        Collections.sort(forwardRouteList, Comparator.comparingInt(e -> e.get(1)));
        Collections.sort(returnRouteList, Comparator.comparingInt(e -> e.get(1)));

        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < forwardRouteList.size(); i++) {
            for (int j = returnRouteList.size() - 1; j >= 0; j--) {
                int curSum = forwardRouteList.get(i).get(1) + returnRouteList.get(j).get(1);
                if (curSum > maxTravelDist) {
                    continue;
                }
                if (curSum > max) {
                    res.clear();
                    List<Integer> index = new LinkedList<>();
                    index.add(forwardRouteList.get(i).get(0));
                    index.add(returnRouteList.get(j).get(0));
                    res.add(index);
                    max = curSum;
                } else if (curSum == max) {
                    List<Integer> index = new LinkedList<>();
                    index.add(forwardRouteList.get(i).get(0));
                    index.add(returnRouteList.get(j).get(0));
                    res.add(index);
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
