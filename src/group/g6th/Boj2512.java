package group.g6th;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2512 {
    public static long solution(int[] arr, long budget, long sum) {
        if (budget > sum) {
            return arr[arr.length-1];
        } else {
            long startBud = 0;
            long endBud = arr[arr.length-1];
            while (startBud <= endBud) {
                long compareBud = 0;
                long midBud = (startBud + endBud) / 2;

                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] > midBud) compareBud += midBud;
                    else compareBud += arr[i];
                }

                if (compareBud <= budget)
                    startBud = midBud + 1;
                else
                    endBud = midBud - 1;
            }
            return endBud;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        long budget;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        budget = sc.nextLong();

        Arrays.sort(arr);

        System.out.println(solution(arr, budget, sum));

    }
}
