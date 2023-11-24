package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15657_N과M_8 {

	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// end init

		sb = new StringBuilder();
		Arrays.sort(arr);

		comb(0, M, arr, "",0);

		System.out.println(sb);
	}

	static void comb(int depth, int M, int[] arr, String answer, int currentIdx) {
		if(depth == M) {
			sb.append(answer.trim()).append("\n");
			return;
		}

		for (int i = currentIdx; i < arr.length; i++) {
			comb(depth+1, M, arr, answer + " " + arr[i], i);
		}
	}
}
