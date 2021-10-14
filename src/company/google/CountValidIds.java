package company.google;

import java.util.ArrayList;
import java.util.List;

public class CountValidIds {

  public static int countIds(int K, int L, char[] alphabet) {
    return helper(0, 0, -1, K, L, alphabet.length);
  }

  private static int helper(int curLen, int suffixLen, int charId, int K, int L, int length) {
    if (curLen == L) {
      return 1;
    }
    if (suffixLen == K) {
      return 0;
    }
    int totalCount = 0;
    for (int i = 0; i < length; i++) {
      suffixLen = charId == i ? suffixLen + 1 : 1;
      totalCount += helper(curLen + 1, suffixLen, i, K, L, length);
    }
    return totalCount;
  }

  public static void main(String[] args) {
    System.out.println(countIds(4, 6, new char[]{'a', 'b'}));
  }
}
