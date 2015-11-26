package leetcode;

/* There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i 
 * to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 */
//TLE
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas==null||gas.length<=1)
			return 0;
		for (int i = 0; i < gas.length; i++) {
			int start = i;
			int end=i-1;
			if(i==0)
				end=gas.length-1;
			int totalgas = 0;
			int totalcost = 0;
			while (start != end) {
				totalgas += gas[start];
				totalcost += cost[start];
				if (totalgas < totalcost)
					break;
				start = (start + 1) % gas.length;
			}
			if (start == end)
				return i;
		}
		return -1;
	}
}
