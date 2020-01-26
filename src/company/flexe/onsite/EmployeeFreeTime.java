package company.flexe.onsite;

import leetcode.algo.i.Interval;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> list = new LinkedList<>();
        for (List<Interval> employeeSchedule : schedule) {
            list.addAll(employeeSchedule);
        }
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        List<Interval> res = new LinkedList<>();
        Interval first = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Interval second = list.get(i);
            if (second.start < first.end) {
                first.end = Math.max(second.end, first.end);
            } else {
                // avoid [3,3]
                if (first.end != second.start) {
                    res.add(new Interval(first.end, second.start));
                }
                first = second;
            }
        }
        return res;
    }
}
