package boj;
import java.io.*;
import java.util.*;

public class Boj16236_아기상어 {
    static int N, time, sx, sy, age, cnt;
    static int[][] map;
    static ArrayList<Fish> fishes;
    static Queue<Fish> pFishes;
    static int dx[] = { -1, 1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        age = 2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = i;
                    sy = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            fishes = new ArrayList<Fish>();
            pFishes = new PriorityQueue<>();
            Queue<Fish> q = new ArrayDeque<Fish>();
            boolean visited[][] = new boolean[N][N];
            q.offer(new Fish(sx, sy, 0));
            visited[sx][sy] = true;

            while (!q.isEmpty()) {
                Fish shark = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = shark.x + dx[d];
                    int ny = shark.y + dy[d];

                    if (isPossible(nx, ny) || visited[nx][ny])
                        continue;

                    if (1 <= map[nx][ny] && map[nx][ny] < age) {
                        q.offer(new Fish(nx, ny, shark.dist + 1));
                        pFishes.offer(new Fish(nx, ny, shark.dist + 1));
                        visited[nx][ny] = true;
                    } else if (map[nx][ny] == age || map[nx][ny] == 0) {
                        q.offer(new Fish(nx, ny, shark.dist + 1));
                        visited[nx][ny] = true;
                    }
                }
            }

            if (pFishes.isEmpty()) {
                System.out.println(time);
                return;
            }

            Fish eatF = pFishes.poll();
            time += eatF.dist;
            cnt++;
            map[eatF.x][eatF.y] = 0;

            if (cnt == age) {
                age++;
                cnt = 0;
            }

            sx = eatF.x;
            sy = eatF.y;
        }
    }

    static boolean isPossible(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    static class Fish implements Comparable<Fish>{
        int x;
        int y;
        int dist;

        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if(this.dist == o.dist) {
                if(this.x == o.x) {
                    return Integer.compare(this.y, o.y);
                }else {
                    return Integer.compare(this.x, o.x);
                }
            }
            return Integer.compare(this.dist, o.dist);
        }
    }
}
