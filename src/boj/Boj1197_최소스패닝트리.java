package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1197_최소스패닝트리 {

    static int V, E;
    static List<Edge>[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edgeList = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeList[a].add(new Edge(b, c));
            edgeList[b].add(new Edge(a, c));
        }

        // end input

        System.out.println(prim());

    }

    static int prim() {
        int ans = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(); // pq생성
        boolean[] visited = new boolean[V + 1]; // 방문 체크할 배열

        // PQ에 시작 Edge 넣기
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge se = pq.poll(); // 선택된 edge

            if (visited[se.v]) // 이미 방문한 정점이면 패스
                continue;

            visited[se.v] = true; // 방문했으니 check
            ans += se.w;

            for (Edge e : edgeList[se.v]) {
                if(!visited[e.v])
                    pq.add(e);
            }

        }
        return ans;
    }

    static class Edge implements Comparable<Edge> {
        int v; // 연결된 정점
        int w; // 가중치

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}
