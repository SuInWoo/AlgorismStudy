package boj_m6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11050_이항계수1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(f(a) / (f(a - b) * f(b)));
    }

    static int f(int num) {
        if (num <= 1)
            return 1;

        return num * f(num - 1);
    }
}
