package boj;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj1744_수묶기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // init
        int N = sc.nextInt();
        int sum = 0;
        PriorityQueue<Integer> plusPQ = new PriorityQueue<>(Comparator.reverseOrder()); // 2이상 담길 pq
        PriorityQueue<Integer> minusPQ = new PriorityQueue<>(); // 음수 ~ 1까지 담길 pq

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num >= 2) {
                plusPQ.offer(num);
            } else {
                minusPQ.offer(num);
            }
        }

        // logic
        while (!plusPQ.isEmpty()) { // 2이상의 친구들은 큰 거부터 묶으면서 내려오면 됨
            if (plusPQ.size() > 1) { // 남은게 두 개 이상이면
                sum += plusPQ.poll() * plusPQ.poll(); // 묶기
            } else
                sum += plusPQ.poll(); // 그냥 더하기
        }

        while (!minusPQ.isEmpty()) { // 음수 ~ 1까지 친구들
            int first = minusPQ.poll(); // 하나 꺼내기
            if (first == 1 | first == 0 | minusPQ.isEmpty()) { // 처음 꺼낼 수가 0, 1, 비어있으면 무조건 더하기
                sum += first;
            } else { // 하나꺼내고도 아직 pq에 남아있으니 묶을지 안 묶을지 체크
                int second = minusPQ.poll();
                if (second == 1) { // 1은 무조건 더해줘야함
                    sum += first + second;
                } else { // 음수 ~ 0까진 묶는게 최대
                    sum += first * second;
                }
            }
        }

        System.out.println(sum);

    }
}
