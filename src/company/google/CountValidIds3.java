package company.google;

import java.util.Arrays;

// O(L*K)
public class CountValidIds3 {

  public static int countIds(int K, int L, char[] alphabet) {
    int[] suffixCount = new int[K];
    suffixCount[0] = alphabet.length;
    for (int i = 1; i < L; i++) {
      int suffixLenIsOneCount = 0;
      for (int k = 0; k < K; k++) {
        suffixLenIsOneCount += suffixCount[k] * (alphabet.length - 1);
      }
      // Copy from right to left to avoid overwrite
      for (int j = K -1; j >= 1; j--) {
        suffixCount[j] = suffixCount[j - 1];
      }
      suffixCount[0] = suffixLenIsOneCount;

      System.out.println(Arrays.toString(suffixCount));
    }
    int total = 0;
    for (int i = 0; i < K; i++) {
      total += suffixCount[i];
    }
    return total;
  }

  public static void main(String[] args) {
    System.out.println(countIds(4, 6, new char[]{'a', 'b'}));
  }
}
