package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] numsSum = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                sum += Integer.parseInt(st.nextToken());
                numsSum[i][j] = sum;
            }
        }
        // end input

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int ans = 0;
            for (int j = x1; j <= x2; j++) {
                ans += numsSum[j][y2] - numsSum[j][y1 - 1];
            }
            sb.append(ans + "\n");
        }

        System.out.println(sb);

    }
}
