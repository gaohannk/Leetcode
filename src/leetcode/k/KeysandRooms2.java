package leetcode.k;

import java.util.List;
import java.util.Stack;

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
public class KeysandRooms2 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit = new boolean[rooms.size()];
        visit[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        //At the beginning, we have a todo list "stack" of keys to use.
        //'visit' represents at some point we have entered this room.
        while (!stack.isEmpty()) {
            int nextKey = stack.pop(); // Get the next key
            for (int key : rooms.get(nextKey)) // For every key in room # 'nextKey'...
                if (!visit[key]) { // ...that hasn't been used yet
                    visit[key] = true; // mark that we've entered the room
                    stack.push(key); // add the key to the todo list
                }
        }

        for (boolean v : visit) {  // if any room hasn't been visited, return false
            if (!v) {
                return false;
            }
        }

        return true;
    }
}
