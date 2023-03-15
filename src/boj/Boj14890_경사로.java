package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14890_경사로 {

    static int N, L, ans;
    static int[][] map;
    static boolean[] visitedW, visitedH;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visitedW = new boolean[N];
            for (int j = 1; j < N; j++) { // 가로 검사
                if(map[i][j] > map[i][j-1]) { // 현재 기준 이전이 작으면
                    ans += checkLoad(i, j, -1, false);
                } else if (map[i][j] < map[i][j-1]) { // 현재 기준 이전이 크면
                    ans += checkLoad(i, j, 1, false);
                }
            }

            visitedH = new boolean[N];
            for (int j = 1; j < N; j++) { // 세로 검사
                if(map[j][i] > map[j-1][i]) { // 현재 기준 이전이 작으면
                    ans += checkLoad(j, i, -1, true);
                } else if (map[j][i] < map[j-1][i]) { // 현재 기준 이전이 크면
                    ans += checkLoad(j, i, 1, true);
                }
            }
        }

        System.out.println(ans);
    }

    static int checkLoad(int cy, int cx, int plusIdx, boolean type) { // 가로 검사면 false, 세로면 true
        int targetNum = map[cy][cx]; // 기준이될 숫자
        for (int i = 0; i < L; i++) { // 경사로 길이만큼 for문 돔
            if (type) { // 세로검사
                cy += plusIdx;
                if(cy < 0 || cy >= N || visitedH[cy] || Math.abs(map[cy][cx] - targetNum) != 1) // 범위 바깥으로 나가면
                    return 0;
                visitedH[cy] = true;
            } else { // 가로검사
                cx += plusIdx;
                if(cx < 0 || cx >= N || visitedW[cx] || Math.abs(map[cy][cx] - targetNum) != 1) // 범위 바깥으로 나가면
                    return 0;
                visitedW[cy] = true;
            }
        }
        return 1;
    }
}
