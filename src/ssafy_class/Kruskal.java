package ssafy_class;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E;
	static Edge[] edgeList;
	static int[] parents;

	static void makeSet() {
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (a == parents[a])
			return a;

		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot) // 싸이클 생겨서 유니온 안함
			return false;

		parents[bRoot] = aRoot; // 유니온

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();

		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(edgeList);

		makeSet();

		int rnt = 0;
		int cnt = 0;

		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				rnt += edge.weight;
				if(++cnt == V-1)
					break;
			}
		}
		
		System.out.println(rnt);
	}
}
