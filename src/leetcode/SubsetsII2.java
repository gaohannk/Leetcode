package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
/* 注意：
 * 1. 错写成 while(i < num.length-1) if(num[i] == num[i+1]) i++; 所犯的问题是如果发现不等了，它会死循环在这个while里面
 * 2. i < num.length - 1 i 不能取最后一个元素，因为在判断里有num[i+1] 会溢出
 */
public class SubsetsII2 {
	public class Solution {
		public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			Arrays.sort(num);
			res.add(tmp);
			dfs(res, tmp, num, 0);
			return res;
		}

		public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] num, int pos) {
			for (int i = pos; i <= num.length - 1; i++) {
				tmp.add(num[i]);
				res.add(new ArrayList<Integer>(tmp));
				dfs(res, tmp, num, i + 1);
				tmp.remove(tmp.size() - 1);
				while (i < num.length - 1 && num[i] == num[i + 1])
					i++; // 唯一的区别就在这一行
			}
		}
	}
}
