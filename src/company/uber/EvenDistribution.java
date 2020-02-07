package company.uber;

/**
 * /*
 * *
 * Given a list of sublists of data points (we use integers for simplicity) and an integer n (greater than 0), split the sublists and redistribute the data points to n sublists, so that the data points are evenly distributed across all the resulting sublists.
 *
 * Requirements
 *
 * - In the resulting list, the size of each sublist should not be smaller than its subsequent sublist. For example, [[a, b], [c, d], [e]] is OK, because its size distribution is 2-2-1, but [[a], [b, c], [d, e]] is not OK, because its distribution is 1-2-2.
 * - "Even" means balanced in size distribution, with lowest standard deviation possible, e.g. a distribution of 3-2-2 is OK, but 3-3-1 is not. The number here is the size or length of each sublist in the resulting list.
 * - If not enough elements to allocate, use an empty sublist. See example 4 below.
 * - The relative order of the numbers must be maintained.
 * Example 1
 * Input:
 *
 * [[1, 2], [3, 4, 5], [6], [7], [8]]
 * 3
 * Output:
 *
 * [[1, 2, 3], [4, 5, 6], [7, 8]]
 * Example 2
 *
 * Input:
 *
 * [[1, 1], [3, 3, 3, 3], [4], [6]]
 * 5
 * Output:
 *
 * [[1, 1], [3, 3], [3, 3], [4], [6]]
 * Example 3
 *
 * Input:
 *
 * [[9, 3, 1], [2, 8], [7]]
 * 3
 * Output:
 *
 * [[9, 3], [1, 2], [8, 7]]
 * Example 4
 *
 * Input:
 *
 * [[5, 4, 1], [1, 4]]
 * 6
 * Output:
 *
 * [[5], [4], [1], [1], [4], []]
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EvenDistribution {
    public static List<List<Integer>> evenDistrubution(List<List<Integer>> input, int n) {
        List<List<Integer>> res = new LinkedList<>();
        if (input == null || input.size() == 0) {
            return res;
        }
        if (n <= 0) {
            return null; // invalid case
        }

        int total = 0;
        List<Integer> elements = new LinkedList<>();

        for (List<Integer> list : input) {
            total += list.size();
            elements.addAll(list);
        }

        int count;
        int idx = 0;
        int nn = n;
        while (total > 0 || res.size() < nn) {

            count = total % n == 0 ? total / n : total / n + 1;

            List<Integer> item = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                if (idx < elements.size()) {
                    item.add(elements.get(idx++));
                }
                total--;
            }
            res.add(item);
            n--;
        }
        return res;
    }


    public static List<List<Integer>> evenDistrubution2(List<List<Integer>> input, int n) {
        List<List<Integer>> res = new LinkedList<>();
        if (input == null || input.size() == 0) {
            return res;
        }
        if (n == 0) {
            return null; // invalid case
        }

        int total = 0;

        for (List<Integer> list : input) {
            total += list.size();
        }

        int count;
        int nn = n;
        int p1 = 0, p2 = 0; // two pointers

        while (total > 0 || res.size() < nn) {
            count = total % n == 0 ? total / n : total / n + 1;

            List<Integer> item = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                item.add(input.get(p1).get(p2));
                p2++;
                if (p2 >= input.get(p1).size()) {
                    p1++;
                    p2 = 0;
                }
                total--;
            }
            res.add(item);
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
//         List<List<Integer>> input = new LinkedList<>();
//         List<Integer> e1 = Arrays.asList(1,2);
//         List<Integer> e2 = Arrays.asList(3,4,5);
//         List<Integer> e3 = Arrays.asList(6);
//         List<Integer> e4 = Arrays.asList(7);
//         List<Integer> e5 = Arrays.asList(8);
//         input = Arrays.asList(e1, e2,e3,e4,e5);

        List<List<Integer>> input = new LinkedList<>();
        List<Integer> e1 = Arrays.asList(5, 4, 1);
        List<Integer> e2 = Arrays.asList(1, 4);
        input = Arrays.asList(e1, e2);

        System.out.println(evenDistrubution2(input, 6));

    }
}
