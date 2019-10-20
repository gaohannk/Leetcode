package leetcode.i;

import java.util.*;

public class InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        Set<String> set = new HashSet<String>();

        Arrays.sort(transactions, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String[] s1_data = s1.split(",");
                String[] s2_data = s2.split(",");
                String s1_name = s1_data[0];
                String s2_name = s2_data[0];
                if (!s1_name.equals(s2_name))
                    return s1_name.compareTo(s2_name);

                int s1_time = Integer.valueOf(s1_data[1]);
                int s2_time = Integer.valueOf(s2_data[1]);

                return s1_time - s2_time;
            }
        });

        int i, j;
        for (i = 0; i < transactions.length - 1; i++) {
            String[] s1_data = transactions[i].split(",");
            String s1_name = s1_data[0];
            int s1_time = Integer.valueOf(s1_data[1]);
            int s1_amount = Integer.valueOf(s1_data[2]);
            String s1_city = s1_data[3];

            if (s1_amount > 1000)
                set.add(transactions[i]);

            for (j = i + 1; j < transactions.length; j++) {
                String[] s2_data = transactions[j].split(",");
                String s2_name = s2_data[0];
                int s2_time = Integer.valueOf(s2_data[1]);
                int s2_amount = Integer.valueOf(s2_data[2]);
                String s2_city = s2_data[3];

                if (s2_amount > 1000)
                    set.add(transactions[j]);

                if (!s1_name.equals(s2_name))
                    break;

                if (!s1_city.equals(s2_city) && s2_time - s1_time <= 60) {
                    set.add(transactions[i]);
                    set.add(transactions[j]);
                }

                if (s2_time - s1_time > 60)
                    break;
            }

        }

        return new ArrayList<String>(set);
    }
}
