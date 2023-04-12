package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14500_테트로미노 {

	static int N, M, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] my = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] mx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// end input

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true; // 시작점 방문하고 시작
				dfs(i, j, 0, 0); // 시작 좌표, 합, 깊이
				fy(i, j);
				visited[i][j] = false;
			}
		}

		System.out.println(ans);
	}

	static void dfs(int cy, int cx, int sum, int depth) {

		if (depth == 4) { // 4개 갔으면
			ans = Math.max(ans, sum);
			return;
		}

		// 사방 탐색
		for (int i = 0; i < 4; i++) {
			int ny = cy + my[i];
			int nx = cx + mx[i];

			if (isCheck(ny, nx) && !visited[ny][nx]) {
				visited[ny][nx] = true;
				dfs(ny, nx, sum + map[cy][cx], depth + 1);
				visited[ny][nx] = false;
			}
		}
	}

	static void fy(int cy, int cx) {

		if (isCheck(cy + 1, cx) && isCheck(cy + 1, cx + 1) && isCheck(cy + 2, cx)) {
			int sum = map[cy][cx] + map[cy + 1][cx] + map[cy + 1][cx + 1] + map[cy + 2][cx];
			ans = Math.max(ans, sum);
		}

		if (isCheck(cy, cx + 1) && isCheck(cy + 1, cx + 1) && isCheck(cy, cx + 2)) {
			int sum = map[cy][cx] + map[cy][cx + 1] + map[cy + 1][cx + 1] + map[cy][cx + 2];
			ans = Math.max(ans, sum);
		}

		if (isCheck(cy + 1, cx) && isCheck(cy + 1, cx - 1) && isCheck(cy + 2, cx)) {
			int sum = map[cy][cx] + map[cy + 1][cx] + map[cy + 1][cx - 1] + map[cy + 2][cx];
			ans = Math.max(ans, sum);
		}

		if (isCheck(cy, cx + 1) && isCheck(cy, cx + 2) && isCheck(cy - 1, cx + 1)) {
			int sum = map[cy][cx] + map[cy][cx + 1] + map[cy][cx + 2] + map[cy - 1][cx + 1];
			ans = Math.max(ans, sum);
		}

	}

	static boolean isCheck(int ny, int nx) {
		return ny >= 0 && ny < N && nx >= 0 && nx < M;
	}
}