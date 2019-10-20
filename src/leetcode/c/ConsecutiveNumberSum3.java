package leetcode.c;

/**
 * Created by gaohan on 5/31/18.
 */
public class ConsecutiveNumberSum3 {
    public int consecutiveNumbersSum(int N) {
        int res = 1, limit = (int) Math.sqrt(N * 2);//如果N可以分成i个连续数字，那么N>=(i+1)*i/2，相应的，i<=sqrt(N*2)
        for (int i = 2; i <= limit; i++) {
            if (i % 2 == 0 && (2 * N) % i == 0 && ((2 * N) / i) % 2 == 1)
                res++;//如果i为偶数，N必须要能被i/2整除，且除出来的数要为奇数
            if (i % 2 == 1 && N % i == 0)
                res++;//如果i为奇数，那么，只要N能被i整除，就OK
        }
        return res;
    }
}
