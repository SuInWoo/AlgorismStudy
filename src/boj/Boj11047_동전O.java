package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11047_동전O {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // init
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] coins = new int[N];

        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // end init

        // logic
        for(int i = N-1; i >= 0; i--) {
            if(coins[i] > K){
                continue;
            }

            answer += K/coins[i]; // 동전 갯수에 포함
            K = K%coins[i]; // 나머지 가격

            if (K == 0) // 남은 금액이 없으면 끝
                break;
        }

        System.out.println(answer);

    }
}
