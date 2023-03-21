package exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj17471 {

    static ArrayList<Integer>[] area;
    static int[] population; // 인구 수를 저장할 배열
    static int N, min, total, checkCnt; // 구역 개수, 최소값, 인구 수 총합
    static boolean[] visited; // 방문 여부 표시

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 구역 수
        population = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            population[i] = Integer.parseInt(st.nextToken()); // 인구 수 저장 (1번구역부터 ~ N번 구역까지)
            total += population[i];
        }

        area = new ArrayList[N + 1]; // 구역별 arrayList 초기화
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            area[i] = new ArrayList<>();
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                area[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // end input

        min = Integer.MAX_VALUE;
        visited = new boolean[N + 1];
        int cnt =0;
        for (int i = 1; i < N + 1; i++) {

            if(visited[i]) // 어차피 방문했다는 거는 인접한 친구가 이미 돌았다는 거라서
                continue;

            cnt++;
            checkCnt = area[i].size();
            divide(i, population[i], 0);
        }

        if(cnt > 2)
            min = -1;

        System.out.println(min);

    }

    static void divide(int selectV, int p, int depth) { // 선택된 정점, 인구수, 현재까지 설정된 구역 수

        if(depth == checkCnt) {
            // |(인구수 총합-현재까지 인구수) - 현재까지 인구수| 와 최소값 비교
            int com = Math.abs((total - p) - p);
            min = Math.min(min, com);
        }

        visited[selectV] = true; // 선택된 정점 방문했다고 표시
        for (int i = 0; i < area[selectV].size(); i++) { // 인접한 정점 개수만큼 for문 돌기
            // 선택된 정점과 인접한 정점을 선택하고
            int nextV = area[selectV].get(i);

            // 이미 방문 했다면 넘어가기
            if (visited[nextV])
                continue;

            // 방문 안했으면 그 정점 방문
            divide(nextV, p + population[nextV], depth + 1);
        }
    }
}