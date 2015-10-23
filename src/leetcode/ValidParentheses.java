package leetcode;

import java.util.*;

public class ValidParentheses {
	public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		Stack<Character> stack = new Stack<Character>();
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');
		if (s.length() == 0)
			return true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(')
				stack.push(s.charAt(i));
			else {
				if (stack.isEmpty())
					return false;
				char ch = stack.pop();
				if (map.get(ch) != s.charAt(i))
					return false;
			}
		}
		return stack.isEmpty();
	}
}
