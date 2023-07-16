package programmers;

public class Solution_161988 {


    public static long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        long s1 = 0, s2 = 0;
        long s1Min = 0, s2Min = 0;
        int pulse = 1;

        for (int i = 0; i < sequence.length; i++) {
            s1 += sequence[i] * pulse;
            s2 += sequence[i] * pulse * -1;

            answer = Math.max(answer, s1 - s1Min);
            answer = Math.max(answer, s2 - s2Min);

            s1Min = Math.min(s1, s1Min);
            s2Min = Math.min(s2, s2Min);
            pulse *= -1;
        }
        return answer;
    }
}
