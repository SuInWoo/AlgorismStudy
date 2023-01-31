package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1449 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 1;
        int sum = 0;
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] pos = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < pos.length; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pos);

        for (int i = 1; i < pos.length; i++) {
            sum += pos[i] - pos[i - 1];

            if (sum + 1 > l) {
                cnt++;
                sum = 0;
            }
        }

        System.out.println(cnt);
    }
}
