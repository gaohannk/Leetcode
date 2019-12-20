package leetcode.algo.n;

import java.util.ArrayList;
import java.util.List;

public class NumberofBurgerswithNoWasteofIngredients2 {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {

        //x jumbo, y small, 4x+2y = tomato, x+y = cheese
        //2x+2y = 2cheese
        //2x = tomato-2cheese
        //x= (tomato-2cheese)/2

        List<Integer> list = new ArrayList<Integer>();
        //x>0, y>0, x and y are int
        int x = (tomatoSlices - 2 * cheeseSlices) / 2;
        int y = 2 * cheeseSlices - tomatoSlices / 2;

        if ((tomatoSlices - 2 * cheeseSlices) % 2 == 0 && x >= 0 && y >= 0) {
            list.add(x);
            list.add(y);
        }

        return list;
    }
}
