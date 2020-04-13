package company.microsoft.oa;

public class NumberOfFairIndex {
    public static void main(String[] args) {
        int[] A1 = {4, -1, 0, 3}, B1 = {-2, 5, 0, 3};
        int[] A2 = {2, -2, -3, 3}, B2 = {0, 0, 4, -4};
        int[] A3 = {4, -1, 0, 3}, B3 = {-2, 6, 0, 4};
        int[] A4 = {3, 2, 6}, B4 = {4, 1, 6};
        int[] A5 = {1, 4, 2, -2, 5}, B5 = {7, -2, -2, 2, 5};
        System.out.println(getNumOfFairIndexes(A1, B1));
        System.out.println(getNumOfFairIndexes(A2, B2));
        System.out.println(getNumOfFairIndexes(A3, B3));
        System.out.println(getNumOfFairIndexes(A4, B4));
        System.out.println(getNumOfFairIndexes(A5, B5));
    }

    private static int getNumOfFairIndexes(int[] A, int[] B) {
        int res = 0, sumA = 0, sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
            sumB += B[i];
        }
        int leftA = 0, leftB = 0;
        for (int i = 0; i < A.length - 1; i++) {
            leftA += A[i];
            leftB += B[i];
            int rightA = sumA - leftA;
            int rightB = sumB - leftB;
            if (leftA == rightA && leftB == rightB && leftA == leftB)
                res++;
        }
        return res;
    }
}
