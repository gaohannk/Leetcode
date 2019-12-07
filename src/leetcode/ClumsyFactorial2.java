package leetcode;

public class ClumsyFactorial2 {
    public int clumsy(int N) {
        int ans = 0, sign = 1;
        for (int i = N; i >= 1; i -= 4) {
            ans += sign * i * ((i - 1) > 0 ? (i - 1) : 1) / ((i - 2) > 0 ? i - 2 : 1) + ((i - 3) > 0 ? i - 3 : 0);
            sign = -1;
        }
        return ans;
    }

    public int clumsy2(int N) {
        int curr = N;
        int ans = 0;
        int count = 0;
        while (--N >= 1) {
            switch (count % 4) {
                case 0:
                    curr *= N;
                    break;
                case 1:
                    curr /= N;
                    break;
                case 2:
                    ans = (count == 2) ? (ans += curr) : (ans -= curr);
                    ans += N;
                    curr = 0;
                    break;
                case 3:
                    curr = N;
                    break;
            }
            count++;
        }
        return count <= 2 ? (ans += curr) : (ans -= curr);
    }
}
