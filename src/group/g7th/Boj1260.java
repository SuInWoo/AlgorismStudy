package group.g7th;

import java.util.*;

public class Boj1260 {
    public static StringBuilder sb;
    public static void bfs(int start, boolean[] visited, List<ArrayList<Integer>> list) {  //Q 사용
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);   // 처음 방문한 정점을 큐에 넣어줌
        visited[start] = true;  // 방문했으니 visit

        while (!queue.isEmpty()) {
            int n = queue.poll();   // 첫번째 정점을 기준
            sb.append(String.format("%d ", n));

            for (int i = 0; i < list.get(n).size(); i++) {  // 첫번째 정점과 연결된 정점들을 모두 검사
                int next = list.get(n).get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

    }

    public static void dfs(int start, boolean[] visited, List<ArrayList<Integer>> list){

        if (visited[start]) return; //이미 방문한 정점이면 return

        visited[start] = true;  // 방문 시 visit 체크
        sb.append(String.format("%d ", start));

        for (int i = 0; i < list.get(start).size(); i++) {
            int next = list.get(start).get(i);
            if (!visited[next]) {   // 방문하지 않으면 그 정점을 기준으로 다시 dfs
                dfs(next, visited, list);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 정점 개수
        int m = sc.nextInt();   // 간선 개수
        int v = sc.nextInt();   // 시작 정점 번호
        boolean[] visitedD = new boolean[n+1];
        boolean[] visitedB = new boolean[n+1];

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }

        for (int i = 0; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }

        sb = new StringBuilder();
        dfs(v, visitedD, list);
        String str1 = sb.toString();

        sb = new StringBuilder();
        bfs(v, visitedB, list);
        String str2 = sb.toString();

        System.out.printf("%s\n%s", str1, str2);
    }
}
