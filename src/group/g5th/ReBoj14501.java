package group.g5th;

/*
    퇴사 (최대 P(i)의 합 구하기)
    T(i) 3   5   1   1   2   4   2
    P(i) 10 20  10  20  15  40  200

    풀이방법
    1. 날이 지나갈수록 선택했을때랑 선택하지 않았을 때 두가지로 분류하여 계산
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReBoj14501 {

    static int max;
    static int[] t;
    static int[] p;

    public static void maxPoint(int start, int sum) {
        if (start == t.length && sum>max)
            max = sum;
        for (int i = start; i < t.length; i += t[i]) {

            if (sum > max) max = sum;
            //select
            maxPoint((i+t[i]), sum+p[i]);
            //non-select
            maxPoint((i+1), sum);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        t = new int[N];
        p = new int[N];
        max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        maxPoint(0, 0);

        System.out.println(max);
    }
}
