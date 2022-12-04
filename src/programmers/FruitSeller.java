package programmers;

import java.util.Arrays;

public class FruitSeller {
    public static int solution(int k, int m, int[] score) {
        int ans = 0;

        Arrays.sort(score);

        int cnt = 0;
        int low = k;
        for (int i = score.length-1; i >= 0; i--) {
            cnt++;
            if (score[i] < low)
                low = score[i];

            if (cnt == m) {
                cnt = 0;
                ans += (low * m);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[]{4,1,2,2,4,4,4,4,1,2,4,2}));
    }
}
