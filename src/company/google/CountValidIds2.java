package company.google;

import java.util.Arrays;

// O(L*K^2)
public class CountValidIds2 {

  public static int countIds(int K, int L, char[] alphabet) {
    int[][] suffixCount = new int[L][K];
    suffixCount[0][0] = alphabet.length;

    for (int i = 1; i < L; i++) {
      int suffixLenIsOneCount = 0;
      for (int k = 0; k < K; k++) {
        suffixLenIsOneCount += suffixCount[i - 1][k] * (alphabet.length - 1);
      }
      suffixCount[i][0] = suffixLenIsOneCount;
      for (int j = 1; j < K; j++) {
        suffixCount[i][j] = suffixCount[i - 1][j - 1];
      }
      System.out.println(Arrays.deepToString(suffixCount));
    }
    int total = 0;
    for (int i = 0; i < K; i++) {
      total += suffixCount[L - 1][i];
    }
    return total;
  }

  public static void main(String[] args) {
    System.out.println(countIds(4, 6, new char[]{'a', 'b'}));
  }
}
