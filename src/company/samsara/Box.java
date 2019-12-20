package company.samsara;

/**
 * Implement a representation of box, which is used as a container of valuables.
 * Implement two methods. First is to add a valuable to the box (given id as input). Second is to remove a valuable from the box(given valuable object as input).
 * <p>
 * Add an maximum size bar to the representation of box. Modify the add method so that if the total size of valuables in the box will exceed the box size bar,
 * do not add and print an error message. Otherwise, add the valuable into the box.
 * <p>
 * Implement a method to output the maximum valuable-size in the box whenever the method is called.
 * <p>
 * Add an maximum size bar to the representation of box. Modify the add method so that if the total size of valuables in the box will exceed the box size bar,
 * do not add and print an error message. Otherwise, add the valuable into the box.
 * <p>
 * Implement a method to output the maximum valuable-size in the box whenever the method is called.
 * <p>
 * Add an maximum size bar to the representation of box. Modify the add method so that if the total size of valuables in the box will exceed the box size bar,
 * do not add and print an error message. Otherwise, add the valuable into the box.
 * <p>
 * Implement a method to output the maximum valuable-size in the box whenever the method is called.
 */
/**
 * Add an maximum size bar to the representation of box. Modify the add method so that if the total size of valuables in the box will exceed the box size bar,
 * do not add and print an error message. Otherwise, add the valuable into the box.
 */

/**
 * Implement a method to output the maximum valuable-size in the box whenever the method is called.
 */

import java.util.HashMap;
import java.util.Map;

public class Box {
	public static final int SIZE_BAR = 30;
	public static int curSize = 30;
	public static int maxSize = -1;

	public Map<Integer, Valuable> valuableMap = new HashMap<>();

	public void addValuable(int id, Valuable valuable) {
		if (valuableMap.containsKey(id)) {
			System.err.println("error: valuable is already in the box");
			return;
		}
		if (curSize + valuable.size > SIZE_BAR) {
			System.err.println("error: exceed box size");
			// do nothing
			return;
		}
		valuableMap.put(id, new Valuable(id, valuable.name));
		curSize += valuable.size;
		maxSize = Math.max(valuable.size, maxSize);
	}

	public void removeValuable(Valuable valuable) {
		if (valuableMap.get(valuable.id) != null) {
			valuableMap.remove(valuable);
			curSize -= valuable.size;
			maxSize = -1;
			maxSize = getMaxValuableSize();
			return;
		}
		System.err.println("valuable is not in the box");
	}

	public int getMaxValuableSize() {
		if (maxSize != -1)
			return maxSize;
		int max = Integer.MIN_VALUE;
		for (int id : valuableMap.keySet()) {
			if (max > valuableMap.get(id).size) {
				max = valuableMap.get(id).size;
			}
		}
		return max;
	}

}
