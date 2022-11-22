package group.g7th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1987 {

    public static int rnt = 0;
    public static int[] mx = new int[]{-1, 1, 0, 0};    // 좌, 우, 상 하
    public static int[] my = new int[]{0, 0, -1, 1};
    public static int R, C;
    public static boolean[] alpha;
    public static char[][] arr;

    public static void dfs(int x, int y, int cnt) {

        int idx = (int)arr[x][y]-65;

        if (alpha[idx]) {   // 이미 방문한 알파벳이면
            if (cnt > rnt)
                rnt = cnt;
            return;
        } else {
            alpha[idx] = true;  // 방문하면 방문 표시
            for (int i = 0; i < 4; i++) {
                int nX = x + mx[i];
                int nY = y + my[i];

                if (nX >= 0 && nY >= 0 && nX < R && nY < C) {
                    dfs(nX, nY, cnt + 1);
                }
            }

            alpha[idx] = false;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        alpha = new boolean[26];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 0);

        System.out.println(rnt);
    }
}
