package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2170_선긋기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // init
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // logic
        Point first = pq.poll(); // 처음
        int start = first.x;
        int end = first.y;
        int sum = end - start;

        while (!pq.isEmpty()) {
            Point p = pq.poll();

            if (end >= p.x && end < p.y) { // 겹치면서 연장될 때
                sum += p.y - end;
                end = p.y;
            } else if (end < p.x) { // 아예 겹치지 않아 길이를 따로 더해야 할때
                start = p.x;
                end = p.y;
                sum += end - start;
            }

            // 겹치면 아무것도 하지 않음
        }

        System.out.println(sum);
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }
    }

}
