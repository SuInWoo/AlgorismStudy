package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15656_N과M_7 {

	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// end init

		sb = new StringBuilder();
		Arrays.sort(arr);
		comb(0, M, arr, "");

		System.out.println(sb);
	}

	static void comb(int depth, int M, int[] arr, String answer) {
		if(depth == M) {
			sb.append(answer.trim()).append("\n");
			return;
		}

		for (int i : arr) {
			comb(depth + 1, M, arr, answer + " " + i);
		}
	}
}
