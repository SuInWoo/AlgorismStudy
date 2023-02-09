package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw4012 {
    static int N, min;
    static boolean[] visited;
    static int[][] food;

    public static void combination(int start, int depth, int r) {
        if (depth == r) { // N/2 갯수가 되면 계산
            calculation();
            return;
        }
        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(i + 1, depth + 1, r);
            visited[i] = false;
        }
    }

    static void calculation() {
        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < N; i++) { // 한개를 기준으로 잡고 ex 1x 2x 3x ...
            for (int j = 0; j < N; j++) { // 나머지 한개를 전부 돌면서 실행 ex) x1 x2 x3 ...
                if (visited[i] && visited[j]) // 음식1
                    sumA += food[i][j];
                else if(!visited[i] && !visited[j]) // 음식2
                    sumB += food[i][j];
            }
        }
        min = Math.min(Math.abs(sumA - sumB), min);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            food = new int[N][N];
            visited = new boolean[N];
            min = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    food[i][j] = Integer.parseInt(st.nextToken());
                }
            }// end input

            // 조합 실행
            combination(0, 0, N/2);
            System.out.printf("#%d %d\n", tc, min);
        }
    }
}
