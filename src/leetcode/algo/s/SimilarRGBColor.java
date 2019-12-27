package leetcode.algo.s;

/**
 * In the following, every capital letter represents some hexadecimal digit from 0 to f.
 * <p>
 * The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand.  For example, "#15c" is shorthand for the color "#1155cc".
 * <p>
 * Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.
 * <p>
 * Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it can be represented as some "#XYZ"
 * <p>
 * Example 1:
 * Input: color = "#09f166"
 * Output: "#11ee66"
 * Explanation:
 * The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
 * This is the highest among any shorthand color.
 * Note:
 * <p>
 * color is a string of length 7.
 * color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f
 * Any answer which has the same (highest) similarity as the best answer will be accepted.
 * All inputs and outputs should use lowercase letters, and the output is 7 characters.
 */
public class SimilarRGBColor {
    public String similarRGB(String color) {
        int hex1 = Integer.parseInt(color.substring(1), 16);
        int ans = 0;
        for (int r = 0; r < 16; ++r)
            for (int g = 0; g < 16; ++g)
                for (int b = 0; b < 16; ++b) {
                    int hex2 = 17 * r * (1 << 16) + 17 * g * (1 << 8) + 17 * b;
                    if (similarity(hex1, hex2) > similarity(hex1, ans))
                        ans = hex2;
                }

        return String.format("#%06x", ans);
    }

    public int similarity(int hex1, int hex2) {
        int ans = 0;
        for (int shift = 16; shift >= 0; shift -= 8) {
            int col1 = (hex1 >> shift) % 256;
            int col2 = (hex2 >> shift) % 256;
            ans -= (col1 - col2) * (col1 - col2);
        }
        return ans;
    }
}
