package group.g6th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2417 {
    public static long solution(long num) {
        long start = 0;
        long end = num;
        while (start <= end) {
            long mid = (start + end) / 2;
            long compareNum = (long) Math.pow(mid, 2);

            if (compareNum >= num)
                end = mid - 1;
            else
                start = mid + 1;

        }
        return end+1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());

        System.out.println(solution(num));

    }
}
