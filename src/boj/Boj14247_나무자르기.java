package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj14247_나무자르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1;
        StringTokenizer st2;

        // init
        PriorityQueue<Tree> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        long sum = 0L;

        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            pq.offer(new Tree(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken())));
        }

        for (int i = 0; i < n; i++) {
            Tree tree = pq.poll();
            sum += tree.current + tree.grow * i;
        }

        System.out.println(sum);

    }

    static class Tree implements Comparable<Tree> {
        int current;
        int grow;

        public Tree(int current, int grow) {
            this.current = current;
            this.grow = grow;
        }

        @Override
        public int compareTo(Tree o) { // 오름차순

            if (this.grow == o.grow) {
                return this.current - o.current;
            }

            return this.grow - o.grow;
        }
    }
}
