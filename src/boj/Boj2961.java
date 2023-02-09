package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2961 {
    static int N, min;
    static int[][] ingredient;
    static boolean[] isSelected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        ingredient = new int[N][2]; // 0번 방은 신맛, 1번 방은 쓴맛
        isSelected = new boolean[N]; // 재료 방문 배열
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }
        // end input

        generateSubSet(0);

        System.out.println(min);
    }

    static void generateSubSet(int cnt) {

        if (cnt == N) {
            int sum = 0;
            int multiple = 1;
            int ingredCnt = 0; // 공집합 제거를 위한 변수
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) { // 방문 되어있는 재료들
                    ingredCnt++; // 쓴 재료 개수
                    sum += ingredient[i][1];
                    multiple *= ingredient[i][0];
                }
            }

            if(ingredCnt == 0) // 공집합이면 return;
                return;

            if (min > Math.abs(sum - multiple))
                min = Math.abs(sum - multiple);

            return;
        }

        isSelected[cnt] = true;
        generateSubSet(cnt + 1);
        isSelected[cnt] = false;
        generateSubSet(cnt + 1);
    }
}