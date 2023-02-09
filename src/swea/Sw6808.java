package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw6808 {
    static int[] kyuCard, inCard, rnt; // 규영이 카드, 인영이 카드, 결과
    static boolean[]  visited; // 방문 체크
    static int win, lose; // 이긴, 진  횟수



    public static void permutation (int cnt) { // 순열
        if (cnt == 9) { // 9장을 다가지면 비교해서 승부
            cal();
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (visited[i])
                continue;

            rnt[cnt] = inCard[i];
            visited[i] = true;
            permutation(cnt + 1);
            visited[i] = false;
        }
    }

    public static void cal() { // 점수 비교
        int scoreK = 0;
        int scoreI = 0;

        for (int i = 0; i < 9; i++) {
            if (kyuCard[i] > rnt[i])
                scoreK += kyuCard[i] + rnt[i];
            else if (kyuCard[i] < rnt[i])
                scoreI += kyuCard[i] + rnt[i];
        }

        if(scoreK > scoreI)
            win += 1;
        else if(scoreK < scoreI)
            lose += 1;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            kyuCard = new int[9];
            inCard = new int[9];
            boolean[] cardCheck = new boolean[19];

            for (int i = 0; i < kyuCard.length; i++) { // 규영이 카드 입력
                kyuCard[i] = Integer.parseInt(st.nextToken());
                cardCheck[kyuCard[i]] = true; // 규영이가 카드를 가져갔다고 저장
            }
            // end input

            int idx = 0;
            for (int i = 1; i < 19; i++) { // 인영이 카드
                if (!cardCheck[i]) // 규영이가 안가져갔으면 인영이가 가져감
                    inCard[idx++] = i;
            }

            rnt = new int[9]; // 결과를 받을 배열
            visited = new boolean[9]; // 방문 체크 배열
            win = 0;
            lose = 0;
            permutation(0);

            System.out.printf("#%d %d %d\n",t, win, lose);
        }
    }
}