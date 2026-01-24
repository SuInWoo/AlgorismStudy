package programmers;

import java.util.*;

class P_미로탈출 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int sx, sy, lx, ly; // 시작점과 레버 위치 저장

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        char[][] convertM = new char[n][m];

        // 1. 지도 초기화 및 위치 파악
        init(maps, convertM);

        // 2. S -> L (레버 찾기)
        int toLever = bfs(convertM, sx, sy, 'L');
        if (toLever == -1)
            return -1; // 레버 못 가면 종료

        // 3. L -> E (출구 찾기)
        int toExit = bfs(convertM, lx, ly, 'E');
        if (toExit == -1)
            return -1; // 출구 못 가면 종료

        return toLever + toExit;
    }

    public int bfs(char[][] maps, int startY, int startX, char target) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<Target> dq = new ArrayDeque<>();

        // 시작점 설정
        dq.offer(new Target(startY, startX, 0));
        visited[startY][startX] = true;

        while (!dq.isEmpty()) {
            Target curr = dq.poll();

            // 목표 도달 시 거리 반환
            if (maps[curr.y][curr.x] == target) {
                return curr.dist;
            }

            for (int i = 0; i < 4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
                    if (!visited[ny][nx] && maps[ny][nx] != 'X') {
                        visited[ny][nx] = true;
                        dq.offer(new Target(ny, nx, curr.dist + 1));
                    }
                }
            }
        }
        return -1; // 목표에 도달할 수 없는 경우
    }

    public void init(String[] maps, char[][] convertM) {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                convertM[i][j] = c;
                if (c == 'S') {
                    sx = i; sy = j;
                } else if (c == 'L') {
                    lx = i; ly = j;
                }
            }
        }
    }

    // 좌표와 거리를 담을 클래스
    public static class Target {
        int y, x, dist;
        Target(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}
