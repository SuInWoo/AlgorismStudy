package group.g6th;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1920 {
    public static int binarySearch(int[] sample, int key){
        int rnt = 0;
        int start = 0;
        int end = sample.length-1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (key == sample[mid]) {
                rnt = 1;
                return rnt;
            } else if (key < sample[mid]) { //key 숫자가 중앙 값보다 작으면
                end = mid - 1;
            } else
                start = mid + 1;    //key 숫자가 중앙 값보다 크면
        }

        return rnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] sample = new int[N];

        for (int i = 0; i < N; i++) {
            sample[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        Arrays.sort(sample);    // 정렬

        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(sample, sc.nextInt()));
        }
    }
}
