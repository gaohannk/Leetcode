package company.smartnews.oa;

import java.util.*;

public class Problem2 {
    public static int minimumDelete(String s) {
        // frequency, count
        Map<Integer, Integer> count = new TreeMap<>(Comparator.reverseOrder());
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                count.put(chars[i], count.getOrDefault(chars[i], 0) + 1);
            }
        }
        int res = 0;
        System.out.println(count);
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.addAll(count.keySet());

        while (!queue.isEmpty()) {
            int freq = queue.poll();
            if (count.get(freq) != 1) {
                res += count.get(freq) - 1;
                if(freq -1 == 0){
                    break;
                }
                count.put(freq - 1, count.getOrDefault(freq - 1, 0) + count.get(freq) - 1);
                if (!queue.isEmpty() && queue.peek() == freq - 1) {
                    continue;
                } else {
                    queue.add(freq - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumDelete("example")); // 655
//        System.out.println(minimumDelete("aaaaabbbbbccccc")); // 555
//        System.out.println(minimumDelete("aaaaaaabbbbbccccc")); // 755
//        System.out.println(minimumDelete("aabbcd")); // 2211
//        System.out.println(minimumDelete("aabbccd")); // 2221
//        System.out.println(minimumDelete("aaaaaa")); //5
//        System.out.println(minimumDelete("aaaaaaddddddbbbbcccc")); //6644
    }
}
