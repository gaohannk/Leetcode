package microsoft;

import java.util.LinkedList;
import java.util.List;

public class MergeList {
    public static List<Integer> merge(List<Integer> first, List<Integer> second) {
        int id1 = 0;
        int id2 = 0;
        List<Integer> res = new LinkedList<>();
        while (id1 < first.size() && id2 < second.size()) {
            if (first.get(id1) < second.get(id2)) {
                res.add(first.get(id1));
                id1++;
            } else {
                res.add(second.get(id2));
                id2++;
            }
        }
        while (id1 < first.size()) {
            res.add(first.get(id1++));
        }
        while (id2 < second.size()) {
            res.add(second.get(id2++));
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> first = List.of(1, 4, 6, 8);
        List<Integer> second = List.of(2, 3, 4, 8, 10, 10);

        System.out.println(merge(first, second));
    }
}
