package cpay;

public class Solution_2 {


    public static int solution(int n) {
        int answer = n;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        for (int i = 1; i < n; i++) {
            int box = i * (i + 1) / 2;
            if (n - box > i) {
                answer = Math.max(answer, (n - box) * (i + 1));
            }
        }
        return answer;
    }

}
