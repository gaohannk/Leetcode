package leetcode;

import java.util.HashMap;

/* Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
It is possible that several messages arrive roughly at the same time.
Example:
Logger logger = new Logger();
// logging string "foo" at timestamp 1
logger.shouldPrintMessage(1, "foo"); returns true; 

// logging string "bar" at timestamp 2
logger.shouldPrintMessage(2,"bar"); returns true;

// logging string "foo" at timestamp 3
logger.shouldPrintMessage(3,"foo"); returns false;

// logging string "bar" at timestamp 8
logger.shouldPrintMessage(8,"bar"); returns false;

// logging string "foo" at timestamp 10
logger.shouldPrintMessage(10,"foo"); returns false;

// logging string "foo" at timestamp 11
logger.shouldPrintMessage(11,"foo"); returns true;
这道题让我们设计一个记录系统每次接受信息并保存时间戳，然后让我们打印出该消息，前提是最近10秒内没有打印出这个消息。
这不是一道难题，我们可以用哈希表来做，建立消息和时间戳之间的映射，如果某个消息不再哈希表表，我们建立其和时间戳的映射，并返回true。
如果应经在哈希表里了，我们看当前时间戳是否比哈希表中保存的时间戳大10，如果是，更新哈希表，并返回true，反之返回false
*/
public class LoggerRateLimiter {
	class Logger {
		HashMap<String, Integer> log = new HashMap<>();

		public boolean shouldPrintMessage(int timestamp, String message) {
			if (!log.containsKey(message)) {
				log.put(message, timestamp);
				return true;
			}
			if (timestamp - log.get(message) >= 10) {
				log.put(message, timestamp);
				return true;
			}
			return false;
		}
	}
}
