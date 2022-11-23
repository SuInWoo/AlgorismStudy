package group.g7th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10026 {

    public static int[] mx = new int[]{-1, 1, 0, 0};    // 좌, 우, 상 하
    public static int[] my = new int[]{0, 0, -1, 1};
    public static int n = 0, blind = 0, nonBlind = 0;
    public static boolean[][] visited;
    public static char[][] grid;

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        char currentColor = grid[x][y]; // 현재 방문한 정점의 색깔을 저장

        for (int i = 0; i < 4; i++) {
            int nX = x + mx[i];
            int nY = y + my[i];

            if (nX >= 0 && nY >= 0 && nX < n && nY < n) {
                if (grid[nX][nY] == currentColor && !visited[nX][nY])   // 색깔이 맞지 않으면 탐색하지 않음
                    dfs(nX, nY);
            }
        }

    }

    public static void swap() { // 적록색약을 위해 G -> R로 변경
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'G')
                    grid[i][j] = 'R';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // initial
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        visited = new boolean[n][n];

        // input
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        // Logic

        // non-blind
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    nonBlind++;
                    dfs(i, j);
                }
            }
        }

        // blind
        swap(); //G -> R로 변경
        visited = new boolean[n][n];    // 방문 배열 초기화

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    blind++;
                    dfs(i, j);
                }
            }
        }

        //output
        System.out.printf("%d %d", nonBlind, blind);
    }
}
