package leetcode;

import java.util.HashMap;

public class FruitIntoBaskets {
    public static int totalFruit(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int count = 0;
        int first = 0, second =0;
        for (int i = 0; i < tree.length; i++) {
            int temp =0;
            if (count == 0) {
                map.putIfAbsent(tree[i], 0);
                first = tree[i];
                res = Math.max(res, i + 1);
                count++;
            } else if (count == 1) {
                if (map.containsKey(tree[i])) {

                } else {
                    second = tree[i];
                    count++;
                    map.putIfAbsent(second, i);

                }
                temp = i - map.get(first) + 1;
                res = Math.max(res, temp);
            } else {
                if (map.containsKey(tree[i]) && i - 1 > 0 && tree[i] == second) {
                    temp = i - map.get(first) + 1;
                    res = Math.max(res, temp);
                    // start no change
                } else if (map.containsKey(tree[i]) && i - 1 > 0 && tree[i] == first) {
                    temp = i - map.get(first) + 1;
                    res = Math.max(res, temp);
                   // map.put(first,i);
                } else {

                    map.remove(first);
                    // update first
                    first = second;
                    map.put(first,  map.get(second));
                    // update second
                    second = tree[i];
                    map.put(second, i);
                    temp = 2;
                    res = Math.max(res, temp);
                }
            }
            System.out.print("index is "+ i+ " ");
            System.out.print("first is "+ first+ " ");
            System.out.print("first start is "+ map.get(first)+ " ");
            System.out.print("Second is "+ second+" ");
            System.out.print("second start is "+ map.get(second)+ " ");
            System.out.print("Count is "+ count+" ");
            System.out.println("temp is "+ temp+" ");
            System.out.println("res is "+ res+" ");
        }
        return res;
    }
    public static void main(String[] args){
        int[] tree = {1,2,2,3,2,1};
        int[] tree2 = {3,3,3,1,2,1,1,2,3,3,4};
        int[] tree3 = {0,1,6,6,4,4,6};
        totalFruit(tree);
    }
}
