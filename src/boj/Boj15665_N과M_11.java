package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Boj15665_N과M_11 {

	static LinkedHashSet<String> lhs;

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

		lhs = new LinkedHashSet<>();
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		seq(0, M, "", arr);

		for (String s: lhs) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);
	}

	static void seq(int depth, int M, String answer, int[] arr) {
		if(depth == M) {
			lhs.add(answer.trim());
			return;
		}

		for(int i = 0; i < arr.length; i++) {
			seq(depth + 1, M, answer + " " + arr[i], arr);
		}
	}
}
