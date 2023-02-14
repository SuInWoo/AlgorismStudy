package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2493 {
    static int N;
    static Stack<Integer> wall;
    static Stack<Integer> wallIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        wall = new Stack<>();
        wallIdx = new Stack<>();

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // end input

        for (int i = 1; i <= N; i++) {
            while (!wall.isEmpty()) {
                if (arr[i] > wall.peek()) { // 나보다 작은 것들은 다 제거
                    wall.pop();
                    wallIdx.pop();
                } else { // 나보다 큰애만나면 출력
                    sb.append(wallIdx.peek() + " ");
                    break;
                }
            }
            if (wall.isEmpty()) // 다돌았는데 비어있으면 나보다 큰애가 없으므로 0 출력
                sb.append("0 ");

            wall.push(arr[i]); // 나 넣기
            wallIdx.push(i);
        }

        // print
        System.out.println(sb.toString());

    }
}