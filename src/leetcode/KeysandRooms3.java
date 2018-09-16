package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 * <p>
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * <p>
 * Initially, all the rooms start locked (except for room 0).
 * <p>
 * You can walk back and forth between rooms freely.
 * <p>
 * Return true if and only if you can enter every room.
 **/
//BFS
public class KeysandRooms3 {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> roomToVisit = new LinkedList<Integer>();
        boolean[] visited = new boolean[rooms.size()];
        int numVisited = 0;
        roomToVisit.offer(0);
        visited[0] = true;
        while (!roomToVisit.isEmpty()) {
            int cur = roomToVisit.poll();
            numVisited++;
            for (int i = 0; i < rooms.get(cur).size(); i++) {
                int nextRoom = rooms.get(cur).get(i);
                if (!visited[nextRoom]) {
                    roomToVisit.offer(nextRoom);
                    visited[nextRoom] = true;
                }
            }
        }
        return numVisited == rooms.size();
    }
}
