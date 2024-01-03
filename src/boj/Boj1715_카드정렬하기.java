package boj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj1715_카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // init
        int N = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(sc.nextLong());
        }

        // logic

        long answer = 0;
        for (int i = 0; i < N-1; i++) {
            long num1 = pq.poll();
            long num2 = pq.poll();

            answer += num1 + num2;
            pq.offer(num1 + num2);
        }

        System.out.println(answer);
    }
}
