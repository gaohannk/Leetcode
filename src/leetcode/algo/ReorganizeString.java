package leetcode.algo;

import java.util.*;
// TODO verify
public class ReorganizeString {
    static class Pair implements Comparable<Pair> {
        int count;
        char c;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            return this.count - o.count;
        }
    }

    public static String reorganizeString(String S) {

        Queue<Pair> queue = new PriorityQueue<Pair>(Comparator.reverseOrder());
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }
        System.out.println(S.length());
        System.out.println(map);
        for (char c : map.keySet()) {
            queue.add(new Pair(c, map.get(c)));
        }
        StringBuilder res = new StringBuilder();
        Pair p = queue.poll();
        while (!queue.isEmpty()) {
            Pair next = queue.poll();
            while (p.count > 0 && next.count > 0) {
                res.append(p.c);
                p.count--;
                if (p.count == 0) {
                    break;
                }
                res.append(next.c);
                next.count--;
            }
            if (p.count == 0 && next.count != 0) {
                p = next;
            }
            if (p.count == 1) {
                res.append(p.c);
                p.count--;
            }
        }
        if (p.count == 1) {
            res.append(p.c);
            p.count--;
        }
        System.out.println(p.count);
        System.out.println(res.toString());
        return res.toString();
    }

    public static void main(String[] args) {
        String S = "tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupnukayjghpusewdwrbkhvjnveuiionefmnfxao";
        String expected = "eweweweweweweweweweweweweweueueueueueueueueueueueueueueuhuhuhuhuhuhshshshshshshshshshshshshshshshshshshshphphphpcpcpcpcpcpcpcpcpcpcpcpcpcpcpcrcrcrcrcrcrcrcrcrcrcrcrmrmrmrmrmrmrmxmxmxmxmxmxmxmxmxmxmxmxmxmxmxmxmxmxmgmgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvovovovovovovovovonononononononononbnbnbnbnbnbnbnbnbnbnbnbnbnbnbabaiaiaiaiaiaiaiaiaiaiaiaiaiaiaiaiatatatatatftftftftftftftftftftftfdfdfdfdfdfdfdfdfdfdfdydydydydyzyzyzyzyzyzyzyzyzyzyzyzyzyzyjyjyjyjkjkjkjkjkjkjkjklklklklklklklklklklklkqkqkqwqwqwqwqwqwqwqwq\"";
        String out = reorganizeString(S);
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < out.length(); i++) {
            map.put(out.charAt(i), map.getOrDefault(out.charAt(i), 0) + 1);
        }
        System.out.println(out.length());
        System.out.println(map);
    }
}
