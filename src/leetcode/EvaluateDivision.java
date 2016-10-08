package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/*Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
*/
public class EvaluateDivision {
	public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		double res[] = new double[queries.length];
//		LinkedList<HashMap<String, Double>> list = new LinkedList<HashMap<String, Double>>();
//		Stack<String> stack = new Stack<>();
//		int count=0;
//		for (int j = 0; j < equations.length; j++) {
//			if (!list.get(count).containsKey(equations[j][0]) && !list.get(count).containsKey(equations[j][1])) {
//				HashMap<String, Double> map = new HashMap<>();
//				map.put(equations[j][0], 1.0);
//				map.put(equations[j][1], 1.0 / values[j]);
//				list.add(map);
//				stack.push(equations[j][0]);
//				stack.push(equations[j][1]);
//			}
//			while (!stack.isEmpty()) {
//				String s = stack.pop();
//				for (int i = 0; i < equations.length; i++) {
//					if (equations[i][0].equals(s) && !map.containsKey(equations[i][1])) {
//						map.put(equations[i][1], map.get(equations[i][0]) / values[i]);
//						stack.push(equations[i][1]);
//					}
//					if (equations[i][1].equals(s) && !map.containsKey(equations[i][0])) {
//						map.put(equations[i][0], map.get(equations[i][1]) * values[i]);
//						stack.push(equations[i][0]);
//					}
//				}
//			}
//		}
//
//		for (int i = 0; i < queries.length; i++) {
//			if (!map.containsKey(queries[i][0]) || !map.containsKey(queries[i][1]))
//				res[i] = -1.0;
//			else
//				res[i] = map.get(queries[i][0]) / map.get(queries[i][1]);
//		}
		return res;
	}

	public static void main(String[] args) {
		String[][] equations = { { "a", "b" }, { "b", "c" } };
		double[] values = { 2.0, 3.0 };
		String[][] queries = { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } };
		double[] res = calcEquation(equations, values, queries);
		for (double r : res) {
			System.out.print(r + ",");
		}
	}
}
