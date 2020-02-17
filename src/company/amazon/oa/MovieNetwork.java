package company.amazon.oa;

import java.util.*;

/**
 * movie network假设有个Movie类，
 * public class Movie
 * {
 * int movieId;.
 * float rating;
 * List<Movie> similarMovies
 * }
 *
 * 第二题是给一个 movie，每个 movie 有 id，rating 和一个 list of neighbors，
 * 让你从这个 movie 开始，找到 similar 的 top k rating movie，不包括这个 movie。
 * 用 bfs 遍历这个图，然后再用一个 minHeap，每次分两种情况，如果 minHeap.size()== k，
 * 那就看是不是比 peek 的 rating 大，如果大就扔出来一个把这个新的放进去。如果 minHeap.size() < k
 * ，就放进去。最后结果就在 minHeap 里面。
 */
public class MovieNetwork {
    public class Movie {
        int movieId;
        float rating;
        List<Movie> similarMovies;
    }

    public List<Integer> solution(Movie movie, int numSimilar) {
        PriorityQueue<Movie> pq = new PriorityQueue<>((o1, o2) -> Float.compare(o1.rating, o2.rating));
        Queue<Movie> queue = new LinkedList<>();
        queue.offer(movie);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Queue<Movie> nextLayer = new LinkedList<>();
            while (!queue.isEmpty()) {
                Movie cur = queue.poll();
                visited.add(cur.movieId);
                if (cur != movie) { // source movie can't be add to pq
                    if (pq.size() >= numSimilar) {
                        if (pq.peek().rating < cur.rating) {
                            pq.poll();
                            pq.offer(cur);
                        }
                    } else {
                        pq.offer(cur);
                    }
                }

                for (Movie nei : movie.similarMovies) {
                    if (!visited.contains(nei.movieId)) {
                        nextLayer.add(nei);
                    }
                }
            }
            queue = nextLayer;
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().movieId);
        }
        return res;
    }
}
