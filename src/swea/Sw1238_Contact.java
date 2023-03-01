package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw1238_Contact {

    static ArrayList<Integer> ans;
    static boolean[] visited;
    static boolean[][] list; // from, to
    static int len, sV;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            len = Integer.parseInt(st.nextToken()); // 데이터 수
            sV = Integer.parseInt(st.nextToken()); // 시작 정점 번호

            list = new boolean[101][101];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                list[from][to] = true; // true는 연결됨
            }

            visited = new boolean[101]; // 방문 여부 체크할 배열
            ans = new ArrayList<>(); // 결과 담을 리스트
            link(sV);

            sb.append("#").append(tc).append(" ").append(ans.get(ans.size()-2)).append("\n");
        }
        System.out.println(sb);
    }

    static void link(int selectV) {

        Queue<Integer> q = new LinkedList<>(); // BFS 탐색을 위한 Queue 생성
        visited[selectV] = true; // 방문 체크
        q.offer(selectV); // 초기 값 q에 넣어줌
        int max;

        while (!q.isEmpty()) {
            int qSize = q.size(); // 현재 q 사이즈 저장
            max = 0;

            for (int i = 0; i < qSize; i++) {
                int current = q.poll(); // 현재 정점 번호

                for (int j = 1; j < list[current].length; j++) {
                    if (list[current][j] && !visited[j]) { // current와 연결되어있고, 방문 안했으면 q에 추가
                        visited[j] = true;
                        q.offer(j);
                        max = Math.max(max, j); // 같은 레벨 중 가장 큰값 저장
                    }
                }
            }
            ans.add(max);
        }
    }
}
