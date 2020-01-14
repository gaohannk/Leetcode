package company.oracle.high;

import java.util.*;

/**
 * Think about how we would approach this problem in a very simplistic way. We will allocate rooms to meetings that occur earlier in the day v/s the ones that occur later on, right?
 * If you've figured out that we have to sort the meetings by their start time, the next thing to think about is how do we do the allocation?
 * There are two scenarios possible here for any meeting. Either there is no meeting room available and a new one has to be allocated, or a meeting room has freed up and this meeting can take place there.
 * An important thing to note is that we don't really care which room gets freed up while allocating a room for the current meeting. As long as a room is free, our job is done.
 *
 * We already know the rooms we have allocated till now and we also know when are they due to get free because of the end times of the meetings going on in those rooms. We can simply check the room which is due to get vacated the earliest amongst all the allocated rooms.
 * Following up on the previous hint, we can make use of a min-heap to store the end times of the meetings in various rooms.
 *
 * So, every time we want to check if any room is free or not, simply check the topmost element of the min heap as that would be the room that would get free the earliest out of all the other rooms currently occupied.
 *
 * If the room we extracted from the top of the min heap isn't free, then no other room is. So, we can save time here and simply allocate a new room.
 */
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            queue.offer(intervals[i]);
        }

        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] meeting = intervals[i];
            if (meeting[0] < queue.peek()[1]) {
                count++;
            } else {
                queue.poll();
            }
        }
        return count;
    }
}
