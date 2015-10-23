package leetcode;
/*You are given a string “s” which contains characters [a - z], please find one of the longest substring which is in consecutive alphabetical order.
E.g. For “zfgabdefozfhijkaieluvwxkf”, the answer might be “hijk” or “uvwx”, but “abdef” is not an answer because there supposed to be a “c” between “b” and “d”.
*/
/*“”abdfhoqwefhhdf”
“abcdefghi”
“ihgfedcba”
“acefhj”
“a”   “”    “mmmmmm”  “aabbccddee”    
*/
public class Longestsubstring {

	public class solution {
		public String longestsubstring(String str) {
			int[] max = new int[2];
			if (str == null || str.length() == 0)
				return null;
			if (str.length() == 1)
				return str;
			for (int i = 1; i < str.length(); i++) {
				int begin = 0;
				begin = i;
				while (i < str.length()) {
					if (str.charAt(i) != str.charAt(i - 1) + 1) {
						break;
					} else {
						i++;
						continue;
					}
				} // while
				int length = i - begin;
				if (length > (max[1] - max[0])) {
					max[0] = begin;
					max[1] = i;
				} // if
			} // for
			return str.substring(max[0], max[1] + 1);
		}
	}
}


                                    