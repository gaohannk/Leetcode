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
public class SuperPow2 {
	public static int superPow(int a, int[] b) {
		long e = b[0];
		StringBuilder sb = new StringBuilder();
		for (int d : b)
			sb.append(d);
		int res = 1;
		while (e > 0) {
			if (e % 2 == 1) {
				res = (res * a) % 1337;
			}
			e = e >> 1;
			a = a * a % 1337;
		}
		return res;
	}

	public static void main(String[] args) {
		int a = 2147483647;
		int b[] = { 2, 0, 0 };
		System.out.println(superPow(a, b));
	}
}
