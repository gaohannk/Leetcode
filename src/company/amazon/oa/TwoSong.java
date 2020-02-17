package company.amazon.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Leetcode two sum return index
public class TwoSong {
    public ArrayList<Integer> IdofTwoSongs(int riderDuration, ArrayList<Integer> songDuration) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < songDuration.size(); i++) {
            Integer index = map.get(riderDuration - 30 - songDuration.get(i));
            if (index != null) {
                res.add(index);
                res.add(i);
                break;
            } else {
                map.put(songDuration.get(i), i);
            }
        }
        return res;
    }
}
