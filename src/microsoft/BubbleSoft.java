package microsoft;

import java.util.Arrays;

public class BubbleSoft {

    public static int[] sort(int[] array) {
        int last = array.length - 1;

        while (last > 0) {
            for (int i = 1; i <= last; i++) {
                if (array[i] > array[0]) {
                    swap(array, i);
                    System.out.println(Arrays.toString(array));
                }
            }
            System.out.println(Arrays.toString(array));
            swap(array, last);
            System.out.println(Arrays.toString(array));
            last--;
        }
        return array;
    }

    private static void swap(int[] array, int i) {
        int temp = array[0];
        array[0] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 1, 6, 7, 2, 8, 4};
        System.out.println(Arrays.toString(sort(array)));

    }
}
