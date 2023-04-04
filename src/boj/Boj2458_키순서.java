package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2458_키순서 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		} // end input
		
		int[][] dist = new int[N+1][N+1];
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(i == j)
					dist[i][j] = 0;
				else if(map[i][j] == 1) {
					dist[i][j] = 1;
				} else {
					dist[i][j] = 10_000_000;
				}
			}
		}

		
		for (int i = 1; i < N+1; i++) { // 경
			for (int j = 1; j < N+1; j++) { // 출
				for (int k = 1; k < N+1; k++) { // 도
					dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
				}
			}
		}

		int answer = 0;

		for (int i = 1; i < N+1; i++) {
			boolean flag = true;
			for (int j = 1; j < N+1; j++) {
				if (i == j || dist[i][j] != 10_000_000 || dist[j][i] != 10_000_000)
					continue;
				flag = false;
				break;

			}
			if (flag)
				answer++;
		}
		System.out.println(answer);
		
	}
}