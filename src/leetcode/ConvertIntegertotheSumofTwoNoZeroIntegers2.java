package leetcode;

public class ConvertIntegertotheSumofTwoNoZeroIntegers2 {

    public int[] getNoZeroIntegers(int n){
        int y=1;
        int x=n-1;
        while(String.valueOf(x).contains("0") || String.valueOf(y).contains("0")){
            y++;
            x--;
        }
        return new int[]{y,x};
    }
}
