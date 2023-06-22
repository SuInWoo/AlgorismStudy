package boj_m6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15829_Hashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int M = 1234567891;
        long r = 1;
        long sum = 0;

        for (int i = 0; i < N; i++) {
            sum += ((s.charAt(i) - 'a' + 1) * r) % M;
            r = (r * 31) % M;
        }

        System.out.println(sum % M);
    }
}
