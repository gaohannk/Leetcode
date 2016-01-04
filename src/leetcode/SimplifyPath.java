package leetcode;

import java.util.Stack;

/* Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
/* 1 先用/来split string
 * 2 然后看每一小段，若是”.”或者是“”（说明两个/连着），不入栈；若是”..”，pop；若是正常，push
 * 3 最后再用string builder把”/”和栈中元素一个一个连起来。
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
		Stack<String> s = new Stack<String>();
		String[] split = path.split("/");
		for (String a : split) {
			if (!a.equals(".") && !a.isEmpty()) {
				if (a.equals("..")) {
					if (!s.isEmpty())
						s.pop();
				} else {
					s.push(a);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!s.isEmpty()) {
			sb.insert(0, "/"+s.pop());
		}
		return sb.length() == 0 ? "/" : sb.toString();
	}
}
