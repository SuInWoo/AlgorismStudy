package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw2115_벌꿀채취 {

    static int N, M, C, ans, firstSum, secondSum;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) { // TC만큼 반복

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // end input

            ans = 0;
            visited = new boolean[M];
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    // 시작점 + M이 범위를 벗어나면 안넣고 continue
                    if (x + M > N)
                        break;

                    // 시작점 넣기(첫 번째 일꾼)
                    search(y, x);
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);

    }

    static void search(int sy, int sx) { // 앞에 좌표 들어오면 그거 기준 나올 수 있는 경우의 수 해보기

        int currentY = sy;
        int currentX = sx;

        // 두 번째 일꾼 좌표 구하기
        for (int y = sy; y < N; y++) { // 시작 지점은 기존 앞의 (일꾼좌표 + 고른 꿀통)
            for (int x = sx + M; x < N; x++) {
                if(x + M > N) // 선택된 좌표에서 꿀통을 더했을때 범위를 벗어날 것 같으면 그 x 좌표는 끝
                    break;

                cal(currentY, currentX, y, x, 0); // 두 번째 일꾼 좌표까지 구한 뒤 계산 시작
            }
            ans = Math.max(ans, firstSum + secondSum); // 계산한 값과 현재 최대값 비교
            firstSum = 0; // 좌표 바꾸면 다시 계산
            secondSum = 0;
            sx = -M; // x축에서 0부터 다시 검사해야하므로
        }
    }

    static void cal(int y1, int x1, int y2, int x2, int depth) { // 계산

        if (depth == M) { // 부분집합 개수가 도달하면
            int sum1 = 0;
            int sum2 = 0;
            int compare1 = 0;
            int compare2 = 0;
            for (int i = 0; i < M; i++) {
                if (visited[i]) { // true이면 골른거니까
                    compare1 += map[y1][x1 + i];
                    sum1 += (int) Math.pow(map[y1][x1 + i], 2); // 첫 번째 일꾼 합 계산
                    compare2 += map[y2][x2 + i];
                    sum2 += (int) Math.pow(map[y2][x2 + i], 2); // 두 번째 일꾼 합 계산
                }
            }

            // 최대치를 안넘는 선에서 최대값 구하기
            if (compare1 <= C)
                firstSum = Math.max(firstSum, sum1);

            if (compare2 <= C)
                secondSum = Math.max(secondSum, sum2);

            return;
        }

        visited[depth] = true; // 방문 체크
        cal(y1, x1, y2, x2, depth + 1);
        visited[depth] = false; // 방문 체크 풀고 다시
        cal(y1, x1, y2, x2, depth + 1);

    }
}
