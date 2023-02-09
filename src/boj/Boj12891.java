package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12891 {
    static int[] passCnt; // A:0, C:1, G:2, T:3
    static int[] compareCnt;
    static int ans, S, P; // 비밀번호 종류 수, 문자열 길이, 비밀번호 길이
    static String str; // 문자열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        str = br.readLine();
        passCnt = new int[4];
        compareCnt = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            passCnt[i] = Integer.parseInt(st.nextToken());
        } // end input

        // 0~P까지 일단 시작 -> 기준 문자열 잡기
        for (int i = 0; i < P; i++) {
            plus(i);
        }

        check();
        int start = 0;
        int end = P;

        while (end != S) {
            plus(end);
            minus(start);
            check();
            end += 1;
            start += 1;
        }

        System.out.println(ans);
    }

    static void check() {
        if (passCnt[0] <= compareCnt[0] && passCnt[1] <= compareCnt[1] && passCnt[2] <= compareCnt[2]
                && passCnt[3] <= compareCnt[3]) {
            ans++;
        }
    }

    static void minus(int i) {
        char select = str.charAt(i);
        if (select == 'A') {
            compareCnt[0]--;
        } else if (select == 'C') {
            compareCnt[1]--;
        } else if (select == 'G') {
            compareCnt[2]--;
        } else if (select == 'T') {
            compareCnt[3]--;
        }
    }

    static void plus(int i) {
        char select = str.charAt(i);
        if (select == 'A') {
            compareCnt[0]++;
        } else if (select == 'C') {
            compareCnt[1]++;
        } else if (select == 'G') {
            compareCnt[2]++;
        } else if (select == 'T') {
            compareCnt[3]++;
        }
    }
}
