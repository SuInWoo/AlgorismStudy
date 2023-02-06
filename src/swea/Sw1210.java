package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw1210 {
    static int ANS = 0;
    static int[] X = new int[]{-1, 0, 0}; //상, 좌, 우
    static int[] Y = new int[]{0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            int endX = 0; // 출구의 x idx
            int endY = 0; // 출구의 y idx
            int[][] map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) { // 2인곳이 출구이므로
                        endX = i;
                        endY = j;
                    }
                }
            }
            // end input

            search(map, endX, endY);
            System.out.printf("#%d %d\n", tc, ANS);
        }
    }

    private static void search(int[][] map, int endX, int endY) {

        while (endX != 0) { // 입구 x좌표에 도달할 때 까지 찾기
            for (int i = 0; i < 3; i++) {
                int dx = endX + X[i]; // 이동할 좌표
                int dy = endY + Y[i];

                if (dx >= 0 && dx < 100 && dy >= 0 && dy < 100 && map[dx][dy] == 1) {
                    map[endX][endY] = -1; // boolean visited 변수 대신 -1 값을 넣어서 다시 방문하지 않도록 설정
                    endX = dx;
                    endY = dy;
                }
            }
        }
        ANS = endY; // x 인덱스가 0에 도착했을때의 y 인덱스값이 입구 map[x][y]
    }
}
