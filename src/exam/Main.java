package exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] area;
    static int[] population; // 인구 수를 저장할 배열
    static int N, total, teamA, teamB; // 구역 개수, 최소값, 인구 수 총합
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

        visited = new boolean[N + 1];
        com(0);

    }

    static void com(int depth) {
        if (depth == N + 1) {
            for (int i = 1; i < N+1; i++) {
                if(visited[i])
                    teamA++;
                else
                    teamB++;
            }
            System.out.println(Arrays.toString(visited));
            return;
        }

        visited[depth] = true;
        com(depth + 1);
        visited[depth] = false;
        com(depth + 1);
    }
}