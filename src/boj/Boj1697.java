package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1697 {

	static int N, K;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		visited = new boolean[100001];

		System.out.println(bfs());

	}

	static int bfs() {
		Queue<Integer> q = new LinkedList<>();

		// 시작지점을 큐에 넣기
		q.add(N);
		visited[N] = true; // 방문 표시

		int depth = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int currentX = q.poll();

				if (currentX == K) {
					return depth;
				}

				// x+1
				if ((currentX + 1) <= 100000 && !visited[currentX + 1]) {
					visited[currentX + 1] = true;
					q.add(currentX + 1);
				}

				// x-1
				if ((currentX - 1) >= 0 && !visited[currentX - 1]) {
					visited[currentX - 1] = true;
					q.add(currentX - 1);
				}

				// 2*x
				if ((2 * currentX) <= 100000 && !visited[2 * currentX]) {
					visited[2 * currentX] = true;
					q.add(2 * currentX);
				}
			}
			depth++;

		}

		return -1;
	}
}