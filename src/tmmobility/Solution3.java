package tmmobility;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {

    public int dy[] = {0, 1, 0, -1};
    public int dx[] = {1, 0, -1, 0};

    public int[][] solution(int N, int[][] bus_stop) {

        int[][] answer = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < bus_stop.length; i++) {
            int y = bus_stop[i][0] - 1;
            int x = bus_stop[i][1] - 1;
            Queue<Point> bfs = new LinkedList<>();
            bfs.add(new Point(y, x, 0));
            answer[y][x] = Math.min(0, answer[y][x]);
            while (!bfs.isEmpty()) {
                Point p = bfs.poll();
                for (int d = 0; d < 4; d++) {
                    int ny = p.y + dy[d];
                    int nx = p.x + dx[d];
                    int nCount = p.count + 1;
                    if (ny >= 0 && ny < N && nx >= 0 && nx < N && nCount < answer[ny][nx]) {
                        bfs.add(new Point(ny, nx, nCount));
                        answer[ny][nx] = Math.min(nCount, answer[ny][nx]);
                    }
                }
            }
        }
        return answer;
    }

    class Point {
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
