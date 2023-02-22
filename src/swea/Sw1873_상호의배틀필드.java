package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw1873_상호의배틀필드 {

    static char[][] map;
    static int H, W, cX, cY, cPattern;
    static int[] my = new int[]{-1, 1, 0, 0}; // 상 하 좌 우
    static int[] mx = new int[]{0, 0, -1, 1};
    static char[] pattern = new char[]{'^', 'v', '<', '>'};

    static void move(int cPatternNum) {
        int dy = cY + my[cPatternNum]; // 이동 위치
        int dx = cX + mx[cPatternNum];

        if (dy >= 0 && dy < H && dx >= 0 && dx < W && map[dy][dx] == '.') { // 다음으로 이동할 수 있으면
            map[dy][dx] = pattern[cPatternNum]; // 바라보는 방향 패턴으로 변경
            map[cY][cX] = '.'; // 원래 있던 자리 평지로
            cY = dy; // 현재 좌표 변경
            cX = dx;
        } else {
            map[cY][cX] = pattern[cPatternNum];
        }

        cPattern = cPatternNum; // 현재 전차가 바라보는 위치를 저장
    }

    static void shoot(int cPatternNum) {
        int tmpY = cY;
        int tmpX = cX;

        while (true) {
            tmpY += my[cPatternNum];
            tmpX += mx[cPatternNum];

            if (tmpY < 0 || tmpX < 0 || tmpY >= H || tmpX >= W || map[tmpY][tmpX] == '#') // 밖으로 나가면
                break;

            if (map[tmpY][tmpX] == '*') {
                map[tmpY][tmpX] = '.';
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken()); // 세로
            W = Integer.parseInt(st.nextToken()); // 가로
            cPattern = 0; // 시작 무늬

            map = new char[H][W]; // 지도

            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '^') { // 위 = 0
                        cY = i;
                        cX = j;
                    } else if (map[i][j] == 'v') { // 아래 = 1
                        cPattern = 1;
                        cY = i;
                        cX = j;
                    } else if (map[i][j] == '<') { // 왼쪽 = 2
                        cPattern = 2;
                        cY = i;
                        cX = j;
                    } else if (map[i][j] == '>') { // 오른쪽 = 3
                        cPattern = 3;
                        cY = i;
                        cX = j;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine()); // 명령어 수
            String str = br.readLine();
            int cnt = 0;

            while (cnt < N) {
                char order = str.charAt(cnt);
                switch (order) {
                    case 'U':
                        move(0);
                        break;
                    case 'D':
                        move(1);
                        break;
                    case 'L':
                        move(2);
                        break;
                    case 'R':
                        move(3);
                        break;
                    case 'S':
                        shoot(cPattern);
                        break;

                }
                cnt++;
            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }

}
