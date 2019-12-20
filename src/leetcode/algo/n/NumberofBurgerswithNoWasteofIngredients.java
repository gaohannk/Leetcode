package leetcode.algo.n;

import java.util.ArrayList;
import java.util.List;

public class NumberofBurgerswithNoWasteofIngredients {
    public List<Integer> numOfBurgers(int t, int c) {
        List<Integer> res = new ArrayList<>();
        if (t % 2 != 0 || t / 2 - c < 0 || 4 * c - t < 0)
            return res;
        res.add(t / 2 - c);
        res.add(2 * c - t / 2);
        return res;
    }
}
