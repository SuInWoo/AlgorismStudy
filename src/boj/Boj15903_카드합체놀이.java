package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj15903_카드합체놀이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // init
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long sum = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(); // 작은 것부터 출력

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer((long) Integer.parseInt(st.nextToken())); // pq에 집어넣기
        }

        // logic
        for (int i = 0; i < m; i++) {
            long min1 = pq.poll();
            long min2 = pq.poll();

            pq.offer(min1 + min2);
            pq.offer(min1 + min2);
        }

        while(!pq.isEmpty()) {
            sum += pq.poll();
        }

        System.out.println(sum);

    }
}
