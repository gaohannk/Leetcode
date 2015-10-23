package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/* Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example:
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadderII {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (start == null || end == null)
			return res;
		ArrayList<String> tmparray = new ArrayList<String>();

		// 如果start与end相等，直接返回
		if (start.equals(end)) {
			tmparray.add(start);
			tmparray.add(end);
			res.add(tmparray);
			return res;
		}

		// 新建一个hashmap，保存每个节点的所有前驱。
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		map.put(end, new ArrayList<String>());
		map.put(start, new ArrayList<String>());
		for (String s : dict) {
			map.put(s, new ArrayList<String>());
		}

		// 利用bfs 层序遍历 如果队列中有end 那么结束遍历（到最短的一层就结束）
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		ArrayList<String> currentlevel = new ArrayList<String>();
		while (!queue.isEmpty()) {
			int level = queue.size();
			currentlevel.clear();
			for (int i = 0; i < level; i++) {
				String top = queue.poll();
				if (dict.contains(top))
					dict.remove(top);
				currentlevel.add(top);
			}

			// 循环每个String的每个char 从a到z，在dict里面找是否有
			for (String curs : currentlevel) {
				for (int i = 0; i < curs.length(); ++i) {
					for (char j = 'a'; j <= 'z'; ++j) {
						char[] tmpchar = curs.toCharArray();
						tmpchar[i] = j;
						String tmps = new String(tmpchar);
						if (!curs.equals(start) && tmps.equals(end)) {
							map.get(end).add(curs);
							queue.offer(tmps);
						} else if (!tmps.equals(curs) && dict.contains(tmps)) {
							if (!queue.contains(tmps))
								queue.offer(tmps);
							map.get(tmps).add(curs);
						}
					}
				}
			}
			if (queue.contains(end))
				break;
		}
		tmparray.add(end);
		buildpath(start, end, map, tmparray, res);
		return res;
	}

	// 根据节点的前驱 生成路径
	public void buildpath(String start, String end, HashMap<String, ArrayList<String>> map, ArrayList<String> tmparray,
			ArrayList<ArrayList<String>> res) {
		ArrayList<String> pre = map.get(end);
		if (end.equals(start)) {
			ArrayList<String> tmparray2 = new ArrayList<String>(tmparray);
			Collections.reverse(tmparray2);
			res.add(tmparray2);
			return;
		}
		for (String s : pre) {
			tmparray.add(s);
			buildpath(start, s, map, tmparray, res);
			tmparray.remove(tmparray.size() - 1);
		}

	}
}
