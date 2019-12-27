package leetcode.algo.a;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayTransformation {
    public List<Integer> transformArray(int[] arr) {
        boolean isChanged = true;

        while (isChanged) {
            isChanged = false;
            int last = arr[0];
            for (int i = 1; i < arr.length - 1; i++) {
                int temp = arr[i];
                if (arr[i] < last && arr[i] < arr[i + 1]) {
                    arr[i]++;
                    isChanged = true;
                }
                if (arr[i] > last && arr[i] > arr[i + 1]) {
                    arr[i]--;
                    isChanged = true;
                }
                last = temp;
            }
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

}
