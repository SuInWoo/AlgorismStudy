package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1182_부분수열의합 {
    static int cnt = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // input
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N]; // 수열 배열

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sumOfSubsequence(0,0,arr,S);

        if(S == 0) // 아무것도 선택하지 않았을 때, 0이 되는데 S가 0인경우 cnt가 올라가므로 -1 해줌
            cnt--;

        System.out.println(cnt);
    }

    static void sumOfSubsequence(int depth, int sum, int[] arr, int S) {
        if(depth == arr.length) {
            if(sum == S) { // 합이 같으면 cnt++
                cnt++;
            }
            return;
        }

        sumOfSubsequence(depth+1, sum, arr, S); // 안 더했을때
        sumOfSubsequence(depth+1, sum+arr[depth], arr, S); // 더했을때
    }
}
