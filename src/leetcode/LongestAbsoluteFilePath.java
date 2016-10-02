package leetcode;

import java.util.Stack;

/*Suppose we abstract our file system by a string in the following manner:
The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.
Note:
The name of a file contains at least a . and an extension.
The name of a directory or sub-directory will not contain a ..
Time complexity required: O(n) where n is the size of the input string.

Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
*/
public class LongestAbsoluteFilePath {
	public static int lengthLongestPath(String input) {
		String inputs[] = input.split("\n");
		Stack<String> stack = new Stack<String>();
		int length = 0;
		int max = 0;
		int level = -1;
		for (String s : inputs) {
			if (s.contains(".")) {
				s = s.replaceAll("\t", "");
				length += s.length();
				max = max > length ? max : length;
				length -= s.length();
			} else {
				int cur = getLevel(s);
				// System.out.println(cur + "," + level);
				if (cur <= level) {
					while (cur - 1 != level) {
						length = length - stack.pop().length() - 1;
						level--;
					}
				}
				s = s.replaceAll("\t", "");
				length += s.length() + 1;
				stack.push(s);
				level++;
			}
		}
		return max;
	}

	private static int getLevel(String s) {
		String cur = s.replaceAll("\t", "");
		return s.length() - cur.length();
	}

	public static void main(String[] args) {
		// String test="\t\tabc.ef";
		// System.out.println(test.replaceAll("\t", ""));
		String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		String[] inputs = input.split("\n");
		System.out.println(inputs[0]);
		System.out.println(inputs[1]);

		String input2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println(lengthLongestPath(input));
	}
}
