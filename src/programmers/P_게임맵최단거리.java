package programmers;

import java.util.*;

class P_게임맵최단거리 {
	static int[] my = {1, 0, -1, 0};
	static int[] mx = {0, 1, 0, -1};
	static boolean[][] visited;
	static int n, m;

	public int solution(int[][] maps) {
		visited = new boolean[maps.length][maps[0].length];
		n = maps.length;
		m = maps[0].length;
		int answer = bfs(0, 0, maps);

		return answer;
	}

	static int bfs(int y, int x, int[][] maps) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(y);
		q.offer(x);
		visited[y][x] = true;
		int cnt = 0;

		while(!q.isEmpty()) {
			cnt ++;
			int size = q.size();
			for(int j = 0; j < size/2; j++) {
				// 현재 위치 꺼내기
				int cy = q.poll();
				int cx = q.poll();

				// System.out.print("cnt: " + cnt + " cy: " + cy + " cx: " + cx);
				// System.out.println();

				visited[cy][cx] = true;

				// 종착지 인지 확인
				if(cy == n-1 && cx == m-1) {
					return cnt;
				}

				// 4방향 탐색
				for(int i = 0; i < 4; i++) {
					int ny = cy + my[i];
					int nx = cx + mx[i];

					if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx]
						|| maps[ny][nx] == 0)
						continue;

					q.offer(ny);
					q.offer(nx);
					visited[ny][nx] = true;
				}
			}

		}

		return -1;
	}
}