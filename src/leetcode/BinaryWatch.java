package leetcode;

import java.util.LinkedList;
import java.util.List;

/*A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
*/
public class BinaryWatch {
	public static List<String> readBinaryWatch(int num) {
		List<String> res = new LinkedList<String>();

		int hour[] = { 1, 2, 4, 8 };
		int minute[] = { 1, 2, 4, 8, 16, 32 };
		for (int i = 0; i <= 4; i++) {
			List<String> hours = new LinkedList<String>();
			List<String> minutes = new LinkedList<String>();
			getCombination(hour, 0, i, 0, hours, true);
			if (num - i > 6)
				continue;
			getCombination(minute, 0, num - i, 0, minutes, false);
			getTime(hours, minutes, res);
		}
		return res;
	}

	private static void getTime(List<String> hours, List<String> minutes, List<String> res) {
		for (String h : hours) {
			for (String m : minutes) {
				res.add(h + ":" + m);
			}
		}
	}

	private static void getCombination(int values[], int start, int num, int sum, List<String> hours, boolean flag) {
		if (num == 0) {
			if (!(flag && sum > 11 || (!flag && sum > 59))) {
				String str = getStringFormat(sum, flag);
				hours.add(str);
			}
			return;
		}
		for (int i = start; i < values.length; i++) {
			sum += values[i];
			getCombination(values, i + 1, num - 1, sum, hours, flag);
			sum -= values[i];
		}
	}

	private static String getStringFormat(int sum, boolean flag) {
		if (flag) {
			return String.valueOf(sum);
		} else {
			return sum < 10 ? "0" + String.valueOf(sum) : String.valueOf(sum);
		}
	}

	public static void main(String[] args) {
		readBinaryWatch(2);
	}
}
