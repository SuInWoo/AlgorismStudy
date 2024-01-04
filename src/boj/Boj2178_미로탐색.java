package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj2178_미로탐색 {

    static int[] my = {0, -1, 0, 1}; // 좌, 상, 우, 하
    static int[] mx = {-1, 0, 1, 0};
    static int answer = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        // end init

        bfs(arr, visited, N, M);
        System.out.println(answer);

    }

    static void bfs(char[][] arr, boolean[][] visited, int N, int M) {
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0));

        while (!q.isEmpty()) {
            int repeat = q.size();

            for (int i = 0; i < repeat; i++) {
                Point cp = q.poll();
                int cy = cp.y; // 현재 좌표
                int cx = cp.x;

                if (cy == N-1 && cx == M-1) { // 도착했으면
                    return;
                }

                // 4방향 탐색
                for (int j = 0; j < 4; j++) {
                    int ny = cy + my[j];
                    int nx = cx + mx[j];

                    if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || arr[ny][nx] == '0')
                        continue;

                    visited[ny][nx] = true; // 방문체크
                    q.offer(new Point(ny, nx));
                }
            }

            answer++;
        }

    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
