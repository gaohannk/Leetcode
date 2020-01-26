package company.verily.phone;

/**
 * Imagine a person travels from city A to city B by train. There are N stations between city A and B. He may get off the train at any of the station, but he would not get off in neighboring stations.   He can not travel backward neither. How many different ways he can travel?
 */
public class TravelWays {
    public int solution(int N) {
        if (N <= 2)
            return 0;
        int[] dp = new int[N];

        for (int i = 5; i <= N; i++) {
            for (int j = 2; j <= i - 2; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[N];
    }
}

