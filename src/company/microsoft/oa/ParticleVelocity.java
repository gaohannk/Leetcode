package company.microsoft.oa;

public class ParticleVelocity {
    public static int solution(int[] A) {
        int count = 2, res = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                count++;
            } else {
                res += (count - 1) * (count - 2) / 2;
                count = 2;
            }
        }
        res += (count - 1) * (count - 2) / 2;
        return res;
    }

    public static int solution2(int[] A) {
        int totalPeriods = 0;
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            for (;i + 2 < A.length && A[i + 1] - A[i] == A[i + 2] - A[i + 1]; i++) {
                count++;
                totalPeriods += count;
            }
        }
        return totalPeriods < 1_000_000_000 ? totalPeriods : -1;
    }

    public static void main(String[] args) {
        int[] A = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
        System.out.println(solution(A));
        System.out.println(solution2(A));

    }
}
