package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw1959 {

    public static boolean check(String[][] arr) {

        for (int i = 0; i < 9; i++) {
            boolean[] checkArr1 = new boolean[9];
            boolean[] checkArr2 = new boolean[9];

            // 가로
            for (int j = 0; j < 9; j++) {
                int idx = Integer.parseInt(arr[i][j]) - 1;

                if (checkArr1[idx])
                    return false;

                checkArr1[idx] = true;
            }

            // 세로
            for (int j = 0; j < 9; j++) {
                int idx = Integer.parseInt(arr[j][i]) - 1;

                if (checkArr2[idx])
                    return false;

                checkArr2[idx] = true;
            }
        }

        // 박스 체크
        for (int i = 0; i <= 6; i+=3) { // 행
            for (int j = 0; j <= 6; j+=3) { // 열
                boolean[] checkArr3 = new boolean[9];

                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        int idx = Integer.parseInt(arr[k][l]) - 1;

                        if (checkArr3[idx])
                            return false;

                        checkArr3[idx] = true;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {

            int rnt = 1;
            String[][] input = new String[9][9];

            for (int i = 0; i < 9; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < 9; j++) {
                    input[i][j] = str[j];
                }
            }

            if (!check(input))
                rnt = 0;

            System.out.printf("#%d %d\n", t, rnt);
        }
    }
}
