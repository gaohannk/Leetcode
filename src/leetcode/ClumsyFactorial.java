package leetcode;

public class ClumsyFactorial {
    public int clumsy(int N) {
        if (N == 1) {return 1;}
        if (N == 2) {return 2;}
        if (N == 3) {return 6;}
        if (N == 4) {return 7;}

        int res = N + 1;

        int remain = N - 3;

        if (remain % 4 == 0) {res -= 2;}
        if (remain % 4 == 2 || (remain % 4 == 3)) {res += 1;}

        return res;
    }
}
