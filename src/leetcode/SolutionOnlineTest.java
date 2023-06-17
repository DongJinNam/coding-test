package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SolutionOnlineTest {

    public static int dy[] = {0, 1, 0, -1};
    public static int dx[] = {1, 0, -1, 0};

    public static boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        Map<String, String> map = new HashMap<>();
        Map<String, String> reversedMap = new HashMap<>();
        boolean answer = true;

        if (arr.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            char ch = pattern.charAt(i);
            String str = Character.toString(ch);
            if (map.get(str) == null && reversedMap.get(arr[i]) == null) {
                map.put(str, arr[i]);
                reversedMap.put(arr[i], str);
            } else {
                if (map.get(str) == null && !reversedMap.get(arr[i]).equals(ch)) {
                    answer = false;
                    continue;
                }
                if (reversedMap.get(arr[i]) == null && !map.get(str).equals(arr[i])) {
                    answer = false;
                    continue;
                }
                if (map.get(str) != null && !map.get(str).equals(arr[i])) {
                    answer = false;
                    continue;
                }
                if (reversedMap.get(arr[i]) != null && !reversedMap.get(arr[i]).equals(str)) {
                    answer = false;
                    continue;
                }
            }
        }
        return answer;
    }

    public static int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int arr[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = getShortestDistance(i, j, row, col, mat);
            }
        }
        return arr;
    }

    private static int getShortestDistance(int i, int j, int row, int col, int[][] mat) {
        Queue<Point> queue = new LinkedList<>();
        boolean visited[][] = new boolean[row][col];
        queue.add(new Point(i, j, 0));
        visited[i][j] = false;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (mat[p.y][p.x] == 0) {
                return p.count;
            }
            for (int k = 0; k < 4; k++) {
                int ny = p.y + dy[k];
                int nx = p.x + dx[k];
                if (ny >= 0 && ny < row && nx >= 0 && nx < col && !visited[ny][nx]) {
                    queue.add(new Point(ny, nx, p.count + 1));
                    visited[ny][nx] = true;
                }
            }
        }
        return 0;
    }

    public static class Point {
        int y;
        int x;
        int count;

        public Point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
