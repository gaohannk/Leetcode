package company.twosigma.oa;

import java.util.LinkedList;
import java.util.List;

public class MissingWords {
    public static List<String> solution(String s, String t) {
        int i = 0, j = 0;
        String[] ss = s.split(" ");
        String[] tt = t.split(" ");
        List<String> res = new LinkedList<>();

        while (i < ss.length && j < tt.length) {
            if (ss[i].equals(tt[j])) {
                i++;
                j++;
            } else {
                res.add(ss[i]);
                i++;
            }
        }
        while (i < ss.length) {
            res.add(ss[i]);
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution("I like eating cheese do you like cheese", "like cheese"));
        System.out.println(solution("I like soft cheese and hard cheese yum", "like cheese yum"));

    }
}
