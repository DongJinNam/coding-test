package cpay;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_3 {


    static int dp_Y[] = {0, 1, 0, -1};
    static int dp_X[] = {1, 0, -1, 0};

    // main test
//    String[] arr1 = {"0000000111", "1110010110", "1110111000", "0000000111"};
//    String[] arr2 = {"111", "000", "000", "110"};
//    String[] arr3 = {"1000011", "1111000", "0000000", "1101111"};
//        System.out.println(Solution_3.solution(arr1));
    public static int solution(String[] maps) {
        int answer = 0;
        int row = maps.length;
        int col = maps[0].length();
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = maps[i].charAt(j) - '0';
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1) continue;
                arr[i][j] = 1;
                answer = Math.max(answer, bfs(arr, row, col));
                arr[i][j] = 0;
            }
        }
        return answer;
    }

    public static int bfs(int[][] arr, int row, int col) {
        boolean visited[][] = new boolean[row][col];
        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    Queue<Point> bfs = new LinkedList<>();
                    int count = 0;
                    bfs.add(new Point(i, j));
                    count++;
                    visited[i][j] = true;
                    while (!bfs.isEmpty()) {
                        Point pos = bfs.poll();
                        for (int k = 0; k < 4; k++) {
                            int new_y = pos.y + dp_Y[k];
                            int new_x = pos.x + dp_X[k];
                            if (isIn(new_y, new_x, row, col) && arr[new_y][new_x] == 1 && !visited[new_y][new_x]) {
                                bfs.add(new Point(new_y, new_x));
                                count++;
                                visited[new_y][new_x] = true;
                            }
                        }
                    }
                    answer = Math.max(answer, count);
                }
            }
        }
        return answer;
    }

    public static boolean isIn(int y, int x, int row, int col) {
        return y >= 0 && y < row && x >= 0 && x < col;
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
