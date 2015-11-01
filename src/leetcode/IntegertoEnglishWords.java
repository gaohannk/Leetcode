package leetcode;

import java.util.HashMap;

/* Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Hint:
 * Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
 * Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
 * There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? (middle chunk is zero and should not be printed out)
 */
/* Note: 1 Zero
 *       2 Space 
 */
public class IntegertoEnglishWords {
	public static String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		StringBuilder res = new StringBuilder();
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		setup(map);

		int index = 0;
		while (num > 0) {
			int residue = num % 1000;
			num /= 1000;
			String part = handle(residue, map, index);
			res.insert(0, part);
			index++;
		}
		return res.toString().trim(); // 去掉最后面空格
	}

	private static String handle(int residue, HashMap<Integer, String> map, int index) {
		StringBuilder res = new StringBuilder();
		String word[] = { "", "Thousand", "Million", "Billion" };
		if (residue == 0) {
			return res.toString();
		}
		int n = residue / 100;
		residue = residue - 100 * n;
		switch (n) {
		case 0:
			break;
		default:
			res.append(map.get(n) + " Hundred");
			break;
		}
		if (n != 0 && residue != 0)
			res.append(" "); // 此空格连接百位和十位，百位有值且个位或十位有值才加空格，
		if (residue <= 20) {
			res.append(map.get(residue));
		} else {
			res.append(map.get(residue - residue % 10));
			n = residue / 10;
			residue = residue - n * 10;
			if (residue != 0)
				res.append(" " + map.get(residue)); // "Twenty Two" The space
													// between word
		}
		res.append(" " + word[index] + " "); // 空格加在word两边
		return res.toString();
	}

	private static void setup(HashMap<Integer, String> map) {
		map.put(0, "");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		map.put(10, "Ten");
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Fifteen");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Nineteen");
		map.put(20, "Twenty");
		map.put(30, "Thirty");
		map.put(40, "Forty");
		map.put(50, "Fifty");
		map.put(60, "Sixty");
		map.put(70, "Seventy");
		map.put(80, "Eighty");
		map.put(90, "Ninety");
	}

	public static void main(String[] args) {
		System.out.println(numberToWords(123));
	}
}