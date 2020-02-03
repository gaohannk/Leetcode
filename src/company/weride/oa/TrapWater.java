package company.weride.oa;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TrapWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
            System.out.println(sb.toString());
        }
        String[] splits = sb.toString().split(",");
        for (String item : splits) {
            list.add(Integer.parseInt(item.trim()));
        }

        int sum = getMax(list);
        System.out.println(sum);
    }


    private static int getMax(List<Integer> list) {
        if (list.size() < 2) {
            return 0;
        }

        // accumulate sum
        int leftMax[] = new int[list.size()];
        int rightMax[] = new int[list.size()];
        // init
        leftMax[0] = list.get(0);
        rightMax[list.size() - 1] = list.get(list.size() - 1);

        for (int i = 1; i < list.size(); i++) {
            leftMax[i] = Math.max(list.get(i), leftMax[i - 1]);
        }
        for (int i = list.size() - 2; i >= 0; i--) {
            rightMax[i] = Math.max(list.get(i), rightMax[i + 1]);
        }

        int sum = 0;
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            sum = Math.max(sum, Math.min(list.get(left), list.get(right)) * (right - left));
            if (list.get(left) < list.get(right)) {
                left++;
            } else if (list.get(left) > list.get(right)) {
                right--;
            } else {
                right--;
            }
        }
        return sum;
    }

}
