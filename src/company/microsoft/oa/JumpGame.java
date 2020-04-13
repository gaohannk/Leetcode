package company.microsoft.oa;

import java.util.*;

/**
 * You are given an array of non-negative integers arr and a start index. When you are at an index i, you can move left or right by arr[i]. Your task is to figure out if you can reach value 0.
 *
 * Example 1:
 *
 * Input: arr = [3, 4, 2, 3, 0, 3, 1, 2, 1], start = 7
 * Output: true
 * Explanation: left -> left -> right
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 3, 0, 3, 1, 2, 1};
        int start = 7;
        System.out.println(canReach0DFS(nums, start));
        System.out.println(canReach0BFS(nums, start));
    }

    private static boolean canReach0BFS(int[] nums, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (nums[cur] == 0)
                return true;
            if (!visited.contains(cur)) {
                visited.add(cur);
                if (cur - nums[cur] >= 0)
                    q.offer(cur - nums[cur]);
                if (cur + nums[cur] < nums.length)
                    q.offer(cur + nums[cur]);
            }
        }
        return false;
    }

    private static boolean canReach0DFS(int[] nums, int start) {
        Set<Integer> visited = new HashSet<>();
        List<String> lst = new ArrayList<>();
        return dfs(nums, visited, start, lst);
    }

    private static boolean dfs(int[] nums, Set<Integer> visited, int cur, List<String> lst) {
        if (cur < 0 || cur >= nums.length || visited.contains(cur))
            return false;
        if (nums[cur] == 0) {
            System.out.println(lst);
            return true;
        }
        visited.add(cur);
        lst.add("left");
        boolean lRes = dfs(nums, visited, cur - nums[cur], lst);
        lst.remove(lst.size() - 1);
        if (lRes) {
            return true;
        }
        lst.add("right");
        boolean rRes = dfs(nums, visited, cur + nums[cur], lst);
        lst.remove(lst.size() - 1);
        if (rRes) {
            return true;
        }
        return false;
    }
}
