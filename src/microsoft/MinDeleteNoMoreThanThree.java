package microsoft;

public class MinDeleteNoMoreThanThree {
    public int solution(String S) {
        // write your code in Java SE 8
        int count = 0, countB = 0;

        int res = 0;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i)==S.charAt(i-1)) {
                count++;
            } else {
                if(count >=3){
                    res += count/3;
                }
            }
        }
        return res;
    }
}
