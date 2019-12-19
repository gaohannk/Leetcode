package leetcode.algo.r;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class RemoveSubFoldersfromtheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new LinkedList<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.naturalOrder());
        for(String path: folder){
            pq.add(path);
        }
        while(!pq.isEmpty()) {
            String cur = pq.poll();
            res.add(cur);
            while (!pq.isEmpty()) {
                String candidate = pq.peek();
                if (candidate.length() > cur.length()
                        && candidate.substring(0, cur.length()).equals(cur)
                        && candidate.charAt(cur.length()) == '/') {
                    pq.remove();
                }else{
                    break;
                }
            }
        }
        return res;
    }

}
