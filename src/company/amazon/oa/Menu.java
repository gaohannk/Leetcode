package company.amazon.oa;

import java.util.*;

public class Menu {

    public static List<List<String>> menu(List<List<String>> list1, List<List<String>> list2) {
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        for (List<String> row : list2) {
            if (!map.containsKey(row.get(0))) {
                map.put(row.get(0), new HashSet<String>());
            }
            map.get(row.get(0)).add(row.get(1));
        }
        List<List<String>> result = new ArrayList();
        for (int i = 0; i < list1.size(); i++) {
            if (map.containsKey(list1.get(i).get(1))) {
                for (String dish : map.get(list1.get(i).get(1))) {
                    result.add(Arrays.asList(list1.get(i).get(0), dish));
                }

            }
            if (list1.get(i).get(1) == "*") {
                for (Set<String> dishes : map.values()) {
                    for (String dish : dishes) {
                        result.add(Arrays.asList(list1.get(i).get(0), dish));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> list1 = new ArrayList<>();
        List<List<String>> list2 = new ArrayList<>();
        list1.add(Arrays.asList("Zhang", "Chinese"));
        list1.add(Arrays.asList("Li", "American"));
        list1.add(Arrays.asList("Wang", "Japanese"));
        list1.add(Arrays.asList("Ming", "*"));
        list2.add(Arrays.asList("Chinese", "Pork"));
        list2.add(Arrays.asList("Chinese", "fish"));
        list2.add(Arrays.asList("American", "beef"));
        System.out.println(menu(list1, list2));
    }
}
