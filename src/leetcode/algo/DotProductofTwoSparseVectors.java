package leetcode.algo;

import java.util.HashMap;
import java.util.Map;

public class DotProductofTwoSparseVectors {
    class SparseVector {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int n = 0;

        SparseVector(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    indexMap.put(i, nums[i]);
                }
            }
            n = nums.length;
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            if (indexMap.size() == 0 || vec.indexMap.size() == 0) {
                return 0;
            }
            if (indexMap.size() > vec.indexMap.size()) {
                return vec.dotProduct(this);
            }
            int productSum = 0;
            for (int key : indexMap.keySet()) {
                Integer vecValue = vec.indexMap.get(key);
                if (vecValue == null) {
                    continue;
                }
                productSum += key * vecValue;
            }
            return productSum;
        }
    }
}
