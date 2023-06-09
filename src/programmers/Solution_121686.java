package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_121686 {

    public static long[] solution(int[][] program) {
        long delayTime[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        List<Program> list = new ArrayList<>();
        boolean visited[] = new boolean[program.length];
        for (int i = 0; i < program.length; i++) {
            list.add(new Program(program[i][0], program[i][1], program[i][2]));
        }
        list.sort(new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                if (o1.start == o2.start) return Integer.compare(o1.score, o2.score);
                return Integer.compare(o1.start, o2.start);
            }
        });

        PriorityQueue<Program> bfs = new PriorityQueue<>(new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                if (o1.score == o2.score) return Integer.compare(o1.start, o2.start);
                return Integer.compare(o1.score, o2.score);
            }
        });
        int count = 0;
        int index = 0;
        long total = 0;
        while (count < program.length) {
            while (index < program.length && list.get(index).start <= total) {
                bfs.offer(list.get(index));
                index++;
            }
            if (bfs.isEmpty()) {
                total = list.get(index).start;
            } else {
                Program peek = bfs.poll();
                delayTime[peek.score - 1] += (long) (total - peek.start);
                total += (long) peek.time;
                count++;
            }
        }

        List<Long> answer = new ArrayList<>();
        answer.add(total);
        for (int i = 0; i < delayTime.length; i++)
            answer.add(delayTime[i]);

        return answer.stream().mapToLong(i -> i).toArray();
    }

    // main test code
//    int[][] program = {{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}};
//    int[][] program2 = {{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {5, 0, 5}};
//        System.out.println(Solution_121686.solution(program));
//        System.out.println(Solution_121686.solution(program2));

    // main test code
    static class Program {
        int score;
        int start;
        int time;

        public Program(int score, int start, int time) {
            this.score = score;
            this.start = start;
            this.time = time;
        }

    }
}
