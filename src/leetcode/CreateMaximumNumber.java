package leetcode;

import java.util.Arrays;

/**
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.
 * <p>
 * Example 1:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * return [9, 8, 6, 5, 3]
 * <p>
 * Example 2:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * return [6, 7, 6, 0, 4]
 * <p>
 * Example 3:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * return [9, 8, 9]
 */
public class CreateMaximumNumber {
    class Pair implements Comparable<Pair> {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return o.val - this.val;
        }
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        Pair[] p1 = new Pair[len1];
        Pair[] p2 = new Pair[len2];
        for (int i = 0; i < nums1.length; i++) {
            p1[i] = new Pair(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            p2[i] = new Pair(nums2[i], i);
        }
        Arrays.sort(p1);
        Arrays.sort(p2);
        int start1 = 0, start2 = 0;
        int cur = k;
        int num1Arrive = -1, num2Arrive = -1;
        int res[] = new int[k];
        while (start1 < len1 && start2 < len2) {
            if (p1[start1].index < num1Arrive || p2[start2].index < num2Arrive) {
                if (p1[start1].index < num1Arrive) {
                    start1++;
                }
                if (p2[start2].index < num2Arrive) {
                    start2++;
                }
                continue;
            }

            if (p1[start1].val > p2[start2].val) {
                if (len1 - 1 - p1[start1].index + len2 - 1 - num2Arrive >= cur - 1) {
                    res[k - cur] = p1[start1].val;
                    num1Arrive = p1[start1].index;
                    cur--;
                }
                start1++;
            } else if (p1[start1].val < p2[start2].val) {
                if (len2 - 1 - p2[start2].index + len1 - 1 - num1Arrive >= cur - 1) {
                    res[k - cur] = p2[start2].val;
                    num2Arrive = p2[start2].index;
                    cur--;
                }
                start2++;
            } else {
                if (isEnough(p1[start1].index, num2Arrive, len1, len2, cur - 1) && !isEnough(p2[start2].index, num1Arrive, len1, len2, cur - 1)) {
                    res[k - cur] = p1[start1].val;
                    num1Arrive = p1[start1].index;
                    cur--;
                    start1++;
                } else if (!isEnough(p1[start1].index, num2Arrive, len1, len2, cur - 1) && isEnough(p2[start2].index, num1Arrive, len1, len2, cur - 1)) {
                    res[k - cur] = p2[start2].val;
                    num2Arrive = p2[start2].index;
                    cur--;
                    start2++;
                } else {
                    int i = 0;
                    while (p1[start1].index - i > num1Arrive && p2[start2].index - i > num2Arrive && nums1[p1[start1].index - i] != nums2[p2[start2].index - i]) {
                        i++;
                    }
                    if (p1[start1].index - i > num1Arrive || p2[start2].index - i > num2Arrive)
                        i--;
                    if (nums1[p1[start1].index - i] > nums2[p2[start2].index - i]) {
                        res[k - cur] = p2[start2].val;
                        num2Arrive = p2[start2].index;
                        cur--;
                        start2++;
                    } else if (nums1[p1[start1].index - i] < nums2[p2[start2].index - i]) {
                        res[k - cur] = p1[start1].val;
                        num1Arrive = p1[start1].index;
                        cur--;
                        start1++;
                    }
                }
            }
        }
        return res;
    }


    private boolean isEnough(int i1, int i2, int len1, int len2, int left) {
        return len1 - 1 - i1 + len2 - 1 - i2 >= left;
    }
}
