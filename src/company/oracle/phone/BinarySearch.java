package company.oracle.phone;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return array[start] == target ? start : -1;
    }

    public static int binarySearchDuplicate(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return array[start] == target ? start : -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 2, 2, 3, 6, 8, 20};
        System.out.println(binarySearchDuplicate(array, 2));
    }
}
