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
        String[] hexes = {"00", "11", "22", "33", "44", "55", "66", "77",
                "88", "99", "aa", "bb", "cc", "dd", "ee", "ff"};

        int[] pairs = new int[3];
        pairs[0] = Integer.parseInt("" + color.charAt(1) + color.charAt(2), 16);
        pairs[1] = Integer.parseInt("" + color.charAt(3) + color.charAt(4), 16);
        pairs[2] = Integer.parseInt("" + color.charAt(5) + color.charAt(6), 16);

        StringBuilder sb = new StringBuilder("#");
        for (int pair : pairs) {
            String minStr = hexes[0];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < hexes.length; i++) {
                int val = Integer.parseInt(hexes[i], 16);
                if (Math.abs(pair - val) < min) {
                    min = Math.abs(pair - val);
                    minStr = hexes[i];
                }
            }
            sb.append(minStr);
        }
        return sb.toString();
    }
}
