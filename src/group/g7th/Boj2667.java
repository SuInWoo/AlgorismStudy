package group.g7th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2667 {
    public static int[] mx = new int[]{-1, 1, 0, 0};    // 좌, 우, 상 하
    public static int[] my = new int[]{0, 0, -1, 1};
    public static int n;
    public static boolean[][] visited;  // 방문 여부 저장
    public static int[][] apart;    // 아파트 0, 1을 담을 배열
    public static int part = 0;   // 단지 수
    public static int[] home;   // 단지 안의 집의 수

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        home[part]++;

        for (int i = 0; i < 4; i++) {   // 네 방향으로 탐색하므로 4번 for문 돌려줌
            int nextX = x + mx[i];
            int nextY = y + my[i];

            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                if (apart[nextX][nextY] == 1 && !visited[nextX][nextY])
                    dfs(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        apart = new int[n][n];
        visited = new boolean[n][n];
        home = new int[n*n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                apart[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (apart[i][j] == 1 && !visited[i][j]) {
                    part++;
                    dfs(i, j);
                }
            }
        }

        Arrays.sort(home);

        System.out.println(part);
        for (int i : home) {
            if (i == 0) continue;
            System.out.println(i);
        }
    }
}
