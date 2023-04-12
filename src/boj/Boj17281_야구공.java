package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj17281_야구공 {

    static int N, ans;
    static int[][] score;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        score = new int[N][9];
        visited = new boolean[9];
        arr = new int[9];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // end input

        arr[3] = 0;
        visited[3] = true;

        perm(1);
        gameStart();
        System.out.println(ans);
    }

    static int gameStart() {
        int atBat = 0; // 타석
        int sum = 0;

        // 총 이닝 수만큼 반복
        for (int n = 0; n < N; n++) {
            // 총 deathCnt 만큼 반복
            int deathCnt = 3;
            int[] base = new int[3]; // 1루, 2루, 3루

            while (deathCnt != 0) {
                int batter = arr[atBat % 9]; // 타자 꺼내고 타석 증가
                atBat++;

                int type = score[n][batter]; // 현재 타자 상태

                if (type == 0) { // 꺼낸 타자가 아웃이면
                    deathCnt--;
                } else if (type == 1) { // 안타이면
                    sum += base[2];
                    base[2] = base[1];
                    base[1] = base[0];
                    base[0] = 1;
                } else if (type == 2) { // 2루타
                    sum += base[2] + base[1]; // 3루, 2루 수는 홈으로
                    base[2] = base[0]; // 1루는 3루로
                    base[1] = 1; // 2루에 한명 넣기
                    base[0] = 0; // 1루는 비워야함
                } else if (type == 3) { // 3루타
                    sum += base[2] + base[1] + base[0]; // 1루, 2루, 3루는 홈으로
                    base[2] = 1; // 3루에 한명 나감
                    base[1] = 0;
                    base[0] = 0;
                } else { // 홈런
                    sum += base[2] + base[1] + base[0] + 1;
                    base = new int[3];
                }
            }
        }

        return sum;
    }

    static void perm(int batter) {
        if (batter == 9) {
            ans = Math.max(ans, gameStart());
            return;
        }

        for (int i = 0; i < 9; i++) { // 자리리번호
            if (visited[i])
                continue; // 넘어감

            visited[i] = true;
            arr[i] = batter;
            perm(batter + 1);
            visited[i] = false;
        }
    }
}
