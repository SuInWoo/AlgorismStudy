package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16987_계란으로계란치기 {

	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Egg[] eggs = new Egg[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// end init

		dfs(0, 0, eggs);

		System.out.println(result);
	}

	static void dfs(int depth, int breakEggCnt, Egg[] eggs) {
		// 마지막까지 도달 했을때
		if (depth == eggs.length) {
			result = Math.max(result, breakEggCnt);
			return;
		}

		if (eggs[depth].s <= 0 || breakEggCnt == eggs.length - 1) {// 달걀이 이미 깨져있다면
			dfs(depth + 1, breakEggCnt, eggs);
			return;
		}

		for (int i = 0; i < eggs.length; i++) { // 모든 달걀 부딪혀보기
			int hitCnt = 0;
			if (i == depth || eggs[i].s <= 0) // 손에 든거랑 같거나 이미 깨진 달걀은 패스
				continue;

			eggs[depth].s -= eggs[i].w;
			eggs[i].s -= eggs[depth].w;

			if (eggs[depth].s <= 0)
				hitCnt++;

			if (eggs[i].s <= 0)
				hitCnt++;

			dfs(depth + 1, breakEggCnt + hitCnt, eggs);

			eggs[depth].s += eggs[i].w;
			eggs[i].s += eggs[depth].w;
		}

	}

	static class Egg {
		int s; // 내구도
		int w; // 무게

		public Egg(int s, int w) {
			this.s = s;
			this.w = w;
		}
	}
}
