package programmers;

import java.util.*;

class P_전령망을둘로나누기 {
    static ArrayList<Integer>[] adj;

    public int solution(int n, int[][] wires) {
        int answer = n; // 최대 차이는 n을 넘을 수 없음

        // 1. 인접 리스트로 그래프 구성
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            adj[wire[0]].add(wire[1]);
            adj[wire[1]].add(wire[0]);
        }

        // 2. 모든 간선을 하나씩 끊어보기 (완전 탐색)
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            // v1에서 시작하되, v2 방향으로는 가지 않음 (간선을 끊은 효과)
            int count = bfs(v1, v2, n);

            // 3. 두 전력망의 차이 계산 (|한쪽 개수 - 반대쪽 개수|)
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    public int bfs(int start, int blocked, int n) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        dq.offer(start);
        visited[start] = true;
        int cnt = 1;

        while (!dq.isEmpty()) {
            int curr = dq.poll();

            for (int next : adj[curr]) {
                // 끊긴 지점(blocked)이 아니고, 방문하지 않았다면 탐색 계속
                if (next != blocked && !visited[next]) {
                    visited[next] = true;
                    dq.offer(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
