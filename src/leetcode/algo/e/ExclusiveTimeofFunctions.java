package leetcode.algo.e;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];
        for (String log : logs) {
            String[] logParts = log.split(":");
            int fid = Integer.parseInt(logParts[0]);
            int time = Integer.parseInt(logParts[2]);

            if (logParts[1].equals("start")) {
                stack.push(new int[]{time, fid});
            } else {
                int start = stack.pop()[0];
                int timeSpent = time - start + 1;
                res[fid] += timeSpent;
                // minus overlap with previous func
                if (!stack.empty()) {
                    res[stack.peek()[1]] -= timeSpent;
                }
            }
        }

        return res;
    }
}
