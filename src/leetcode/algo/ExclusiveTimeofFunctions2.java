package leetcode.algo;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ExclusiveTimeofFunctions2 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> idStack = new Stack<>();
        Stack<Integer> timeStack = new Stack<>(); // store each time point, could be start (start of unit) or end (end of unit)
        int id = Integer.parseInt(logs.get(0).split(":")[0]);
        String startOrEnd = logs.get(0).split(":")[1];
        int time = Integer.parseInt(logs.get(0).split(":")[2]);
        idStack.push(id);
        timeStack.push(time);
        int lastEnd = 0;
        String last = "start";
        for (int i = 1; i < logs.size(); i++) {
            id = Integer.parseInt(logs.get(i).split(":")[0]);
            startOrEnd = logs.get(i).split(":")[1];
            time = Integer.parseInt(logs.get(i).split(":")[2]);

            if (startOrEnd.equals("start")) {
                if (last == "end") {
                    int curId = idStack.isEmpty() ? id : idStack.peek();
                    res[curId] += time - timeStack.peek() - 1; // switch
                    last = "start";
                } else {
                    res[idStack.peek()] += time - timeStack.peek();
                }
                idStack.push(id);
                timeStack.push(time);
            } else if (startOrEnd.equals("end")) {
                lastEnd = timeStack.pop();
                if (last == "start") {
                    res[idStack.pop()] += time - lastEnd + 1; // switch
                    last = "end";
                } else {
                    res[idStack.pop()] += time - lastEnd;
                }
                timeStack.push(time);
            }
            System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
        }
        return res;
    }
}
