package leetcode;

import java.util.ArrayList;

/* Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
/* Basic idea: For each number in the array, swap it with every element after it. 
 * To avoid duplicate, need to check it first.
 */
public class PermutationsII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permuteUnique(num, 0, result);
		return result;
	}

	private void permuteUnique(int[] num, int start,
			ArrayList<ArrayList<Integer>> result) {

		if (start >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		}

		for (int j = start; j <= num.length - 1; j++) {
			if (containsDuplicate(num, start, j)) {
				swap(num, start, j);
				permuteUnique(num, start + 1, result);
				swap(num, start, j);
			}
		}
	}

	private ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++)
			item.add(num[h]);
		return item;
	}
	private boolean containsDuplicate(int[] arr, int start, int end) {
		for (int i = start; i <= end - 1; i++) {
			if (arr[i] == arr[end])
				return false;
		}
		return true;
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
