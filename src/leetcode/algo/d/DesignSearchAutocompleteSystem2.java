package leetcode.algo.d;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// Trie
public class DesignSearchAutocompleteSystem2 {

    class Node {
        String sentence;
        int times;

        Node(String st, int t) {
            sentence = st;
            times = t;
        }
    }

    class AutocompleteSystem {

        private HashMap<String, Integer> map = new HashMap<>();
        private String cur_sent = "";

        public AutocompleteSystem(String[] sentences, int[] times) {
            for (int i = 0; i < sentences.length; i++) {
                map.put(sentences[i], times[i]);
            }
        }

        public List<String> input(char c) {
            List<String> res = new LinkedList<>();
            if (c == '#') {
                map.put(cur_sent, map.getOrDefault(cur_sent, 0) + 1);
                cur_sent = "";
            } else {
                List<Node> list = new LinkedList<>();
                cur_sent += c;
                for (String key : map.keySet()) {
                    if (key.indexOf(cur_sent) == 0) {
                        list.add(new Node(key, map.get(key)));
                    }
                }
                Collections.sort(list, (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
                int end = Math.min(3, list.size());
                for (int i = 0; i < end; i++) {
                    res.add(list.get(i).sentence);
                }
            }
            return res;
        }
    }
}
