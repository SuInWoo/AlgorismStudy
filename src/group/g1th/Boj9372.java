package group.g1th;

import java.io.*;
import java.util.*;

public class Boj9372 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, M;

        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                br.readLine();
            }
            System.out.println(N-1);
            T--;
        }
    }
}