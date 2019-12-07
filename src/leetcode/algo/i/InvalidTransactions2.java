package leetcode.algo.i;

import java.util.*;

public class InvalidTransactions2 {
    class Transaction {
        String name;
        int time;
        int amount;
        String city;
        public Transaction(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }
        public String toString() {
            return this.name + "," + this.time + "," + this.amount + "," + this.city;
        }
    }
    private Map<String, List<Transaction>> map;
    private Set<String> set;
    public List<String> invalidTransactions(String[] transactions) {

        map = new HashMap<>();
        set = new HashSet<>();
        if (transactions == null || transactions.length == 0)
            return new ArrayList<>();
        // build transaction map with name as key
        for (String transaction : transactions) {
            String[] t = transaction.split(",");
            Transaction tran = new Transaction(t[0], Integer.parseInt(t[1]), Integer.parseInt(t[2]), t[3]);
            if (!map.containsKey(tran.name)) {
                map.put(tran.name, new ArrayList<>());
            }
            map.get(tran.name).add(tran);
        }
        for (String name : map.keySet()) {
            List<Transaction> list = map.get(name);
            Collections.sort(list, (t1, t2) -> t1.time - t2.time);
            int i = 0, j = 1;
            if (list.get(i).amount > 1000) {
                set.add(list.get(i).toString());
            }
            while (j < list.size()) {
                while (i < j && list.get(j).time - list.get(i).time > 60) {
                    i++;
                }
                for (int idx = i; idx < j; idx++) {
                    if (!list.get(idx).city.equals(list.get(j).city)) {
                        set.add(list.get(idx).toString());
                        set.add(list.get(j).toString());
                    }
                }
                if (list.get(j).amount > 1000) {
                    set.add(list.get(j).toString());
                }
                j++;
            }
        }
        List<String> res = new ArrayList<>();
        for (String s : set) {
            res.add(s);
        }
        return res;
    }
}
