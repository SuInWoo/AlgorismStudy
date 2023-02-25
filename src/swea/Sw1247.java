package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw1247 {
	static int[] x, y;
	static boolean[] visited;
	static int hX, hY, cX, cY, N, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine()); // 고객 수
			st = new StringTokenizer(br.readLine());

			cX = Integer.parseInt(st.nextToken()); // 회사
			cY = Integer.parseInt(st.nextToken());
			hX = Integer.parseInt(st.nextToken()); // 집
			hY = Integer.parseInt(st.nextToken());

			x = new int[N];
			y = new int[N];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}

			// end input
			
			search(0, cX, cY, 0);

			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb);

	}

	static void search(int end, int selectX, int selectY, int sumD) {

		if (end == N) {
			// 마지막으로 집이랑 거리계산 후
			sumD += cal(hX, hY, selectX, selectY);
			min = Math.min(min, sumD);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				search(end + 1, x[i], y[i], (sumD + cal(selectX, selectY, x[i], y[i])));
				visited[i] = false;
			}
		}

	}

	static int cal(int x1, int y1, int x2, int y2) {

		return (int) (Math.abs(x1 - x2) + Math.abs(y1 - y2));

	}

}