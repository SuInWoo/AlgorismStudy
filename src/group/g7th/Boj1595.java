package group.g7th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1595 {

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static ArrayList<Node>[] road;
    public static boolean[] visited;    // 방문여부 확인
    public static int rnt;  // 결과 담을 변수
    public static int idx;
//    public static int[][] weight;   // 연결된 정점의 가중치를 담을 변수

    public static void dfs(int current, int sum) {

        visited[current] = true;

        for (int i = 0; i < road[current].size(); i++) {
            int next = road[current].get(i).v;

            if (visited[next]) {
                if (sum > rnt) {
                    idx = current;
                    rnt = sum;
                }
            } else {
                sum += road[current].get(i).w;
                dfs(next, sum);
                sum -= road[current].get(i).w;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // initial
//        weight = new int[10001][10001];
        visited = new boolean[10001];
        road = new ArrayList[10001];
        boolean out = true;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st;

            for (int i = 0; i < 10001; i++) {   // 최대 나라의 개수가 10000개이므로 10000개 ArrayList 생성
                road[i] = new ArrayList<>();
            }

            // input
            String str;
            while (!(str = br.readLine()).isEmpty()) {
                if (str == null)
                    break;
                st = new StringTokenizer(str);
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                out = false;

                road[x].add(new Node(y, w));
                road[y].add(new Node(x, w));
            }

        }catch (Exception e) { }

        if (out) {
            System.out.println(0);
            return;
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
