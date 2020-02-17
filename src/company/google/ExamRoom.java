package company.google;

import java.util.TreeSet;

public class ExamRoom {
    int N;
    TreeSet<Integer> treeSet;

    public ExamRoom(int N) {
        this.N = N;
        this.treeSet = new TreeSet<>();
    }

    public int seat() {

        int newSeatId = 0;
        if (treeSet.size() > 0) {
            int prev = -1;
            // We must take one first as it's dist to 0
            int dist = treeSet.first();
            for (int cur : treeSet) {
                if (prev != -1) {
                    //For each pair of adjacent students in positions (prev, s),
                    //d is the distance to the closest student;
                    //achieved at position prev + d.
                    int d = (cur - prev) / 2;
                    if (d > dist) {
                        dist = d;
                        newSeatId = prev + d;
                    }
                }
                prev = cur;

                //Don't forget Considering the right-most seat.
                if (N - 1 - treeSet.last() > dist) {
                    newSeatId = N - 1;
                }
            }
        }

        treeSet.add(newSeatId);
        return newSeatId;
    }

    public void leave(int p) {
        treeSet.remove(p);
    }
}
