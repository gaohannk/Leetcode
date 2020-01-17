package company.flexe.onsite;

import java.util.LinkedList;
import java.util.List;

public class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> res = new LinkedList<>();
        boolean isBlock = false;
        StringBuilder sb = new StringBuilder();
        for (String line : source) {
            int i = 0;
            if (!isBlock) {
                sb = new StringBuilder();
            }
            while (i < line.length()) {
                if (!isBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                    isBlock = true;
                    i++;
                } else if (!isBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    break;
                } else if (isBlock && i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                    isBlock = false;
                    i++;
                } else if (!isBlock) {
                    sb.append(line.charAt(i));
                }
                i++;
            }
            if (!isBlock && sb.length() != 0) {
                res.add(sb.toString());
            }
        }
        return res;
    }
}
