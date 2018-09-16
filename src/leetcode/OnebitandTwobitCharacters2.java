package leetcode;

public class OnebitandTwobitCharacters2 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0)
            i--;
        return (bits.length - i) % 2 == 0;
    }
}
