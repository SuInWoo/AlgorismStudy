package ssafy_class;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int[][] adjMatrix = new int[V][V]; // from - to

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// end input

		final int INF = Integer.MAX_VALUE;
		int[] distance = new int[V]; // 출발 정점에서 자신까지 오는 최소비용
		boolean[] visited = new boolean[V]; // 경유지로 고려된 정점여부

		Arrays.fill(distance, INF); // 최소값 갱신 로직을 반영해야하므로 큰값으로 초기화
		distance[start] = 0; // 출발지는 0으로 변경

		int min, current;
		for (int c = 0; c < V; c++) { // 모든 정점 확인

			// step 1. : 경유지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
			min = INF;
			current = -1;

			for (int i = 0; i < V; i++) {
				if (!visited[i] && min > distance[i]) { // 정점은 방문 안했지만, 인접한 친구랑 거리는 갱신하였음
					min = distance[i];
					current = i;
				}
			}

			if (current == -1) // 경유지가 안되면
				break;

			visited[current] = true; // 경유지 처리
			
//			// 선택된 정점이 문제에서 요구하는 도착정점이면 끝내기
//			if(current == end) 
//				break;
			

			// step 2. : 위에서 선택된 정점을 경유지로 해서 갈 수 있는 다른 인접 정점과의 비용 최소값 갱신
			for (int i = 0; i < V; i++) {
				// 방문안한 정점이고, 현재 정점과 연결되어있고, 경유해서 가는게 다이렉트로 가는것보다 빠르면
				if (!visited[i] && adjMatrix[current][i] != 0 && distance[i] > min + adjMatrix[current][i]) {
					distance[i] = min + adjMatrix[current][i]; // 갱신
				}

			}

		}

		System.out.println(distance[end] != INF ? distance[end] : -1);
	}
}
