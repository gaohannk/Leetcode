package company.flexe.oa;

public class Problem1 {
    final static String DIC = "ABCDEFGHIG";

    public int solution(int N, String S) {
        // write your code in Java SE 8
        if (N == 0) {
            return 0;
        }
        if (S == null || S.length() == 0) {
            return N * 3;
        }
        int[][] map = getReservedSeatMap(N, S);

        return getTotal(N, map);
    }

    private int[][] getReservedSeatMap(int N, String S) {
        int map[][] = new int[N + 1][10];
        String[] splits = S.split(" ");
        for (String resevered : splits) {
            int i = 0;
            String num = "";
            while (i < resevered.length()) {
                if (Character.isDigit(resevered.charAt(i))) {
                    num += resevered.charAt(i);
                    i++;
                } else {
                    break;
                }
            }
            int row = Integer.parseInt(num);
            String seat = resevered.substring(i);
            int id = DIC.indexOf(seat);
            if (id != -1) {
                map[row][id] = 1;
            }
        }
        return map;
    }

    private int getTotal(int N, int[][] map) {
        int total = 0;
        for (int i = 1; i <= N; i++) {
            if (map[i][0] != 1 && map[i][1] != 1 && map[i][2] != 1) {
                total++;
            }
            if (map[i][7] != 1 && map[i][8] != 1 && map[i][9] != 1) {
                total++;
            }
            if ((map[i][3] != 1 && map[i][4] != 1 && map[i][5] != 1)
                    || (map[i][4] != 1 && map[i][5] != 1 && map[i][6] != 1)) {
                total++;
            }
        }
        return total;
    }
}
