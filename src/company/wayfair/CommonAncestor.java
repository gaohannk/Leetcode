package company.wayfair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*

Suppose we have some input data des‍‍‍‌‍‌‍‍‌‌‍‍‌‌‍‌cribing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 6 and 8 have a common ancestor of 4.

         14  13
         |   |
1   2    4   12
\ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7     11

parentChildPairs1 = [
    (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
    (4, 8), (4, 9), (9, 11), (14, 4), (13, 12), (12, 9)
]

Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.

Sample input and output:

hasCommonAncestor(parentChildPairs1, 3, 8) => false
hasCommonAncestor(parentChildPairs1, 5, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 8) => true
hasCommonAncestor(parentChildPairs1, 6, 9) => true
hasCommonAncestor(parentChildPairs1, 1, 3) => false
hasCommonAncestor(parentChildPairs1, 7, 11) => true
hasCommonAncestor(parentChildPairs1, 6, 5) => true
hasCommonAncestor(parentChildPairs1, 5, 6) => true

Additional example: In this diagram, 4 and 12 have a common ancestor of 11.

        11
       /  \
      10   12
     /  \
1   2    5
\ /    / \
  3    6   7
   \        \
    4        8

parentChildPairs2 = [
    (11, 10), (11, 12), (10, 2), (10, 5), (1, 3),
    (2, 3), (3, 4), (5, 6), (5, 7), (7, 8),
]

hasCommonAncestor(parentChildPairs2, 4, 12) => true
hasCommonAncestor(parentChildPairs2, 1, 6) => false
hasCommonAncestor(parentChildPairs2, 1, 12) => false
*/
public class CommonAncestor {
    public static boolean hasCommonAncestor(int[][] pairs, int a, int b) {
        LinkedList<Integer> curentLevel = new LinkedList<>();
        curentLevel.add(a);
        Set<Integer> ancesSet1 = new HashSet<>();
        helper(pairs, ancesSet1, curentLevel);

        curentLevel = new LinkedList<>();
        curentLevel.add(b);
        Set<Integer> ancesSet2 = new HashSet<>();
        helper(pairs, ancesSet2, curentLevel);

        for (int val : ancesSet1) {
            if (ancesSet2.contains(val)) {
                return true;
            }
        }
        return false;
    }

    private static void helper(int[][] pairs, Set<Integer> ancesSet1, LinkedList<Integer> curentLevel) {
        if (curentLevel == null || curentLevel.size() == 0)
            return;

        HashSet<Integer> next = new HashSet<>();
        for (int val : curentLevel) {
            for (int[] pair : pairs) {
                if (pair[1] == val) {
                    next.add(pair[0]);
                    ancesSet1.add(pair[0]);
                }
            }
        }
        LinkedList<Integer> nextLevel = new LinkedList<>(next);
        // System.out.println(nextLevel);
        helper(pairs, ancesSet1, nextLevel);
    }

    public static void main(String[] args) {
        int[][] parentChildPairs1 = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9}};
        System.out.println(hasCommonAncestor(parentChildPairs1, 5, 8));// true
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 8)); //true
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 9)); // true
        System.out.println(hasCommonAncestor(parentChildPairs1, 1, 3)); // false
        System.out.println(hasCommonAncestor(parentChildPairs1, 7, 11)); //true
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 5)); // true
        System.out.println(hasCommonAncestor(parentChildPairs1, 5, 6));  // true


        int[][] pare‍‍‍‌‍‌‍‍‌‌‍‍‌‌‍‌ntChildPairs2 = {{11, 10}, {11, 12}, {10, 2}, {10, 5}, {1, 3}, {2, 3}, {3, 4}, {5, 6}, {5, 7}, {7, 8}};
        System.out.println(hasCommonAncestor(pare‍‍‍‌‍‌‍‍‌‌‍‍‌‌‍‌ntChildPairs2, 4, 12));// true
        System.out.println(hasCommonAncestor(pare‍‍‍‌‍‌‍‍‌‌‍‍‌‌‍‌ntChildPairs2, 1, 6));// false
        System.out.println(hasCommonAncestor(pare‍‍‍‌‍‌‍‍‌‌‍‍‌‌‍‌ntChildPairs2, 1, 12));// false

    }
}
