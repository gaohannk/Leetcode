package leetcode;

public class HIndexII2 {
	public static int hIndex(int[] citations) {
		if (citations.length == 0)
			return 0;
		if (citations.length == 1)
			return citations[0] >= 1 ? 1 : 0;
		int start = 0;
		int end = citations.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (citations[mid] < citations.length - mid) {
				if (mid + 1 < citations.length && citations[mid + 1] >= citations.length - mid - 1)
					return citations.length - mid - 1;
				else
					start = mid + 1;
			} else if (citations[mid] > citations.length - mid) {
				if (mid - 1 >= 0 && citations[mid - 1] < citations.length - mid + 1)
					return citations.length - mid;
				else
					end = mid - 1;
			} else {
				return citations.length - mid;
			}
		}
		if (start == citations.length - 1)
			return 0;
		return citations.length - start;
	}
}
