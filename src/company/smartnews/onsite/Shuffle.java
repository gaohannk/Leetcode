package company.smartnews.onsite;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Shuffle {
    static Random rand = new Random();

    //Fisher–Yates Shuffle
    public static List<Integer> FisherYates(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int i = nums.length;
        while (i > 0) {
            int id = rand.nextInt(i);
            res.add(nums[id]);
            for (int k = id; k < nums.length - 1; k++) {
                nums[k] = nums[k + 1];
            }
            i--;
        }
        return res;
    }

    // In place: Knuth Durstenfeld
    public static List<Integer> Knuth(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            int id = rand.nextInt(i + 1);
            Collections.swap(list, id, i);
        }
        return list;
    }

    // Insider-Out
    public static List<Integer> InsideOut(List<Integer> list) {
        List<Integer> res = new LinkedList<>();
        Collections.copy(list, res);
        for (int i = 1; i < list.size(); i++) {
            int j = rand.nextInt(i + 1);
            if (j != i) {
                res.set(i, list.get(j));
            }
            res.set(j, list.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);
        int[] num = {1, 2, 3, 4};
        System.out.println(FisherYates(num));
    }
}
