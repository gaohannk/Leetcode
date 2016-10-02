package leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 * Example1:

a = 2
b = [3]

Result: 8
Example2:

a = 2
b = [1,0]

Result: 1024
 */
public class SuperPow {
	public static int superPow(int a, int[] b) {
		// Build the list of possible mod values
		// list(i - 1) = a^i mod 1337
		long mod = (long) a;
		final long div = 1337L;
		final List<Integer> list = new ArrayList<>();
		final Set<Integer> used = new HashSet<>();
		int key;
		while (true) {
			mod %= div;
			key = (int) mod;
			// Is the list starting to repeat?
			if (used.contains(key))
				break;
			list.add(key);
			used.add(key);
			mod *= a;
		}
		// Find the actual mod value from the list
		// BigInteger was used below to simplify (b mod list_size)
		// since this problem wasn't about large number division
		StringBuilder sb = new StringBuilder();
		for (int d : b)
			sb.append(d);
		key = new BigInteger(sb.toString()).mod(BigInteger.valueOf(list.size())).intValue();
		if (key == 0)
			key = list.size();
		return list.get(key - 1);
	}

	public static void main(String[] args) {
		int a = 2147483647;
		int b[] = { 2, 0, 0 };
		System.out.println(superPow(a, b));
	}
}
