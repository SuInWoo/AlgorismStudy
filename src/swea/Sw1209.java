package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw1209 {
    public static int MAX = Integer.MIN_VALUE;

    public static void plusLow(int[][] arr) {
        for (int i = 0; i < 100; i++) {
            int sum = 0;
            for (int j = 0; j < 100; j++) {
                sum += arr[i][j];
            }
            if (MAX < sum)
                MAX = sum;
        }
    }

    public static void plusColumn(int[][] arr) {
        for (int i = 0; i < 100; i++) {
            int sum = 0;
            for (int j = 0; j < 100; j++) {
                sum += arr[j][i];
            }
            if (MAX < sum)
                MAX = sum;
        }
    }

    public static void plusDiagonal(int[][] arr) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 100; i++) {

            sum1 += arr[i][i];
            sum2 += arr[i][99-i];

        }

        if (MAX < sum1)
            MAX = sum1;
        else if (MAX < sum2) {
            MAX = sum2;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 10;
        int[][] arr = new int[100][100];

        // input
        for (int i = 1; i <= tc; i++) {
            int test = Integer.parseInt(br.readLine());
            for (int j = 0; j < 100; j++) {
                String[] num = br.readLine().split(" ");
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = Integer.parseInt(num[k]);
                }
            }

            plusColumn(arr);
            plusLow(arr);
            plusDiagonal(arr);

            System.out.printf("#%d %d\n", test, MAX);
            MAX = Integer.MIN_VALUE;
        }


    }
}
