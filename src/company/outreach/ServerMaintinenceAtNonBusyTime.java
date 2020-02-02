package company.outreach;

import java.util.LinkedList;
import java.util.List;

public class ServerMaintinenceAtNonBusyTime {
    public static int findMaintinenceStartTime(List<List<Integer>> busy_times, int duriation) {
        if (busy_times.size() == 0) {
            return 0;
        }
        if (busy_times.size() == 1) {
            if (busy_times.get(0).get(0) - 0 > duriation) {
                return 0;
            } else {
                return 1440 - busy_times.get(0).get(1) > duriation ? busy_times.get(0).get(1) : -1;
            }
        }

        List<Integer> first = busy_times.get(0);
        List<Integer> last = new LinkedList<>();
        last.add(first.get(0) + 1440);
        last.add(first.get(1) + 1440);
        busy_times.add(last);

        for (int i = 1; i < busy_times.size(); i++) {
            List<Integer> second = busy_times.get(i);
            if (first.get(1) < second.get(0)) {
                if (second.get(0) - first.get(1) > duriation) {
                    return first.get(1);
                } else {
                    continue;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> busy_times = new LinkedList<>();
        List<Integer> first = new LinkedList<>();
        first.add(0);
        first.add(50);
        busy_times.add(first);
        System.out.println(findMaintinenceStartTime(busy_times, 50));
    }
}
