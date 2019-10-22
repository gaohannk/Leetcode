package leetcode.algo.k;

import java.util.Arrays;
import java.util.List;

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
 */
//DFS
public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visit = new int[rooms.size()];
        visit[0] = 1;
        for (int i = 0; i < rooms.get(0).size(); i++) {
            canVisitAllRoomsHelper(rooms, rooms.get(0).get(i), visit);
        }

        return !Arrays.stream(visit).anyMatch(v -> v == 0);
    }

    private void canVisitAllRoomsHelper(List<List<Integer>> rooms, int curRoom, int[] visit) {
        if (visit[curRoom] == 1)
            return;
        visit[curRoom] = 1;
        for (int i = 0; i < rooms.get(curRoom).size(); i++) {
            canVisitAllRoomsHelper(rooms, rooms.get(curRoom).get(i), visit);
        }
    }
}
