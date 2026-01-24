package programmers;

import java.util.*;

class P_리코쳇로봇 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int sx, sy; // 시작 위치

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        char[][] convertM = new char[n][m];

        init(board, convertM);

        // BFS 실행 (목표는 'G')
        return bfs(convertM, sx, sy, 'G');
    }

    public int bfs(char[][] board, int startY, int startX, char target) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<Robot> dq = new ArrayDeque<>();

        // 시작점 설정
        dq.offer(new Robot(startY, startX, 0));
        visited[startY][startX] = true;

        while (!dq.isEmpty()) {
            Robot curr = dq.poll();

            // 미끄러져서 멈춘 곳이 G
            if (board[curr.y][curr.x] == target) {
                return curr.dist;
            }

            for (int i = 0; i < 4; i++) {
                int ny = curr.y;
                int nx = curr.x;

                // 해당 방향으로 미끄러지기
                while (true) {
                    int nextY = ny + dy[i];
                    int nextX = nx + dx[i];

                    if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || board[nextY][nextX] == 'D') {
                        break;
                    }

                    ny = nextY;
                    nx = nextX;
                }

                // 미끄러져서 멈춘 최종 위치(ny, nx)가 처음 방문하는 곳이라면
                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dq.offer(new Robot(ny, nx, curr.dist + 1));
                }
            }
        }
        return -1; // 도달 불가능한 경우
    }

    public void init(String[] board, char[][] convertM) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                char c = board[i].charAt(j);
                convertM[i][j] = c;
                if (c == 'R') {
                    sx = i; sy = j;
                }
            }
        }
    }

    public static class Robot {
        int y, x, dist;
        Robot(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}
