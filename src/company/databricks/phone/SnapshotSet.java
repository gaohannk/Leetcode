package company.databricks.phone;

import java.util.*;

public class SnapshotSet {

    TreeMap<Integer, List<Integer>> map;
    boolean snapshot;
    int time = 0;

    public SnapshotSet() {
        map = new TreeMap<>();
        snapshot = false;
    }

    boolean contains(int e) {
        if (map.keySet().size() == 0) {
            return false;
        }
        return map.get(map.lastKey()).contains(e);
    }

    public void add(int e) {
        if (map.keySet().size() == 0) {
            List<Integer> list = new LinkedList<>();
            list.add(e);
            map.put(time++, list);
        } else {
            if (snapshot) {
                List<Integer> copy = makeCopy();
                map.put(time++, copy);
            }
            map.get(map.lastKey()).add(e);
        }
    }

    private List<Integer> makeCopy() {
        List<Integer> copy = new LinkedList<>();
        List<Integer> cur = map.get(map.lastKey());
        for (int i = 0; i < cur.size(); i++) {
            copy.add(cur.get(i));
        }
        return copy;
    }

    void remove(int e) {
        List<Integer> copy = makeCopy();
        map.put(time++, copy);
        map.get(map.lastKey()).remove((Integer) e);
    }

    Iterator<Integer> iterator() {
        Iterator<Integer> it = map.get(map.lastKey()).iterator();
        snapshot = true;
        return it;
    }

    public static void main(String[] args) {
        SnapshotSet set = new SnapshotSet();
        set.add(1);
        System.out.println(set.map);

        set.add(2);
        System.out.println(set.map);

        boolean isOne = set.contains(1);
        System.out.println(isOne);
        Iterator<Integer> a = set.iterator();
        set.remove(1);
        System.out.println(set.map);

        set.add(4);
        System.out.println(set.map);
        Iterator<Integer> b = set.iterator();
        System.out.println(set.map);

        while (a.hasNext()) {
            System.out.print(a.next() + ",");
        }
        System.out.println();
        set.remove(4);
        while (b.hasNext()) {
            System.out.print(b.next() + ",");
        }
        System.out.println();
        System.out.println(set.contains(4));
    }
}
