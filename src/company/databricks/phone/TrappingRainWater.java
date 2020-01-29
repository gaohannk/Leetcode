package company.databricks.phone;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;

        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        maxLeft[0] = height[0];
        maxRight[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            sum += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return sum;
    }
}
