package company.offerup.phone;

import java.util.*;

/**
 * input: List<Element>
 * output: List<Double>
 * Element{
 * String type //either 'm' or 'c'
 * Metric metric
 * Compute compute
 * }
 * Metric{
 * int time
 * int val
 * }
 * Compute{
 * int min
 * int max
 * }
 * ex: input: <m, 1, 3> <m, 1, 1> <c, 1, 4> <m, 2, 3> <c, 0, 3>
 * return: 2.0, 2.3
 */
public class AverageByTimeRange {
    static class Element {
        String type;
        Metric metric;
        Compute compute;

        public Element(String m, int a, int b) {
            if (m.equals("m")) {
                this.type = "m";
                this.metric = new Metric(a, b);
            } else {
                this.type = "c";
                this.compute = new Compute(a, b);
            }
        }
    }

    static class Metric {
        int time;
        int val;

        public Metric(int a, int b) {
            this.time = a;
            this.val = b;
        }
    }

    static class Compute {
        int min;
        int max;

        public Compute(int a, int b) {
            this.min = a;
            this.max = b;
        }
    }

    static TreeMap<Integer, Integer> sumMap = new TreeMap<>(); // time -> sum
    static TreeMap<Integer, Integer> countMap = new TreeMap<>(); // time -> count

    public static List<Double> average(List<Element> elementList) {
        List<Double> res = new LinkedList<>();
        for (Element element : elementList) {
            if (element.type.equals("m")) {
                countMap.put(element.metric.time, countMap.getOrDefault(element.metric.time, 0) + 1);
                int preSum = 0;
                if (null == sumMap.get(element.metric.time)) {
                    preSum = sumMap.floorKey(element.metric.time) == null ? 0 : sumMap.floorEntry(element.metric.time).getValue();
                    sumMap.put(element.metric.time, preSum + element.metric.val);
                } else {
                    sumMap.put(element.metric.time, sumMap.get(element.metric.time) + element.metric.val);
                }

            } else {
                int total, max, min;
                // getValue
                max = sumMap.floorEntry(element.compute.max).getValue();
                min = sumMap.floorEntry(element.compute.min - 1) != null ? sumMap.floorEntry(element.compute.min).getValue() : 0;
                total = max - min;
                // getKey
                int higher = countMap.floorEntry(element.compute.max) == null ? 0 : countMap.floorEntry(element.compute.max).getKey();
                int lower = countMap.ceilingEntry(element.compute.min) == null ? 0 : countMap.ceilingEntry(element.compute.min).getKey();
                int totalCount = 0;
                for (int i = lower; i <= higher; i++) {
                    if (countMap.get(i) != null) {
                        totalCount += countMap.get(i);
                    }
                }
                res.add((double) total * 1.0 / totalCount);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Element> list = new LinkedList<>();
        list.add(new Element("m", 1, 3));
        list.add(new Element("m", 1, 1));
        list.add(new Element("c", 1, 4));
        list.add(new Element("m", 2, 3));
        list.add(new Element("c", 0, 3));
        System.out.println(average(list));
    }
}
