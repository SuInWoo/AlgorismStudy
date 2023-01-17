package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj5597 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[31];

        for (int i = 1; i <= 28; i++) {
            int idx = Integer.parseInt(br.readLine());

            arr[idx] = true;
        }

        for (int i = 1; i < arr.length; i++) {
            if(!arr[i])
                System.out.println(i);
        }
    }
}
