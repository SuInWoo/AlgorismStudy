package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {

            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int sum = 0; // 전체 수익을 저장할 변수

            // init
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            int standard = n / 2;
            int cnt = 0;
            boolean check = true;
            for (int i = 0; i < n; i++) { // i는 행
                sum += arr[i][standard];
                if (cnt <= standard && check) {
                    for (int j = 1; j <= cnt; j++) {
                        sum += arr[i][standard + j];
                        sum += arr[i][standard - j];
                    }
                    cnt++;
                } else {
                    check = false;
                    for (int j = 1; j < cnt-1; j++) {
                        sum += arr[i][standard + j];
                        sum += arr[i][standard - j];
                    }
                    cnt--;
                }

            }

            System.out.printf("#%d %d\n",test ,sum);
        }
    }
}
