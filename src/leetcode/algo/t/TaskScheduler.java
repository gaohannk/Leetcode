package leetcode.algo.t;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
	public static int leastInterval(char[] tasks, int n) {
		Queue<Data> queue = new PriorityQueue<>();
		Map<Character, Integer> freqMap = new HashMap<>();

		for (int i = 0; i < tasks.length; i++) {
			freqMap.put(tasks[i], freqMap.getOrDefault(tasks[i], 0) + 1);
		}
		for (char c : freqMap.keySet()) {
			queue.add(new Data(c, 0));
		}
		int time = 0;
		while (!queue.isEmpty()) {
			Data task = queue.peek();
			// available for schedule
			if (task.time <= time) {
				if (freqMap.get(task.task) != 1) {
					// next available time
					queue.add(new Data(task.task, task.time + n + 1));
					// update next time for task
					freqMap.put(task.task, freqMap.get(task.task) - 1);
				}
				queue.poll();

			}
			time++;
		}
		return time;
	}

	private static class Data implements Comparable<Data> {
		int time;
		char task;

		Data(char task, int time) {
			this.time = time;
			this.task = task;
		}

		public String toString() {
			return "[time=" + time + " task=" + task + "]";
		}

		@Override
		public int compareTo(Data o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) {
		char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
		int n = 2;
		System.out.println(leastInterval(tasks, n));
	}
}
