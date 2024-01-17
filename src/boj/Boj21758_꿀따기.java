package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj21758_꿀따기 {
    static long maxHoney = Long.MIN_VALUE;
    static long honeySum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // init
        int N = Integer.parseInt(br.readLine());
        long[] honeys = new long[N];
        long[] rightSum = new long[N];
        long[] leftSum = new long[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            honeys[i] = Long.parseLong(st.nextToken());
            honeySum += honeys[i];
            leftSum[i] = honeySum;
        }

        int sum = 0;
        for (int i = N - 1; i >= 0; i--) {
            sum += honeys[i];
            rightSum[i] = sum;
        }

        // logic

        // 1. 오른쪽 방향으로만 진행
        rightSide(honeys, leftSum);
        // 2. 왼쪽 방향으로만 진행
        leftSide(honeys, rightSum);
        // 3. 꿀벌 통 있는 쪽으로 진행
        bothSide(honeys, rightSum, leftSum);

        System.out.println(maxHoney);

    }

    static void rightSide(long[] honeys, long[] leftSum) {
        // 벌 왼쪽 고정, 벌꿀 통 오른쪽 고정
        long bee1 = 0;
        long bee2 = 0;

        // 움직이는 벌
        for (int i = 1; i < honeys.length - 1; i++) {
            bee1 = honeySum - honeys[0] - honeys[i];
            bee2 = honeySum - leftSum[i];
            maxHoney = Math.max(maxHoney, bee1 + bee2);
        }
    }

    static void leftSide(long[] honeys, long[] rightSum) {
        // 벌 오른쪽 고정, 벌꿀 통 왼쪽 고정
        long bee1 = 0;
        long bee2 = 0;

        // 움직이는 벌
        for (int i = 1; i < honeys.length - 1; i++) {
            bee1 = honeySum - honeys[honeys.length - 1] - honeys[i];
            bee2 = honeySum - rightSum[i];
            maxHoney = Math.max(maxHoney, bee1 + bee2);
        }
    }

    static void bothSide(long[] honeys, long[] rightSum, long[] leftSum) {
        long bee1 = 0;
        long bee2 = 0;

        for (int i = 1; i < honeys.length - 1; i++) {
            bee1 = leftSum[i] - honeys[0];
            bee2 = rightSum[i] - honeys[honeys.length - 1];
            maxHoney = Math.max(maxHoney, bee1 + bee2);
        }
    }
}
