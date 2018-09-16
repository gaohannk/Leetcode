package leetcode;

/**
 * There are two types of soup: type A and type B. Initially we have N ml of each type of soup. There are four kinds of operations:
 * <p>
 * Serve 100 ml of soup A and 0 ml of soup B
 * Serve 75 ml of soup A and 25 ml of soup B
 * Serve 50 ml of soup A and 50 ml of soup B
 * Serve 25 ml of soup A and 75 ml of soup B
 * When we serve some soup, we give it to someone and we no longer have it.  Each turn, we will choose from the four operations with equal probability 0.25. If the remaining volume of soup is not enough to complete the operation, we will serve as much as we can.  We stop once we no longer have some quantity of both types of soup.
 * <p>
 * Note that we do not have the operation where all 100 ml's of soup B are used first.
 * <p>
 * Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time.
 * <p>
 * <p>
 * <p>
 * Example:
 * Input: N = 50
 * Output: 0.625
 * Explanation:
 * If we choose the first two operations, A will become empty first. For the third operation, A and B will become
 * empty at the same time. For the fourth operation, B will become empty first.
 * So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.
 */
public class SoupServings {
    public static double soupServings(int N) {
        // Memory Limit
        if (N > 4800)
            return 1;
        int serv = (N + 24) / 25;
        double prob[][] = new double[serv + 1][serv + 1];
        return getProbablity(serv, serv, prob);
    }

    private static double getProbablity(int a, int b, double[][] prob) {
        if (a <= 0 && b <= 0)
            return 0.5;
        if (a <= 0 && b > 0)
            return 1;
        if (a > 0 && b <= 0)
            return 0;
        if (prob[a][b] == 0) {
            prob[a][b] = 0.25 * (getProbablity(a - 4, b, prob) +
                    getProbablity(a - 3, b - 1, prob) +
                    getProbablity(a - 2, b - 2, prob) +
                    getProbablity(a - 1, b - 3, prob));
        }
        return prob[a][b];
    }

    public static double soupServings2(int N) {
        // Memory Limit
        if (N > 4800)
            return 1;
        double prob[][] = new double[N + 1][N + 1];
        return getProbablity2(N, N, prob);
    }

    private static double getProbablity2(int a, int b, double[][] prob) {
        if (a <= 0 && b <= 0)
            return 0.5;
        if (a <= 0 && b > 0)
            return 1;
        if (a > 0 && b <= 0)
            return 0;
        if (prob[a][b] == 0) {
            prob[a][b] = 0.25 * (getProbablity2(a - 100, b, prob) +
                    getProbablity2(a - 75, b - 25, prob) +
                    getProbablity2(a - 50, b - 50, prob) +
                    getProbablity2(a - 25, b - 75, prob));
        }
        return prob[a][b];
    }


    public static void main(String[] args) {
        System.out.println(soupServings(100));
        System.out.println(soupServings2(100));
    }
}
