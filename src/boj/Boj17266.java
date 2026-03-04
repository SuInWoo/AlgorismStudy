package boj;

import java.util.*;
import java.io.*;

public class Boj17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] x = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        // 각각의 가로등 위치사이 간격의 최대값을 구하기
        int maxDist = x[0];

        for (int i = 1; i < M; i++) {
            int dist = (x[i] - x[i-1] + 1) / 2;
            if (maxDist < (dist)) {
                maxDist = dist;
            }
        }

        // 최대값 구한 후 마지막을 비출 수 있는지 구하기
        maxDist = Math.max(maxDist, N - x[M-1]);

        System.out.println(maxDist);
    }
}
