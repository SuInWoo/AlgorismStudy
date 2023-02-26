package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15683 {

    static int N, M, min; // 세로, 가로
    static ArrayList<CCTV> cctvList;
    static int[] my = {0, 1, 0, -1}; //우 하 좌 상
    static int[] mx = {1, 0, -1, 0};

    static class CCTV {
        int type; // cctv 타입(1,2,3,4)
        int y; // 좌표
        int x;

        public CCTV(int type, int y, int x) {
            this.type = type;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        cctvList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) { // cctv이면
                    cctvList.add(new CCTV(map[i][j], i, j));
                }
            }
        }

        // end input

        min = Integer.MAX_VALUE;
        watch(0, map);

        System.out.println(min);
    }

    static void watch(int cctvCnt, int[][] map) {
        if (cctvCnt == cctvList.size()) { // 다 검사했으면
            // 사각지대 체크
            checkZeroArea(map);
            return;
        }

        CCTV select = cctvList.get(cctvCnt);
        int type = select.type;
        int y = select.y;
        int x = select.x;
        int[][] copyMap;
        switch (type) {
            case 1: // 0 - 1 - 2 - 3
                copyMap = copyArr(map);
                run(y, x, 0, copyMap);
                watch(cctvCnt + 1, copyMap);

                copyMap = copyArr(map);
                run(y, x, 1, copyMap);
                watch(cctvCnt + 1, copyMap);

                copyMap = copyArr(map);
                run(y, x, 2, copyMap);
                watch(cctvCnt + 1, copyMap);

                copyMap = copyArr(map);
                run(y, x, 3, copyMap);
                watch(cctvCnt + 1, copyMap);
                break;

            case 2: // 0,2 - 1,3
                copyMap = copyArr(map);
                run(y, x, 0, copyMap);
                run(y, x, 2, copyMap);
                watch(cctvCnt + 1, copyMap);

                copyMap = copyArr(map);
                run(y, x, 1, copyMap);
                run(y, x, 3, copyMap);
                watch(cctvCnt + 1, copyMap);
                break;

            case 3: // 3,0 - 0,1 - 1,2 - 2,3
                copyMap = copyArr(map);
                run(y, x, 3, copyMap);
                run(y, x, 0, copyMap);
                watch(cctvCnt + 1, copyMap);

                copyMap = copyArr(map);
                run(y, x, 0, copyMap);
                run(y, x, 1, copyMap);
                watch(cctvCnt + 1, copyMap);

                copyMap = copyArr(map);
                run(y, x, 1, copyMap);
                run(y, x, 2, copyMap);
                watch(cctvCnt + 1, copyMap);

                copyMap = copyArr(map);
                run(y, x, 2, copyMap);
                run(y, x, 3, copyMap);
                watch(cctvCnt + 1, copyMap);
                break;

            case 4: // 2,3,0 - 3,0,1 - 0,1,2 - 1,2,3
                copyMap = copyArr(map);
                run(y, x, 2, copyMap);
                run(y, x, 3, copyMap);
                run(y, x, 0, copyMap);
                watch(cctvCnt + 1, copyMap);

                copyMap = copyArr(map);
                run(y, x, 3, copyMap);
                run(y, x, 0, copyMap);
                run(y, x, 1, copyMap);
                watch(cctvCnt + 1, copyMap);

                copyMap = copyArr(map);
                run(y, x, 0, copyMap);
                run(y, x, 1, copyMap);
                run(y, x, 2, copyMap);
                watch(cctvCnt + 1, copyMap);

                copyMap = copyArr(map);
                run(y, x, 1, copyMap);
                run(y, x, 2, copyMap);
                run(y, x, 3, copyMap);
                watch(cctvCnt + 1, copyMap);
                break;

            case 5: // 0,1,2,3
                copyMap = copyArr(map);
                run(y, x, 0, copyMap);
                run(y, x, 1, copyMap);
                run(y, x, 2, copyMap);
                run(y, x, 3, copyMap);
                watch(cctvCnt + 1, copyMap);
                break;
        }
    }

    static void run(int sy, int sx, int direction, int[][] copyMap) {
        int ny = sy;
        int nx = sx;
        while (true) {
            ny = ny + my[direction]; // 이동할 칸
            nx = nx + mx[direction];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M)
                break;

            if (copyMap[ny][nx] == 6) // 벽을 만나면 종료
                break;

            if (copyMap[ny][nx] != 0)
                continue;

            copyMap[ny][nx] = -1; // 감시된 곳은 -1로 변경
        }
    }

    static int[][] copyArr(int[][] map) { // 기존 지도 복사
        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        return copyMap;
    }

    static void checkZeroArea(int[][] copyMap) {
        int zeroCnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0)
                    zeroCnt++;
            }
        }

        min = Math.min(min, zeroCnt);
    }

}
