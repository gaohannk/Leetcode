package company.google.onsite;

import java.util.LinkedList;
import java.util.List;

/**
 * __L_R__ 题目是一个一维的棋盘，上面有l和r两种棋子，l只能往左走，r只能往右走，不能跨过其他棋子，下划线代表空格。给初始和最终的两个state作为input，输出一个boolean，判断第二个state是否可以由第一个state通过若干操作达成
 */
public class MovingBoard {

    public boolean solution(String start, String end) {
        String replaceS = start.replace("_", "");
        String replaceE = end.replace("_", "");

        List<Integer> counts = getFreqList(replaceS);
        List<Integer> counte = getFreqList(replaceE);
        if (counte.size() != counte.size()) {
            return false;
        }
        for (int i = 0; i < counte.size(); i++) {
            if (counte.get(i) != counts.get(i)) {
                return false;
            }
        }

        List<Integer> indexL_start = getIndex(start, 'L');
        List<Integer> indexL_end = getIndex(end, 'L');
        List<Integer> indexR_start = getIndex(start, 'R');
        List<Integer> indexR_end = getIndex(end, 'R');

        for (int i = 0; i < indexL_start.size(); i++) {
            if (indexL_start.get(i) < indexL_end.get(i)) {
                return false;
            }
        }
        for (int i = 0; i < indexR_end.size(); i++) {
            if (indexR_start.get(i) > indexR_end.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getIndex(String start, char c) {
        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == c) {
                res.add(i);
            }
        }
        return res;
    }

    private List<Integer> getFreqList(String replaceS) {
        List<Integer> countS = new LinkedList<>();
        int count = 1;
        char c = replaceS.charAt(0);
        for (int i = 1; i < replaceS.length(); i++) {
            if (replaceS.charAt(i) == c) {
                count++;
            } else {
                c = replaceS.charAt(i);
                countS.add(count);
                count = 1;
            }
        }
        countS.add(count);
        return countS;
    }
}
