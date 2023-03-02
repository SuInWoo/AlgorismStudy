package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw5656_벽돌깨기 {

    static int N, W, H;
    static int[][] map;
    static int[] my = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] mx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 구슬 쏘는 횟수
            W = Integer.parseInt(st.nextToken()); // 가로
            H = Integer.parseInt(st.nextToken()); // 세로
            map = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // end input

            // 구슬 출발 부분 정하기
            int sy = 0;
            int sx = 0;

            // 벽돌 깨기
            breakBrick(new Brick(sy, sx, map[sy][sx]));

            // 남은 부분 계산
            ans = Math.min(ans, extraCnt());

            sb.append("#").append(tc).append(" ").append(ans);
        }

        System.out.println(sb);

    }

    static void breakBrick(Brick brick) { // param: 첫 블록 좌표

        Queue<Brick> q = new ArrayDeque<>();

        q.add(brick); // 첫 블록 객체 넣어줌

        // 방문체크는 좌표 value가 0이면 방문한거임
        while (!q.isEmpty()) {
            Brick selectB = q.poll(); // 선택된 블록 좌표
            int repeatCnt = selectB.value;
            map[selectB.y][selectB.x] = 0; // 자기 자신 지워줌

            if (repeatCnt == 0) // 선택된 블록이 0이면 퍼져나갈 수 없으므로 넘어감
                continue;

            // 1이 아니면 다른 곳에도 영향을 줌
            for (int i = 1; i < repeatCnt; i++) { // 해당 블록 value만큼 뻗어나가야 하므로
                for (int j = 0; j < 4; j++) { // 4방향으로
                    int ny = brick.y + (my[j]*i);
                    int nx = brick.x + (mx[j]*i);

                    if(!isPossible(ny, nx) || map[ny][nx] == 0) // 바깥 범위로 가려고하면 넘어가기, 해당 블록은 0이면
                        continue;

                    q.add(new Brick(ny, nx, map[ny][nx]));
                }
            }
        }
    }

    // 마지막 남은 벽돌 세는 메서드
    static int extraCnt() {
        int cnt = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(map[i][j] != 0) // 0이 아닌 부분은 벽돌이므로
                    cnt++;
            }
        }

        return cnt;
    }

    // 좌표 밖으로 안나가는지 체크하는 메서드
    static boolean isPossible(int y, int x) {
        return (y > 0 && y < H && x > 0 && x < W);
    }

    static class Brick {
        int y; // 좌표
        int x;
        int value; // 블록이 가지고 있는 영향 수

        public Brick(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }
}
