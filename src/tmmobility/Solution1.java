package tmmobility;

import java.util.List;

public class Solution1 {

    public int[] solution(int[] c) {
        int[] answer = {};
        int blockIndex = 0;
        int blockNumber = 0;

        for (int i = 0; i < c.length; i++) {

            boolean leftValid = true;
            boolean rightValid = true;
            // left check
            int startValue = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (c[j] != startValue) {
                    leftValid = false;
                    break;
                }
                startValue = startValue == 5 ? 1 : (startValue + 1);
            }
            // right check
            startValue = 5;
            for (int j = i + 1; j < c.length; j++) {
                if (c[j] != startValue) {
                    rightValid = false;
                    break;
                }
                startValue = startValue == 1 ? 5 : (startValue - 1);
            }
            // if no problem ok
            if (leftValid && rightValid) {
                blockIndex = i + 1;
                blockNumber = c[i];
                break;
            }
        }
        return List.of(blockIndex, blockNumber).stream().mapToInt(i -> i).toArray();
    }
}
