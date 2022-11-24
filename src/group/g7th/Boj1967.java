package group.g7th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1967 {
    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static ArrayList<Node>[] tree;
    public static boolean[] visited;    // 방문여부 확인
    public static int rnt;  // 결과 담을 변수
    public static int idx;

    public static void dfs(int current, int sum) {

        visited[current] = true;
        for (int i = 0; i < tree[current].size(); i++) {
            int next = tree[current].get(i).v;

            if (visited[next]) {
                if (sum > rnt) {
                    idx = current;
                    rnt = sum;
                }
            } else {
                sum += tree[current].get(i).w;
                dfs(next, sum);
                sum -= tree[current].get(i).w;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // initial
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        tree = new ArrayList[n+1];
        StringTokenizer st;

        if (n==1) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n+1; i++) {
            tree[i] = new ArrayList<>();
        }

        // input
        for (int i = 0; i < n-1; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tree[x].add(new Node(y, w));
            tree[y].add(new Node(x, w));
        }

        // Logic

        // dfs 탐색

        dfs(1,0);

        Arrays.fill(visited, false);
        rnt = -1;
        dfs(idx, 0);

        // output
        System.out.println(rnt);
    }
}
