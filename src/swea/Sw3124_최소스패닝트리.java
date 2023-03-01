package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sw3124_최소스패닝트리 {

    static int[] set; // 서로소 집합 배열
    static int V, E; // 정점 수, 간선 수
    static Edge[] edgeList;

    static class Edge implements Comparable<Edge> {
        int start; // 시작 정점
        int end; // 끝 정점
        int weight; // 비용

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) { // 오름차순 정렬을 위한
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            edgeList = new Edge[E]; // 엣지를 담을 리스트 초기화

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                edgeList[i] = new Edge(Integer.parseInt(st.nextToken()) - 1,
                        Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(edgeList); // 비용 순으로 정렬

            makeSet(); // 서로소 집합 부모 셋팅

            long ans = 0;
            for (Edge e : edgeList) {
                if (union(e.start, e.end)) { // 두 정점의 대표가 같지 않으면
                    ans += e.weight; // 비용 추가
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static boolean union(int p1, int p2) {
        p1 = find(p1);
        p2 = find(p2);

        if (p1 == p2) // 대표가 같으면 false
            return false;

        // 같지 않으면 true
        set[p2] = p1;
        return true;
    }

    static int find(int v) {
        if (v == set[v]) // 너가 대표니?
            return v;

        return set[v] = find(set[v]); // 너 대표 찾자
    }

    static void makeSet() {
        set = new int[V];

        for (int i = 0; i < V; i++) { // 자기 자신으로 대표값 세팅
            set[i] = i;
        }
    }

}