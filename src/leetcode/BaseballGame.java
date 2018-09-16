package leetcode;

import java.util.Stack;

public class BaseballGame
{
    public int calPoints(String[] ops)
    {
        Stack<Integer> stack = new Stack();
        int ans = 0;
        for (String op : ops)
        {
            if (op.equals("+"))
            {
                int top = stack.pop();
                int second = stack.pop();
                int newtop = top + second;
                ans += newtop;
                stack.push(second);
                stack.push(top);
                stack.push(newtop);
            }
            else if (op.equals("C"))
            {
                ans -= stack.pop();
            }
            else if (op.equals("D"))
            {
                ans += 2 * stack.peek();
                stack.push(2 * stack.peek());
            }
            else
            {
                ans += Integer.valueOf(op);
                stack.push(Integer.valueOf(op));
            }
        }

        return ans;
    }
}

