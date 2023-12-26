package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11501_주식 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // init & logic
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) { // test case
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long[] prices = new long[N];
            long cost = 0; // 이익

            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            // end init

            // logic
            long max = prices[N-1];
            for(int i = N-1; i >= 0; i--) {
                if(max >= prices[i])
                    cost += max - prices[i];
                else
                    max = prices[i];
            }

            sb.append(cost).append("\n");
        }
        System.out.println(sb);
    }
}
