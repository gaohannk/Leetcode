package leetcode.algo.a;

import java.util.*;
import java.util.stream.Collectors;

/**
 * We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].
 * <p>
 * A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  (The websites in a 3-sequence are not necessarily distinct.)
 * <p>
 * Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
 * Output: ["home","about","career"]
 * Explanation:
 * The tuples in this example are:
 * ["joe", 1, "home"]
 * ["joe", 2, "about"]
 * ["joe", 3, "career"]
 * ["james", 4, "home"]
 * ["james", 5, "cart"]
 * ["james", 6, "maps"]
 * ["james", 7, "home"]
 * ["mary", 8, "home"]
 * ["mary", 9, "about"]
 * ["mary", 10, "career"]
 * The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
 * The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
 * The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
 * The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
 * The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
 * <p>
 * <p>
 * Note:
 * <p>
 * 3 <= N = username.length = timestamp.length = website.length <= 50
 * 1 <= username[i].length <= 10
 * 0 <= timestamp[i] <= 10^9
 * 1 <= website[i].length <= 10
 * Both username[i] and website[i] contain only lowercase characters.
 * It is guaranteed that there is at least one user who visited at least 3 websites.
 * No user visits two websites at the same time.
 */
public class AnalyzeUserWebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        TreeMap<Integer, String[]> userAndSite = new TreeMap<>();
        for (int i = 0; i < timestamp.length; ++i) {
            // sort the user names and corresponding websites by time.
            userAndSite.put(timestamp[i], new String[]{username[i], website[i]});
        }

        Map<String, List<String>> sites = new HashMap<>();
        for (String[] sa : userAndSite.values()) {
            // user and his websites.
            sites.computeIfAbsent(sa[0], l -> new ArrayList<>()).add(sa[1]);
        }

        Map<String, Integer> count = new HashMap<>(); // number of visited users for each 3-sequence.
        int max = 0;
        String ans = "";
        for (String user : sites.keySet()) { // for each user, create all tuples and add to a HashSet to prune duplications.
            Set<String> seq = new HashSet<>();
            List<String> l = sites.get(user);
            int sz = l.size();
            for (int i = 0; i < sz; ++i) {// build up tuples.
                for (int j = i + 1; j < sz; ++j) {
                    for (int k = j + 1; k < sz; ++k) {
                        seq.add(l.get(i) + '#' + l.get(j) + '#' + l.get(k));
                    }
                }
            }
            for (String s : seq) {
                count.put(s, count.getOrDefault(s, 0) + 1); // count the number of users visiting a specific 3-sequence.
                if (max < count.get(s) || max == count.get(s) && ans.compareTo(s) > 0) {
                    max = count.get(s);
                    ans = s;
                }
            }
        }
        return Arrays.stream(ans.split("#")).collect(Collectors.toList());
    }
}
