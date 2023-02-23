package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj4963 {
    static int[] di = {-1, -1, 0, +1, +1, +1, 0, -1}; // 12시방향부터 시계방향으로
    static int[] dj = {0, +1, +1, +1, 0, -1, -1, -1};

    static int[][] map;
    static boolean[][] visited;
    static int W, H;

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void bfs(int sY, int sX) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(sY, sX));
        visited[sY][sX] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 8; i++) {
                int nextY = now.y + di[i];
                int nextX = now.x + dj[i];

                if (nextY >= 0 && nextY < H && nextX >= 0 && nextX < W && map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
                    q.add(new Point(nextY, nextX));
                    visited[nextY][nextX] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            W = sc.nextInt();
            H = sc.nextInt();

            if (W == 0 && H == 0)
                break;

            map = new int[H][W];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            visited = new boolean[H][W];
            int ans = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }


}
