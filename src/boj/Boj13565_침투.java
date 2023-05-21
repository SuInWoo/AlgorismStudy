package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13565_침투 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if(s.charAt(j) == '0')
                    arr[i][j] = 0;
                else
                    arr[i][j] = 1;
            }
        }

        for (int i = 0; i < M; i++) {
            if(arr[0][i] == 0) {
                bfs(0, i);
            }
        }

        String s = "NO";
        for (int i = 0; i < M; i++) {
            if(visited[N-1][i]) {
                s = "YES";
            }
        }
        System.out.println(s);
    }

    static void bfs(int i, int j) {
        Queue<Point> q = new ArrayDeque<>();
        Point p = new Point(i, j);
        visited[i][j] = true;
        q.add(p);

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nexti = now.x + dx[d];
                int nextj = now.y + dy[d];

                if(nexti >=0 && nexti < N && nextj >=0 && nextj < M && !visited[nexti][nextj] && arr[nexti][nextj] == 0) {
                    Point next = new Point(nexti, nextj);
                    q.add(next);
                    visited[nexti][nextj] = true;
                }
            }
        }

    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
