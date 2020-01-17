package company.flexe.oa;

public class FlightSeat {
    // ABC DEFG HIJ
    final static String DIC = "ABCDEFGHIJ";

    public int solution(String reserved, int n) {
        String[] splits = reserved.split(" ");
        int total = 0;
        int[][] map = new int[n][10];

        for (String split : splits) {
            int i = 0;
            String num = "";
            while (Character.isDigit(split.charAt(i))) {
                i++;
                num += split.charAt(i);
            }
            int line = Integer.parseInt(num);
            String seat = split.substring(i);
            int id = DIC.indexOf(seat);
            map[line][id] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (map[i][0] != 1 && map[i][1] != 1 && map[i][2] != 1) {
                total++;
            }
            if (map[i][7] != 1 && map[i][8] != 1 && map[i][9] != 1) {
                total++;
            }
            if (map[i][3] != 1 && map[i][4] != 1 && map[i][5] != 1) {
                total++;
            }
            if (map[i][4] != 1 && map[i][5] != 1 && map[i][6] != 1) {
                total++;
            }
        }

        return total;
    }
}
