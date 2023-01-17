package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2587 {

    public static int avg(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum/arr.length;
    }

    public static int mid(int[] arr) {
        Arrays.sort(arr);

        return arr[2];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.printf("%d\n%d", avg(arr), mid(arr));

    }
}
