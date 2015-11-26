package leetcode;

/* There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i 
 * to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 */
public class GasStation2 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length == 1)
			return gas[0] - cost[0] < 0 ? -1 : 0;
		int sum = 0;
		int start = 0;
		int total = 0;
		// total and sum is not same total is for the sum for whole array
		for (int i = 0; i < gas.length; i++) {
			int left = gas[i] - cost[i];
			total += left;
			if (sum + left < left) {
				start = i;
				sum = left;
			} else {
				sum += left;
			}
		}
		if (total < 0)
			return -1;
		return start;
	}
}
