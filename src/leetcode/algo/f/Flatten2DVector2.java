package leetcode.algo.f;

import java.util.Arrays;
import java.util.Iterator;

public class Flatten2DVector2 {
    class Vector2D {

        Integer outer;
        Integer inner;
        int[][] vector;

        public Vector2D(int[][] v) {
            vector = v;
            if (vector.length > 0) {
                outer = 0;
                findNextValidStart();
            }
        }

        public int next() {
            int current = vector[outer][inner];
            inner++;

            if (inner.equals(vector[outer].length)) {
                outer++;
                findNextValidStart();
                if (outer.equals(vector.length)) {
                    inner = null;
                }
            }

            return current;
        }

        private void findNextValidStart() {
            while (outer < vector.length && vector[outer].length == 0) {
                outer++;
            }
            if (!outer.equals(vector.length)) {
                inner = 0;
            }
        }

        public boolean hasNext() {
            if (outer == null || inner == null) {
                return false;
            }
            return inner < vector[outer].length || outer < vector.length;
        }
    }
}
