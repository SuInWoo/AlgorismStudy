package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw2001 {
    static int[][] arr;

    public static int fly(int m, int y, int x) {

        int rnt = 0;
        for (int i = y; i < y + m; i++) {
            for (int j = x; j < x + m; j++) {
                rnt += arr[i][j];
            }
        }

        return rnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            int max = 0;
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // end input

            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int a = fly(M, i, j);
                    if (a > max)
                        max = a;
                }
            }

            System.out.printf("#%d %d\n", test, max);
        }
    }
}
