import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_121685 {

    // main test code
    public static String[] solution(int[][] queries) {
        List<String> answer = new ArrayList<>();
        String[] arr = {"RR", "Rr", "Rr", "rr"};
        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int p = queries[i][1];

            // n == 1 인 경우, Rr 로 리턴하도록 예외처리
            if (n == 1) {
                answer.add(arr[1]);
                continue;
            }

            int value = (1 << (2 * (n-2)));
            int temp = p-1;
            boolean checked = false;
            while (value > 0) {
                if (temp / value == 0) {
                    answer.add(arr[0]);
                    checked = true;
                    break;
                } else if (temp / value == 3) {
                    answer.add(arr[3]);
                    checked = true;
                    break;
                } else {
                    temp %= value;
                    value >>= 2;
                }
            }
            if (!checked) answer.add(arr[1]);
        }
        return answer.toArray(new String[0]);
    }
}