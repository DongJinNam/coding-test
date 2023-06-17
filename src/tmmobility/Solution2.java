package tmmobility;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {

    public int dy[] = {0, 1, 0, -1};
    public int dx[] = {1, 0, -1, 0};

    public int[] solution(int[][] v) {

        int[] answer = {4, 8};

        int row = v.length;
        int col = v[0].length;
        int count = 0;
        int maxArea = 0;

        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (v[i][j] == 1 && visited[i][j] == false) {
                    // bfs
                    int tempMaxArea = 0;
                    Queue<Point> bfs = new LinkedList<>();
                    bfs.add(new Point(i, j));
                    visited[i][j] = true;
                    tempMaxArea++;

                    while (!bfs.isEmpty()) {
                        Point p = bfs.poll();

                        for (int d = 0; d < 4; d++) {
                            int ny = p.y + dy[d];
                            int nx = p.x + dx[d];

                            if (ny >= 0 && ny < row && nx >= 0 && nx < col && v[ny][nx] == 1 && visited[ny][nx] == false) {
                                bfs.add(new Point(ny, nx));
                                visited[ny][nx] = true;
                                tempMaxArea++;
                            }
                        }
                    }
                    count++;
                    maxArea = Math.max(maxArea, tempMaxArea);
                }
            }
        }
        return List.of(count, maxArea).stream().mapToInt(i -> i).toArray();
    }

    class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
