package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj10807 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int v = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (String string : arr) {
            if(Integer.parseInt(string) == v)
                cnt++;
        }

        System.out.println(cnt);
    }
}
