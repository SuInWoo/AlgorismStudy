package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16926 {
    static int N, M, R;
    static int[][] arr;
    static int[] my = new int[]{0, 1, 0, -1}; //우 하 좌 상
    static int[] mx = new int[]{1, 0, -1, 0};

    static void rotate() {
        for (int i = 0; i < Math.min(N, M) / 2; i++) {
            int nowY = i;
            int nowX = i;
            int tmp = arr[nowY][nowX];
            int dir = 0;

            while (true) {
                int nextY = nowY + my[dir];
                int nextX = nowX + mx[dir];

                if (nextX == M - i || nextY == N - i || nextX == i - 1 || nextY == i - 1) {
                    dir++;
                    if (dir == 4) break;
                    else continue;
                }

                arr[nowY][nowX] = arr[nextY][nextX];
                nowY = nextY;
                nowX = nextX;
            }

            arr[i + 1][i] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        R = Integer.parseInt(st.nextToken()); // 회전 수

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // end input

        for (int i = 0; i < R; i++) {
            rotate();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
