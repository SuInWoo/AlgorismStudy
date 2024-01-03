package boj;

import java.util.Scanner;

public class Boj1080_행렬 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        // 입력
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            String temp = sc.next();

            for (int j = 0; j < m; j++) {
                a[i][j] = temp.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            String temp = sc.next();

            for (int j = 0; j < m; j++) {
                b[i][j] = temp.charAt(j) - '0';
            }
        }

        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (a[i][j] != b[i][j]) {
                    count++;
                    for (int p = i; p < i + 3; p++) {
                        for (int q = j; q < j + 3; q++) {
                            a[p][q] = (a[p][q] == 0) ? 1 : 0;
                        }
                    }
                }
            }
        }

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        System.out.println((flag) ? count : -1);

    }
}
