package company.amazon.oa;

import java.util.*;

/**
 * You work on a team whose job is to understand the most sought after toys for the holiday season. A teammate of yours has built a webcrawler that extracts a list of quotes about toys from different articles. You need to take these quotes and identify which toys are mentioned most frequently. Write an algorithm that identifies the top N toys out of a list of quotes and list of toys.
 *
 * Your algorithm should output the top N toys mentioned most frequently in the quotes.
 *
 * Input:
 * The input to the function/method consists of five arguments:
 *
 * numToys, an integer representing the number of toys
 * topToys, an integer representing the number of top toys your algorithm needs to return;
 * toys, a list of strings representing the toys,
 * numQuotes, an integer representing the number of quotes about toys;
 * quotes, a list of strings that consists of space-sperated words representing articles about toys
 *
 * Output:
 * Return a list of strings of the most popular N toys in order of most to least frequently mentioned
 *
 * Note:
 * The comparison of strings is case-insensitive. If the value of topToys is more than the number of toys, return the names of only the toys mentioned in the quotes. If toys are mentioned an equal number of times in quotes, sort alphabetically.
 *
 * Example 1:
 *
 * Input:
 * numToys = 6
 * topToys = 2
 * toys = ["elmo", "elsa", "legos", "drone", "tablet", "warcraft"]
 * numQuotes = 6
 * quotes = [
 * "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
 * "The new Elmo dolls are super high quality",
 * "Expect the Elsa dolls to be very popular this year, Elsa!",
 * "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
 * "For parents of older kids, look into buying them a drone",
 * "Warcraft is slowly rising in popularity ahead of the holiday season"
 * ];
 *
 * Output:
 * ["elmo", "elsa"]
 *
 * Explanation:
 * elmo - 4
 * elsa - 4
 * "elmo" should be placed before "elsa" in the result because "elmo" appears in 3 different quotes and "elsa" appears in 2 different quotes.
 */
public class TopNBuzzwords {
    static class Pair {
        int totalAppear; // total times appear in all quotes
        int appearInQuotes; // number of quotes has this word

        public Pair(int totalAppear, int appearInQuotes) {
            this.totalAppear = totalAppear;
            this.appearInQuotes = appearInQuotes;
        }
    }

    public static List<String> topToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
        Map<String, Pair> freqMap = new HashMap<>();
        Set<String> toysSet = new HashSet<>();
        for (int i = 0; i < numToys; i++) {
            toysSet.add(toys[i]);
            freqMap.put(toys[i], new Pair(0, 0));
        }

        for (String quote : quotes) {
            Set<String> used = new HashSet<>();
            String[] words = quote.toLowerCase().split("\\W+");

            for (String word : words) {
                if (!toysSet.contains(word)) {
                    continue;
                }

                Pair stat = freqMap.get(word);
                stat.totalAppear++;
                if (!used.contains(word)) {
                    stat.appearInQuotes++;
                }
                used.add(word);
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>((t1, t2) -> {
            if (freqMap.get(t1).totalAppear != freqMap.get(t2).totalAppear) {
                return freqMap.get(t1).totalAppear - freqMap.get(t2).totalAppear;
            }

            if (freqMap.get(t1).appearInQuotes != freqMap.get(t2).appearInQuotes) {
                return freqMap.get(t1).appearInQuotes - freqMap.get(t2).appearInQuotes;
            }

            return t2.compareTo(t1);
        });

        if (topToys > numToys) {
            for (String toy : freqMap.keySet()) {
                if (freqMap.get(toy).totalAppear > 0) {
                    pq.add(toy);
                }
            }
        } else {
            for (String toy : toys) {
                pq.add(toy);
                if (pq.size() > topToys) {
                    pq.poll();
                }
            }
        }

        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        String[] toys = new String[]{"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        String[] quotas = new String[]{
                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"
        };
        System.out.println(topToys(6, 2, toys, 6, quotas));
    }
}
