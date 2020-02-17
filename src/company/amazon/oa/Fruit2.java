package company.amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * public static int checkWinner (List<List<String>> codeList, List<String> shoppingCart) {}
 * 说的是小明要帮公司买水果，给了一个 codeList， 里面装的是他买的水果，给了一个 shoppingCart
 * 里面装的是 target 水果，目标是检查 codelist 里的水果顺序是否和 shoppingCart 里的顺序匹配。
 * 注意的是只有 codelist 中的所有链表的 item 之后加起来小于等于 shoppingcart 里 item 之和才可能
 * 返回 1。 另外在 codelist 中有可能出现 item 时 "anything"， 它可以和任意的水果匹配。
 * Ex1:
 * codelist:
 * [
 * [apple, apple],
 * [orange, banana, orange]
 * ]
 * shoppingCart: [orange, apple, apple, orange, banana, orange]
 * return 1, 因为 codelist 里的顺序和 shoppingcart 里除了第一个 orange 之后的水果顺序匹配
 * Ex2:
 * codelist:
 * [
 * [orange, banana, orange]，
 * [apple, apple]
 * ]
 * shoppingCart: [orange, apple, apple, orange, banana, orange]
 * return 0, 因为 codeList 里的顺序和 shoppingcart 没法匹配。
 * Ex3:
 * codelist:
 * [
 * [apple, apple],
 * [orange, banana, orange],. From 1point 3acres bbs
 * [pear, orange, grape]
 * ]
 * shoppingCart: [orange, apple, apple, orange, banana, orange, pear, grape]
 * return 0, 因为 codelist 里最后一个[pear, orange, grape]中的 orange 没法和 shoppingcart 里的水
 * 果匹配。
 * codeList:
 * [
 * [apple, apple],
 * [orange, anything, orange]
 * ]
 * shoppingCart:
 * [orange, apple, apple, orange, mango, orange]
 * return 1。
 * Ex5:
 * codelist:
 * [
 * [apple, apple],
 * [orange, banana, orange]
 * ]
 * shoppingCart: [orange, apple, apple, orange, apple, orange, banana, orange]. From 1point 3acres
 * bbs
 * return 1, 虽然[apple, apple] 和 [orange, banana, orange] 中间插入了[orange, apple]
 */
public class Fruit2 {
    public static int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < codeList.size() && index < shoppingCart.size()) {
            if (codeList.get(i).get(j).equals(shoppingCart.get(index))) {
                if (j == codeList.get(i).size() - 1) {
                    i++;
                    j = 0;
                    index++;
                } else {
                    j++;
                    index++;
                }
            } else {
                index++;
            }
        }
        if (i == codeList.size() && j == 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<List<String>> codeList = new ArrayList<>();
        List<String> chart = new ArrayList<>();
        codeList.add(Arrays.asList("a", "a"));
        codeList.add(Arrays.asList("o", "b", "o"));
        //codeList.add(Arrays.asList("p", "o","g"));

        chart = Arrays.asList("o", "a", "a", "o", "b", "o", "p", "g");
        System.out.println(checkWinner(codeList, chart));
    }
}