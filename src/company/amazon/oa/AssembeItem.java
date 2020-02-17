package company.amazon.oa;

import java.util.Arrays;

/**
 * // 给一个array表示零件的size，每次可以把两个组装在一起。每次组装的cost是两个size之和。就是数字可能重复
 * // 新组装出来零件的size也是这两个小零件size之和。问把所有零件组装成一整个的min cost。
 */
public class AssembeItem {
    // [2,3,5,7] sum = 5+ 10+17 = 32
    public static int minSum(int[] array) {
        Arrays.sort(array);
        int sum = 0;
        int last = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += (last + array[i]);
            last = last + array[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5, 7};
        System.out.println(minSum(array));
    }
}
