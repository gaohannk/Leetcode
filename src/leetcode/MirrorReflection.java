package leetcode;

/**
 * There is a special square room with mirrors on each of the four walls.  Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.
 * <p>
 * The square room has walls of length p, and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.
 * <p>
 * Return the number of the receptor that the ray meets first.  (It is guaranteed that the ray will meet a receptor eventually.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: p = 2, q = 1
 * Output: 2
 * Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= p <= 1000
 * 0 <= q <= p
 */
public class MirrorReflection {

    public static int mirrorReflection(int p, int q) {
        double x = 0.0, y = 0.0;
        double eps = 1e-6;
        double tan = q * 1.0 / p;
        int count = 0;
        int[] sign_x = {1, -1, -1, 1};
        int[] sign_y = {1, 1, -1, -1};
        while (!stop(x, y, eps, p)) {
            x = Math.max(Math.min(p, x+ q / tan * sign_x[count % 4]), 0);
            y = Math.max(Math.min(p, y+ tan * p * sign_y[count % 4]), 0);
            count++;
        }

        if (x < eps && (y - p) < eps)
            return 2;
        else if ((x - p) < eps && y < eps)
            return 0;
        else if ((x - p) < eps && (y - p) < eps)
            return 1;

        return 0;
    }

    private static boolean stop(double x, double y, double eps, int p) {
        if ((x < eps && (y - p) < eps)
                || ((x - p) < eps && y < eps)
                || ((x - p) < eps && (y - p) < eps))
            return true;
        return false;
    }

    public static void main(String args[]){
        System.out.print(mirrorReflection(2,1));
    }
}
