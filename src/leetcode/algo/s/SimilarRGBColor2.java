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
public class SimilarRGBColor2 {
    public String similarRGB(String color) {
        int max = 0;
        String res = "";
        int red = Integer.parseInt(color.substring(1, 3), 16);
        int green = Integer.parseInt(color.substring(3, 5), 16);
        int black = Integer.parseInt(color.substring(5, 7), 16);
        for (int r = 0; r < 16; r++) {
            for (int g = 0; g < 16; g++) {
                for (int b = 0; b < 16; b++) {
                    int diff = (red - getColorValue(r)) ^ 2 + (green - getColorValue(g)) ^ 2 + (black - getColorValue(b)) ^ 2;
                    if (diff > max) {
                        max = diff;
                        res = buildString(r, g, b);
                    }
                }
            }
        }
        return res;
    }

    private String buildString(int r, int g, int b) {
        char rr = (char) (r < 10 ? r : (r - 10 + 'a'));
        char gg = (char) (g < 10 ? g : (g - 10 + 'a'));
        char bb = (char) (b < 10 ? b : (b - 10 + 'a'));
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        return sb.append(rr).append(rr).append(gg).append(gg).append(bb).append(bb).toString();
    }

    public int getColorValue(int r) {
        char c = (char) (r < 10 ? r : (r - 10 + 'a'));
        int value = Integer.parseInt("" + c + c, 16);
        return value;
    }
}
