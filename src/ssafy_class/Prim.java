package ssafy_class;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {
	static int V;
	static int[][] adjArr; // 인접 행렬

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		adjArr = new int[V][V];

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				adjArr[i][j] = sc.nextInt();
			}
		}

		int rnt = 0; // 전체 정점을 연결하는 총합 최소비용
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0)); // 시작 정점은 누가되는 상관없음. 어차피 모두가 연결될거라서. 처음 영업비는 0원
		boolean[] visited = new boolean[V]; // 이미 영입된 정점인지 체크용.

		int cnt = 0; // 내가 영입한 정점의 개수
		while (!pq.isEmpty() && cnt < V - 1) { // mst 불가능한 경우 있을까바 empty 체크
			Edge now = pq.poll(); // 방금 영입한 대상! pq에서는 제일 영업비용 싼에만 나옴

			if (visited[now.num]) // 간선 누적하다 보니 짧긴 한데 이미 우리편으로 영입한 애네? 이 간선은 제껴!
				continue;

			visited[now.num] = true; // 영입했다고 체크
			cnt++;
			rnt += now.weight; // 영입에 들어간 비용

			// 자 방금 영입한 애한테 친구를 데려오라고 하자
			for (int v = 0; v < V; v++) {
				if (!visited[v] && adjArr[now.num][v] > 0) { // 아직 영입하지 않은 친구 있니?
					pq.add(new Edge(adjArr[now.num][v], v));
				}
			}

		}
		System.out.println("전체 연결 최소비용 : " + rnt);
	}

	static class Edge implements Comparable<Edge> {
		int weight, num;

		public Edge(int weight, int num) {
			super();
			this.weight = weight;
			this.num = num;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}
