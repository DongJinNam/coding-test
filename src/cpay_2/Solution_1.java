package cpay_2;

public class Solution_1 {

    public static int solution(int N, int[] sequence) {
        int answer = 0;
        int start = 1;
        for (int i = 0; i < sequence.length; i++) {
            // 동일
            if (start == sequence[i]) continue;
            int left = 0;
            int right = 0;
            if (sequence[i] < start) {
                left = start - sequence[i];
                right = N - start + sequence[i];
                answer += Math.min(left, right);
            } else {
                left = N + start - sequence[i];
                right = sequence[i] - start;
                answer += Math.min(left, right);
            }
            start = sequence[i];
        }
        return answer;
    }
}
