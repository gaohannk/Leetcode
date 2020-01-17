package company.databricks.phone;

/**
 * 一个badge security 系统
 * 1. 给一个sorted list,是刷卡记录：
 * [
 * [ '张三', 'exit'],
 * ['lisi','enter']
 * ['wantwu','enter'],
 * ['lisi','exit']
 * ]
 * 返回谁进出没有刷卡
 * 2. follow up: 这次是unsorted list  是记录了每个人进入办公室的时间，求那些人在一小时内，进入三次以上办公室。返回人名还有每次进入的时间
 * 3. follow up: unsorted list, 给每个人进入/出去办公室的时间，输出一个group of people，满足：1）这个group在两个或两个以上不同时间段在办公室，2）返回的group是满足1）条件的人数最多的group
 */

import java.util.*;

/**
 * 1. Given a list of people who enter and exit, find the people who entered without their badge and who exited without their badge.
 * 2. Given a list of people who enter and exit, find the people who entered more than 3 times in 1 hour and then output the list of times they entered.
 * 3. Given a list of people who enter and exit, find the maximal group of people who were inside together at least 2 times and output the group and the times they were in together. All enters/exits are valid.
 */
public class MissingBadge {
    class Record {
        String name;
        String status;
        int time;
    }

    public List<String> findSolution1(List<List<String>> record) {
        List<String> res = new LinkedList<>();
        Set<String> enterSet = new HashSet<>();
        for (int i = 0; i < record.size(); i++) {
            String name = record.get(i).get(0);
            String status = record.get(i).get(1);
            if (status.equals("exit")) {
                if (!enterSet.contains(name)) {
                    res.add(name); // no badge enter
                } else {
                    enterSet.remove(name);
                }
            } else {
                enterSet.add(name);
            }
        }
        res.addAll(enterSet); // no badge exit
        return res;
    }

    public Map<String, List<Integer>> findSolution2(List<Record> records) {
        Map<String, List<Integer>> enterMap = new HashMap<>();
        Map<String, List<Integer>> res = new HashMap<>();
        for (Record record : records) {
            if (record.status.equals("enter")) {
                if (!enterMap.containsKey(record.name)) {
                    enterMap.put(record.name, new LinkedList<>());
                }
                enterMap.get(record.name).add(record.time);
            }
        }
        for (String name : enterMap.keySet()) {
            List<Integer> time = enterMap.get(name);
            Collections.sort(time);
            int start = time.get(0);
            int count = 0;
            List<Integer> times = new LinkedList<>();

            for (int i = 0; i < time.size(); i++) {
                int cur = i;
                Set<Integer> enterTime = new HashSet<>();
                while (cur < time.size() && time.get(cur) < start + 60) {
                    enterTime.add(time.get(cur));
                    count++;
                    cur++;
                }
                if (count > 3) {
                    times.addAll(enterTime);
                }
                count = 0;
            }
            res.put(name, times);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
