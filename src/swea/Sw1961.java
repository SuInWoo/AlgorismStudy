package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw1961 {
    public static int[][] rotate(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotate = new int[m][n];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = arr[n-1-j][i];
            }
        }

        return rotate;
    }

    public static void print(int[][] arr90, int[][] arr180, int[][] arr270) {

        for (int i = 0; i < arr90.length; i++) {
            for (int j = 0; j < arr90.length; j++) {
                System.out.printf("%d", arr90[i][j]);
            }
            System.out.print(" ");
            for (int j = 0; j < arr180.length; j++) {
                System.out.printf("%d", arr180[i][j]);
            }
            System.out.print(" ");
            for (int j = 0; j < arr270.length; j++) {
                System.out.printf("%d", arr270[i][j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < str.length; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }

            System.out.printf("#%d\n", test);
            print(rotate(arr), rotate(rotate(arr)), rotate(rotate(rotate(arr))));

        }
    }
}
