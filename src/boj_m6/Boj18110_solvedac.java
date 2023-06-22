package boj_m6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Boj18110_solvedac {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 난이도 의견 개수
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) { // 입력받기
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums); // 정렬

        int except = (int) Math.round(n * 0.15); // 제외될 수 위 아래로 제외될 예정
        double cnt = n - (2 * except);
        double sum = 0;

        for (int i = except; i < n - except; i++) {
            sum += nums[i];
        }

        System.out.println((int)Math.round(sum / cnt));
    }
}
