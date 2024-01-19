package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj13164_행복유치원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] peoples = new int[N]; // 원생 키
        int[] groupCost = new int[N - 1]; // 인접한 두 명의 차이

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            groupCost[i - 1] = peoples[i] - peoples[i - 1];
        }

        // logic
        Arrays.sort(groupCost); // 정렬하여 코스트가 가장 낮은데로 묶을 준비
        int ans = 0;

        for (int i = 0; i < N - K; i++) { // N - K만큼
            ans += groupCost[i];
        }

        System.out.println(ans);

    }
}
