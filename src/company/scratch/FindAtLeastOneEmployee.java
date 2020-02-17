package company.scratch;
// Merge Interval 56

///**
// * Goal: find how many days that at least one employee work at that day.
// *     0 1 2 3 4 5 6 7 ... Infinite
// *  A  1 1    1 1 1
// *  B        1   1
// *  C  1 1       1 1
// *
// *  Input:
// *  [
// *     [
// *       [0,1], [3,5]
// *     ],
// *     [
// *       [3,3], [5,5]
// *     ],
// *     [
// *       [0,1], [5,6]
// *     ]
// *  ]
// *  Output:
// *  6
// */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindAtLeastOneEmployee {
    public int solution(int[][][] input) {
        List<int[]> intervalList = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            int[][] employee = input[i];
            for (int j = 0; j < employee.length; j++) {
                intervalList.add(employee[j]);
            }
        }
        Collections.sort(intervalList, (o1, o2) -> o1[0] - o2[0]);

        int[] first = intervalList.get(0);
        int sum = 0;
        for (int i = 1; i < intervalList.size(); i++) {
            int[] second = intervalList.get(i);
            if (first[1] > +second[0]) {
                first[1] = Math.max(first[1], second[1]);
            } else {
                sum += first[1] - first[0] + 1;
                first = second;
            }
        }
        return sum;
    }
}
