package wayfair;

public class InsertA {
    public static int solution(String input) {
        int count = 0;

        for (char c : input.toCharArray()) {
            if (c == 'a') {
                count++;
            } else {
                count = 0;
            }
            if (count >= 3)
                return -1;
        }

        int res = 0;
        count = 0;
        for (char c : input.toCharArray()) {
            if (c == 'a') {
                count++;
            } else {
                if (count == 1) {
                    res++;
                } else if (count == 0) {
                    res += 2;
                }
                count = 0;
            }
        }
        if (count == 1) {
            res++;
        } else if (count == 0) {
            res += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        String input = "aa";
        System.out.println(solution(input));
    }
}
