package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int test = Integer.parseInt(br.readLine());
            int mode = 0;
            int modeIdx = 0;
            int[] arr = new int[101];
            String[] sNum = br.readLine().split(" ");

            for (int j = 0; j < 1000; j++) {
                arr[Integer.parseInt(sNum[j])]++;
            }

            for (int j = 0; j < arr.length; j++) {
                if (mode <= arr[j]) {
                    mode = arr[j];
                    modeIdx = j;
                }
            }

            System.out.printf("#%d %d\n", test, modeIdx);

        }
    }
}
