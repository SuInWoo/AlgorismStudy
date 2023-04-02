package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Knapsack[] sack = new Knapsack[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            sack[i] = new Knapsack(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[][] p = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) { // 무게
                if (sack[i].w > j) { // 현재 배낭을 포함 못하는 경우
                    p[i][j] = p[i - 1][j];
                } else { // 포함 한것과 안한것중 최대
                    p[i][j] = Math.max(p[i - 1][j], p[i - 1][j - sack[i].w] + sack[i].v);
                }
            }
        }

        System.out.println(p[N][K]);

    }
}

class Knapsack {
    int w; // 무게
    int v; // 가치

    public Knapsack(int w, int v) {
        super();
        this.w = w;
        this.v = v;
    }
}