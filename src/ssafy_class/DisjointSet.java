package ssafy_class;

import java.util.Arrays;

public class DisjointSet {
	static int[] disjoint;
	static int N;

	public static void main(String[] args) {
		N = 10;
		makeSet();
		
		System.out.println(Arrays.toString(disjoint));

		/*
		 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

			union(1, 2);
			[0, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10]

			union(3, 4);
			[0, 2, 2, 4, 4, 5, 6, 7, 8, 9, 10]

			union(5, 6);
			[0, 2, 2, 4, 4, 6, 6, 7, 8, 9, 10]

			union(1, 3);
			[0, 2, 4, 4, 4, 6, 6, 7, 8, 9, 10]

			union(2, 5);
			[0, 2, 4, 4, 6, 6, 6, 7, 8, 9, 10]

			union(9, 3);
			[0, 2, 4, 4, 6, 6, 6, 7, 8, 6, 10]

			union(7, 10);
			[0, 2, 4, 4, 6, 6, 6, 10, 8, 6, 10]

			union(7, 1);
			[0, 2, 4, 4, 6, 6, 6, 10, 8, 6, 6]

		 */
		union(1, 2);
		union(3, 4);
		union(5, 6);
		union(1, 3);
		union(2, 5);
		union(9, 3);
		union(7, 10);
		union(7, 1);

		System.out.println(Arrays.toString(disjoint));
	}

	static void makeSet() { // 모든 애들이 각각 1인팀이라 모두가 팀장
		disjoint = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			disjoint[i] = i;
		}
	}

	static int find(int i) {
		if (i == disjoint[i]) // disjoint[5] 칸에 5라고 들어있으면 얘는 대표임
			return i;
		else // disjoint[4]번 칸에 5라고 들어있었어. 그러면 5를 집어넣고 다시 find(5)함
			return disjoint[i] = find(disjoint[i]);
	}

	static boolean union(int n1, int n2) {
		int p1 = find(n1); // n1이 소속된 그룹의 대표를 일단 찾아라(말단끼리 합병을 어케함.)
		int p2 = find(n2); // n2 대표찾기
		
		if(p1 == p2)
			return false; // 이미 대표가 설정되어있음

		disjoint[p1] = p2; // p1이 대표라 p1칸에 p1이라고 적혀있었을텐데 p2로 바꾼거니까 p1은 대표해임
		return true; // 방금 설정했어
	}
}
