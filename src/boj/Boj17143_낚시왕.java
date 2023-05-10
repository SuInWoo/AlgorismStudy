package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17143_낚시왕 {

    static int R, C, M, rnt;
    static Shark[][] map, copyMap;
    static int[] my = {0, -1, 1, 0, 0};
    static int[] mx = {0, 0, 0, 1, -1};

    static class Shark {
        int r, c, s, d, z; // 위치, 속력, 이동방향(1위2아래3오른4왼), 크기

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R + 1][C + 1];
        copyMap = new Shark[R + 1][C + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Shark s = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            map[s.r][s.c] = s;
        }

//        printArr();

        for (int i = 1; i < C + 1; i++) { // 낚시꾼 움직이기

            // 1. shark 잡기
//            System.out.println("몇초:" + i);
            catchShark(i);

            // 2. 상어 이동
            moveShark();

            // 3. map에 copyMap 깊은 복사
            deepCopy();

            // 디버깅 출력
//            printArr();

        }

        System.out.println(rnt);
    }

//    static void printArr() {
//        for (int i = 1; i < R + 1; i++) {
//            for (int j = 1; j < C + 1; j++) {
//                if (map[i][j] != null)
//                    System.out.print(map[i][j].z + "\t");
//                else
//                    System.out.print(map[i][j] + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println("====Map");
//    }

    static void moveShark() {
        copyMap = new Shark[R + 1][C + 1];
        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                if (map[i][j] != null) { // 상어를 찾았으면 -> 1초
                    // 해당 타겟
                    Shark target = map[i][j];

                    // 현재 타겟 상어 정보
                    int y = target.r;
                    int x = target.c;
                    int s = target.s;

                    while (s != 0) {
                        int ny = y + my[target.d];
                        int nx = x + mx[target.d];

                        // 이동 가능 한가?
                        if (isMove(ny, nx)) {
                            if (target.d % 2 == 0) // 방향이 짝수면
                                target.d -= 1;
                            else
                                target.d += 1;

                            continue; // 방향만 바꿔주고 움직이지 않고 움직이기 위해 continue
                        }

                        // 좌표 바꿔주고 속력 줄이기
                        y = ny;
                        x = nx;
                        s--;
                    }

                    target.r = y;
                    target.c = x;
                    if (copyMap[y][x] != null) {
                        if (copyMap[y][x].z < target.z) {
                            copyMap[y][x] = target;
                        }
                    } else {
                        copyMap[y][x] = target;
                    }

                }
            }
        }
    }

    static void catchShark(int i) { // i는 x좌표, y좌표가 제일 작은거 먹어야함
        for (int j = 1; j < R + 1; j++) {
            if (map[j][i] != null) {
//                System.out.println("먹은 상어 크기" + map[j][i].z);
                rnt += map[j][i].z;
                map[j][i] = null;
                return;
            }
        }
    }

    static void deepCopy() {
        map = new Shark[R + 1][C + 1];
        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                map[i][j] = copyMap[i][j];
            }
        }
    }

    static boolean isMove(int ny, int nx) { // 이동 불가하면 true, 이동 가능하면 false
        return ny < 1 || ny >= R + 1 || nx < 1 || nx >= C + 1;
    }
}