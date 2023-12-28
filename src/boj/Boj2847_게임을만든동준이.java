package boj;

import java.util.Scanner;

public class Boj2847_게임을만든동준이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // init
        int N = sc.nextInt();
        int cnt = 0;
        int max;
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        // logic
        max = scores[N-1]; // 제일 끝 값이 일단 최대 값이 됨

        for (int i = N-2; i >= 0 ; i--) {
            if (scores[i] >= max) { // 오름차순이 아니면 오름차순으로 변경
                cnt += scores[i] - max + 1;
                max--;
            } else { // 이미 오름차순이면 max값만 변경
                max = scores[i];
            }
        }

        System.out.println(cnt);
    }
}
