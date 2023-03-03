package ssafy_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_PQ {
	
	static int N;
	static int[][] adjArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		adjArr = new int[N][N]; // from - to

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adjArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dijkstra(start, end));
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N]; // 어떤 정점까지의 최소비용이 나왔는지 기록하는 배열
		
		pq.add(new Edge(0, start)); // 출발점을 영입하는데 드는 비용은 0원
		
		
		while(!pq.isEmpty()) {
			Edge minEdge = pq.poll(); // 현재 확보한 간선중 가장 짧은 간선이 나옴(끝에 정점 매달려있음)
			
			if(visited[minEdge.num]) // 얘는 최소비용 이미 기록되었던 애야(새로운 정점아님)
				continue;
			
			// 내가 현재 새로 영입할 수 있는 애들중엔 가장 저렴(비용 확실함 기록!)
			visited[minEdge.num] = true;
			if(minEdge.num == end)
				return minEdge.weight;
			
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjArr[minEdge.num][i] > 0) {
					pq.add(new Edge(minEdge.weight + adjArr[minEdge.num][i], i));
				}
			}
		}
		
		return -1; // 다 돌았는데 내가 찾으려는 정점이 안보이면 -1 반환
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
