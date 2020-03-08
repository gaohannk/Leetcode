package leetcode.algo.m;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyCalendarII {
    static class MyCalendarTwo {
        List<Integer> startTime;
        List<Integer> endTime;

        public MyCalendarTwo() {
            this.startTime = new ArrayList<>();
            this.endTime = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            int count = 0;
            int pointer = 0;
            Collections.sort(startTime);
            Collections.sort(endTime);
            System.out.println(startTime);
            System.out.println(endTime);

            List<int[]> maxBook = new ArrayList<>();
            int prev = 0;
            for (int i = 0; i < startTime.size() && pointer < endTime.size(); ) {
                if (this.startTime.get(i) >= this.endTime.get(pointer)) {
                    prev = endTime.get(pointer);
                    count--;
                    pointer++;
                } else {
                    prev = startTime.get(i);
                    count++;
                    i++;
                }
                if (i < startTime.size() && prev != Math.min(startTime.get(i), endTime.get(pointer)))
                    maxBook.add(new int[]{prev, Math.min(startTime.get(i), endTime.get(pointer)), count});
            }
            pointer++;
            while (pointer < endTime.size()) {
                maxBook.add(new int[]{prev, Math.min(startTime.get(startTime.size()-1), endTime.get(pointer)), count});
                prev = endTime.get(pointer);
                pointer++;
            }
            for (int[] book : maxBook) {
                System.out.println("[" + book[0] + "," + book[1] + "," + book[2] + "]");
            }
            System.out.println();
            for (int i = 0; i < maxBook.size(); i++) {
                if (maxBook.get(i)[2] >= 2 && (start < maxBook.get(i)[1] && end > maxBook.get(i)[0])) {
                    System.out.println("here");
                    return false;
                }
            }
            startTime.add(start);
            endTime.add(end);
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendarTwo calendarTwo = new MyCalendarTwo();
        System.out.println(calendarTwo.book(10, 20));
        System.out.println(calendarTwo.book(50, 60));
        System.out.println(calendarTwo.book(10, 40));
        System.out.println(calendarTwo.book(5, 15));
        System.out.println(calendarTwo.book(5, 10));
        System.out.println(calendarTwo.book(25, 55));

    }
}
