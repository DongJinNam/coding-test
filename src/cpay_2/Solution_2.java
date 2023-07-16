package cpay_2;

public class Solution_2 {

    public static int solution(int[] rooms) {
        int answer = 0;
        boolean[] visited = new boolean[rooms.length];
        int areaCount = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (visited[i] == false) {
                int count = 0;
                int target = rooms[i];
                visited[i] = true;
                count++;
                while (target != i+1) {
                    visited[target-1] = true;
                    count++;
                    target = rooms[target-1];
                }
                areaCount++;
            }
        }
        return Math.max(areaCount - 1, 1);
    }
}
