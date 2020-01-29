package leetcode.algo.f;

import java.util.Arrays;
import java.util.Iterator;

public class Flatten2DVector {
    class Vector2D {

        Iterator<Integer> iter;

        public Vector2D(int[][] v) {
            iter = Arrays.asList(v)
                    .stream()
                    .flatMapToInt(i -> Arrays.stream(i))
                    .iterator();
        }

        public int next() {
            return iter.next();
        }

        public boolean hasNext() {
            return iter.hasNext();
        }
    }
}
