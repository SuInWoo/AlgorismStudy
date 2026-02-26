package boj;

import java.io.*;
import java.util.*;

public class Boj10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int caseNum = Integer.parseInt(st.nextToken()); // 테스트 번호
            int[] arr = new int[20];
            int moveCount = 0;

            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                // 현재 학생(arr[i])보다 앞에 있으면서 키 큰 학생 수 세기
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[i]) {
                        moveCount++;
                    }
                }
            }

            sb.append(caseNum).append(" ").append(moveCount).append("\n");
        }

        System.out.print(sb);
    }
}
