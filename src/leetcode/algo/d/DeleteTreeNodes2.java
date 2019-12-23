package leetcode.algo.d;

import java.util.HashSet;
import java.util.Set;

/**
 * From right to left, add all child values back to parent node. After this, value array contains subarray sum for each node.
 * From left to right, count each deleted nodes (either has a sum = 0 or has a deleted ascendant) and use a set to record already deleted parent nodes (sum = 0).
 */
public class DeleteTreeNodes2 {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        for(int i = nodes - 1; i >= 0; i--){
            if(parent[i] == -1){
                continue;
            }
            value[parent[i]] += value[i];
        }
        Set<Integer> zeros = new HashSet<>();
        int cnt = 0; // nodes should remove
        for(int i = 0; i < nodes; i++){
            if(value[i] == 0 || zeros.contains(parent[i])){
                cnt++;
                zeros.add(i);
            }
        }
        return nodes - cnt;
    }
}
