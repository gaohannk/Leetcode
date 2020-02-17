package company.amazon.oa;

import java.util.LinkedList;
import java.util.List;

public class SearchSuggestionsSystem {
    static class Trie {
        char c;
        Trie[] child = new Trie[26];
        boolean isWord;

        public Trie(char c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        System.out.println(suggestedProducts(products, "moute"));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie('#');
        for (String p : products) {
            char[] chars = p.toCharArray();
            insert(root, chars);
        }
        List<List<String>> res = new LinkedList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(searchWord.substring(0, i + 1));
            List<String> suggest = new LinkedList<>();
            Trie iterRoot = root;
            for (int j = 0; j < sb.length(); j++) {
                if (iterRoot == null) {
                    break;
                } else {
                    iterRoot = iterRoot.child[sb.charAt(j) - 'a'];
                }
            }
            dfs(sb, 3, suggest, iterRoot);
            res.add(suggest);
        }
        return res;
    }

    private static void dfs(StringBuilder sb, int limit, List<String> suggest, Trie root) {
        if (root == null) {
            return;
        }
        // Reach limit
        if (suggest.size() == limit) {
            return;
        }
        if (root.isWord) {
            suggest.add(sb.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) {
                sb.append(root.child[i].c);
                dfs(sb, limit, suggest, root.child[i]);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private static void insert(Trie root, char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (root.child[chars[i] - 'a'] == null) {
                root.child[chars[i] - 'a'] = new Trie(chars[i]);
            }
            root = root.child[chars[i] - 'a'];
            if (i == chars.length - 1) {
                root.isWord = true;
            }
        }
    }
}
