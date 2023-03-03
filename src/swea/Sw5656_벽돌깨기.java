package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sw5656_벽돌깨기 {

    static int N, W, H;
    static int[][] map;
    static int[] my = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] mx = {0, 1, 0, -1};
    static List<String> pushBall;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) { // testCase 만큼 실행
            int ans = Integer.MAX_VALUE;
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

            // 구슬 출발 부분 정하기 - 중복 순열
            pushBall = new ArrayList<>(); // str으로 받음
            repeatPerm(0, "");

            aa: for (String s : pushBall) { // 경우의 수 하나씩 뽑기
                int[][] copyMap = new int[H][W]; // 복사 배열 만들기
                deepCopy(copyMap); // 배열 복사

                String[] sArr = s.split(" ");
                for (int i = 1; i < sArr.length; i++) { // 하나씩 꺼내서 확인

                    // 벽돌이 전체가 0이 되었으면 더 이상 실행하지 않아도 되니 결과값 0으로 바꿔주고 테스트 하나 종료
                    if(extraCnt(copyMap) == 0) {
                        ans = 0;
                        break aa;
                    }

                    int sx = Integer.parseInt(sArr[i]); // 구슬 시작 sx
                    int sy = -1;

                    boolean exit = false;

                    while (true) {// 해당 구슬 라인에 부술 수 있는 블록 찾기
                        sy++;
                        if (sy >= H) { // 그 줄에 벽돌이 없으면
                            exit = true;
                            break;
                        }
                        if (copyMap[sy][sx] != 0) // 시작하는 벽돌을 찾으면
                            break;
                    }

                    if (exit) // 벽돌이 없었으면 깰 수 있는 벽돌이 없으므로 넘어감
                        continue;

                    // 벽돌 깨기
                    breakBrick(new Brick(sy, sx, copyMap[sy][sx]), copyMap);

                    // 벽돌 내리기
                    downBrick(copyMap);
                }

                // 남은 부분 계산
                ans = Math.min(ans, extraCnt(copyMap));

            } // end perm loop

            sb.append("#").append(tc).append(" ").append(ans).append("\n");

        } // end test loop

        System.out.println(sb);

    }

    static void downBrick(int[][] copyMap) { // 벽돌 내리기 작업
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if(copyMap[j][i] > 0) { // 0이 아닌 부분은 stack에 넣기
                    stack.push(copyMap[j][i]);
                    copyMap[j][i] = 0;
                }
            }

            int floorIdx = H-1;
            while (!stack.isEmpty()) {
                copyMap[floorIdx--][i] = stack.pop(); // 아래칸부터 채워주기
            }
        }
    }

    static void breakBrick(Brick brick, int[][] copyMap) { // param: 첫 블록 좌표

        // 해당되는 블록을 시작으로 영향을 받는 블록을 담을 큐
        Queue<Brick> q = new ArrayDeque<>();

        // 시작 블록을 큐에 담아줌
        q.add(brick);

        while (!q.isEmpty()) {
            Brick selectB = q.poll(); // 선택된 블록
            int repeatCnt = selectB.value; // 얼마나 퍼질 수 있는지
            copyMap[selectB.y][selectB.x] = 0; // 자기 자신 지워줌

            // 1이 아니면 다른 곳에도 영향을 줌
            for (int i = 1; i < repeatCnt; i++) { // 해당 블록 value만큼 뻗어나가야 하므로
                for (int j = 0; j < 4; j++) { // 4방향으로
                    int ny = selectB.y + (my[j] * i); // 다음칸 좌표
                    int nx = selectB.x + (mx[j] * i);

                    // 범위 바깥으로 나가려고 하거나, 이미 0인친구면
                    if (!isPossible(ny, nx) || copyMap[ny][nx] == 0)
                        continue;

                    // 1 or 0이면 어차피 자기자신만 지워지므로 자신을 지우고 q에 들어가지 않음
                    if (copyMap[ny][nx] == 1) {
                        copyMap[ny][nx] = 0;
                        continue;
                    }

                    q.add(new Brick(ny, nx, copyMap[ny][nx]));
                }
            }
        }
    }

    static void repeatPerm(int depth, String str) { // 구슬 쏘는 위치 조합
        if (depth == N) {
            pushBall.add(str);
            return;
        }

        for (int i = 0; i < W; i++) { // 중복 순열
            repeatPerm(depth + 1, str + " " + i);
        }
    }

    // 마지막 남은 벽돌 세는 메서드
    static int extraCnt(int[][] copyMap) {
        int cnt = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (copyMap[i][j] != 0) // 0이 아닌 부분은 벽돌이므로
                    cnt++;
            }
        }

        return cnt;
    }

    // 좌표 밖으로 안나가는지 체크하는 메서드
    static boolean isPossible(int y, int x) {
        return (y >= 0 && y < H && x >= 0 && x < W);
    }

    static void deepCopy(int[][] copyMap) { // 깊은 복사
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
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
