package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[k];


        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }// init end

        Arrays.sort(arr);
        long s = 0; // 시작
        long mid = 0; // 중간값
        long e = arr[arr.length-1] + 1 ; // 끝

        while (s < e) {
            mid = (s + e) / 2;

            long sum = 0;

            for (int i = 0; i < arr.length; i++) {
                sum += (arr[i] / mid);
            }
            if (sum < n)
                e = mid;
            else
                s = mid + 1;
        }

        System.out.println(s-1);
    }
}