package leetcode.algo.t;

import java.util.*;

public class TaskScheduler2 {
	public static int leastInterval(char[] tasks, int n) {
		int[] map = new int[26];
		for (char c : tasks)
			map[c - 'A']++;
		Arrays.sort(map);
		int time = 0;
		while (map[25] > 0) {
			int i = 0;
			while (i <= n) {
				// all tasks done
				if (map[25] == 0)
					break;
				if (i < 26 && map[25 - i] > 0)
					map[25 - i]--;
				time++;
				i++;
			}
			Arrays.sort(map);
		}
		return time;
	}

	public static void main(String[] args) {
		char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		int n = 2;
		System.out.println(leastInterval(tasks, n));
	}
}
