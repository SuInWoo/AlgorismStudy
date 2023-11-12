package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15654_N과M_5 {
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[N];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        perm(0, "", M);

        System.out.println(sb);
    }

    static void perm(int depth, String answer, int m) {
        if(depth == m) {
            sb.append(answer).append("\n");
        }

        for(int i = 0; i < arr.length; i++) {
            if(visited[i])
                continue;

            visited[i] = true;
            perm(depth + 1, answer + Integer.toString(arr[i]) + " ", m);
            visited[i] = false;
        }

    }
}
