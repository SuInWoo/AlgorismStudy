package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * map 부분에서 이동 및 서치가 가능한부분은 0, 불가능한 부분은 -1, 사과는 1
 */
public class Solution {

	static int N, ans; // 지도 크기, 정답(최소 회전 수)
	static int[][] map; // 지도
	static ArrayList<Apple> apples;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// start input

		int TC = Integer.parseInt(br.readLine()); // 테스트 케이스 받기
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine()); // 지도 크기
			map = new int[N][N]; // 지도 초기화
			apples = new ArrayList<>(); // 사과 객체
			ans = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {

					map[i][j] = Integer.parseInt(st.nextToken());
					int in = map[i][j];

					if (in != 0) { // 사과이면 사과 번호맞게 넣기
						apples.add(new Apple(i, j, in));
					}
				}
			}

			// end input

			// start logic

			Collections.sort(apples);
			int sy = 0;
			int sx = 0;
			int dir = 0; // 우, 하, 좌, 상(0, 1, 2, 3)
			for (int i = 0; i < apples.size(); i++) {
				Apple selectApple = apples.get(i);
				int ay = selectApple.y;
				int ax = selectApple.x;

				if (dir == 0) {
					if (sy < ay && sx < ax) {
						ans += 1;
						dir = (dir + 1) % 4;
					} else if (sy < ay && sx > ax) {
						ans += 2;
						dir = (dir + 2) % 4;
					} else if (sy > ay && sx < ax) {
						ans += 3;
						dir = (dir + 3) % 4;
					} else {
						ans += 3;
						dir = (dir + 3) % 4;
					}
					
				} else if (dir == 1) {
					if (sy < ay && sx < ax) {
						ans += 3;
						dir = (dir + 3) % 4;
					} else if (sy < ay && sx > ax) {
						ans += 1;
						dir = (dir + 1) % 4;
					} else if (sy > ay && sx < ax) {
						ans += 3;
						dir = (dir + 3) % 4;
					} else {
						ans += 2;
						dir = (dir + 2) % 4;
					}
					
				} else if (dir == 2) {
					if (sy < ay && sx < ax) {
						ans += 3;
						dir = (dir + 3) % 4;
					} else if (sy < ay && sx > ax) {
						ans += 3;
						dir = (dir + 3) % 4;
					} else if (sy > ay && sx < ax) {
						ans += 2;
						dir = (dir + 2) % 4;
					} else {
						ans += 1;
						dir = (dir + 1) % 4;
					}
				} else {
					if (sy < ay && sx < ax) {
						ans += 2;
						dir = (dir + 2) % 4;
					} else if (sy < ay && sx > ax) {
						ans += 3;
						dir = (dir + 3) % 4;
					} else if (sy > ay && sx < ax) {
						ans += 1;
						dir = (dir + 1) % 4;
					} else {
						ans += 3;
						dir = (dir + 3) % 4;
					}
				}
				
				sy = ay;
				sx = ax;

			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	// 사과 클래스
	static class Apple implements Comparable<Apple> {
		int y; // 좌표
		int x;
		int num; // 번호

		public Apple(int y, int x, int num) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
		}

		@Override
		public int compareTo(Apple o) {
			return this.num - o.num;
		}
	}
}