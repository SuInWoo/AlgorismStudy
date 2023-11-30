package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Boj15663_N과M_9_set {
	static LinkedHashSet<String> lhs;
	static boolean[] visited;

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

		lhs = new LinkedHashSet<>();
		visited = new boolean[N];
		Arrays.sort(arr); // 사전 순으로 증가하는 순서로 출력하기 위해 정렬
		seq(0, M, "", arr);

		StringBuilder sb = new StringBuilder(); // sout을 한 번만 쓰기 위해 StringBuilder 사용

		for (String lh : lhs)
			sb.append(lh).append("\n");

		System.out.println(sb);
	}

	static void seq(int depth, int M, String answer, int[] arr) {
		if (depth == M) {
			lhs.add(answer.trim()); // 결과가 될 String
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if(visited[i]) // 중복된 자기자신은 빼기 위해 방문 체크
				continue;

			visited[i] = true;
			seq(depth+1,M,answer + " " + arr[i], arr);
			visited[i] = false;
		}
	}
}
