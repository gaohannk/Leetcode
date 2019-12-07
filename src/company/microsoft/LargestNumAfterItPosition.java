package company.microsoft;

/**
 * Find largest element after each position of an array. eg. [6,7,0,3,1,2] -> [7,3,3,2,2,-1]
 */
public class LargestNumAfterItPosition {

    public int[] getLargestElementAfterItself(int[] A) {
        int pre = A[A.length - 1];
        A[A.length - 1] = -1;
        for (int i = A.length - 2; i >= 0; i--) {
            int tmp = A[i];
            A[i] = Math.max(A[i + 1], pre);
            pre = tmp;
        }

        return A;
    }
}
