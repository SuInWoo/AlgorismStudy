package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 1. 10억까지 피보나치 수 넣어 놓기
 * 2. 잔돈 문제 처럼 n 보다 작으면서 가장 큰 수 부터 지우기
 * 3. 값 StringBuilder에 넣고 0이 되면 출력
 */
public class Boj9009_피보나치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        // 피보나치 수 담기
        int[] fibo = new int[45];
        fibo[0] = 1;
        fibo[1] = 1;

        for (int i = 2; i < 45; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        // logic
        for (int i = T; i > 0; i--) {
            int n = Integer.parseInt(br.readLine());
            int size = 44;
            String s = "";
            while (n != 0) {
                int compareNum = fibo[size--];

                if (n - compareNum >= 0 && n >= compareNum) {
                    n -= compareNum;
                    s = compareNum + " " + s;
                }
            }

            answer.append(s.trim()).append("\n");
        }

        System.out.println(answer);

    }
}
