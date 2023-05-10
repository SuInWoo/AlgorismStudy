package boj;

import java.util.Scanner;

public class Boj2475_검증수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            cnt += arr[i] * arr[i];
        }

        System.out.println(cnt%10);
    }
}
