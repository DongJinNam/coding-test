package cpay;

public class Solution_1 {
    static String[] init = {"0", "12", "23", "34", "45", "56", "67", "78", "89", "90"};

    public static long solution(String number) {
        String cur = "";
        int index = 0;
        int count = 0;
        boolean[] visited = new boolean[number.length() + 1];
        while (!cur.equals(number)) {
            int val = (int) number.charAt(index) - '0';
            cur += init[val];
            count++;
            int len = cur.length();
            for (int i = index; i < len; i++) {
                if (index < number.length() && cur.charAt(index) == number.charAt(index)) {
                    index++;
                } else {
                    cur = cur.substring(0, cur.length() - 1);
                    count++;
                }
            }
        }
        return count;
    }

}
