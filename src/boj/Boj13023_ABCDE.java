package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj13023_ABCDE {

	static List<Integer>[] nums;
	static boolean[] visited;
	static int N, M, ans; // 사람 수, 친구 관계 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			nums[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			nums[a].add(b);
			nums[b].add(a);

		}

		// end input

		

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			search(i, 0);
		}

		System.out.println(ans);
	}

	static boolean search(int friendA, int connect) {

		visited[friendA] = true;

		if (connect == 4) {
			ans = 1;
			return true;
		}

		List<Integer> aList = nums[friendA];
		for (int i = 0; i < aList.size(); i++) {
			if (visited[aList.get(i)])
				continue;

			boolean rnt = search(aList.get(i), connect + 1);
			visited[aList.get(i)] = false;
			
			if(rnt)
				return true;
		}
		return false;
	}

}