package leetcode;

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
public class IntegertoEnglishWords2 {
	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		String[] big = { "", "Thousand", "Million", "Billion" };
		String[] small = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
				"Eighteen", "Nineteen" };
		String[] tens = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
		StringBuilder res = new StringBuilder();
		int count = 0;
		while (num != 0) {
			int cur = num % 1000;
			int o = cur % 10, t = (cur / 10) % 10, h = cur / 100; // 直接获得个十百位
			StringBuilder tmp = new StringBuilder();
			if (h != 0)
				tmp.append(ones[h] + " Hundred ");
			if (t == 1)
				tmp.append(small[o] + " ");
			else {
				if (t > 1)
					tmp.append(tens[t - 2] + " ");
				if (o > 0)
					tmp.append(ones[o] + " ");
			}
			if (tmp.length() != 0)
				tmp.append(big[count] + " ");
			res.insert(0, tmp);
			num /= 1000;
			count++;
		}
		return res.toString().trim();
	}
}
