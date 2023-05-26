package programmers;

public class Solution_121684 {

    public static boolean visited[];

    // main test code
    //    int[][] ability = {{40, 10, 10}, {20, 5, 0},{30, 30, 30},{70, 0, 70},{100, 100, 100}};
    //    int[][] ability2 = {{20, 30}, {30, 20}, {20, 30}};
    //    System.out.println(programmers.Solution_121684.solution(ability));
    //    System.out.println(programmers.Solution_121684.solution(ability2));
    public static int solution(int[][] ability) {
        int answer = 0;
        int rowCount = ability.length;
        int colCount = ability[0].length;
        visited = new boolean[rowCount];
        return solve(colCount, 0, 0, ability);
    }


    public static int solve(int count, int sum, int index, int[][] ability) {
        if (count == index)
            return sum;
        int total = sum;
        for (int i = 0; i < ability.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                total = Math.max(total, solve(count, sum + ability[i][index], index + 1, ability));
                visited[i] = false;
            }
        }
        return total;
    }
}
