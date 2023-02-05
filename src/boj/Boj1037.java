package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1037 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ans = 0;
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        if(arr.length == 1)
            ans = arr[0]*arr[0];
        else {
            Arrays.sort(arr);
            ans = arr[0]*arr[arr.length-1];
        }

        System.out.println(ans);
    }

}
