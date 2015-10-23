package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		LinkedList<String> result = new LinkedList<String>();
		HashSet<Long> hash = new HashSet<Long>();
		HashSet<Long> usedhash = new HashSet<Long>();

		if (s.length() < 10)
			return result;
		for (int i = 0; i <= s.length() - 10; i++) {
			long value = findHashNumber(s.substring(i, i + 10));
			if (usedhash.contains(value))
				continue;
			if (hash.contains(value)) {
				usedhash.add(value);
				result.add(s.substring(i, i + 10));
			} else {
				hash.add(value);
			}
		}
		return result;
	}

	public long findHashNumber(String s) {
		long res = s.charAt(0);
		long p = 5;
		for (int i = 1; i < s.length(); i++) {
			res += s.charAt(i) * p;
			p *= 5;
		}
		return res;
	}
}
