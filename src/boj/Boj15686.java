package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int r; // 행
    int c; // 렬

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Boj15686 {
    static ArrayList<Node> CLIST; // 치킨집 노드
    static ArrayList<Node> HLIST; // 집 노드
    static int N, M;
    static boolean[] check; // 방문 여부 저장할 배열
    static int ans = Integer.MAX_VALUE;

    public static void dfs(int start, int end) {
        if(end == M) { // 원하는 갯수에 도달하면 그 갯수만큼 치킨집이 true이니 모든 집과 true로 표시된 치킨 리스트 비교
            int sum = 0; // 거리의 합을 담을 변수

            for (int i = 0; i < HLIST.size(); i++) {

                int minDistance = Integer.MAX_VALUE; // 선택된 집 기준 치킨집을 방문하여 가장 적은 value 저장

                for (int j = 0; j < CLIST.size(); j++) {
                    if(check[j]) { // true이면 선택된 치킨 집
                        int current = Math.abs(HLIST.get(i).c - CLIST.get(j).c)
                                + Math.abs(HLIST.get(i).r - CLIST.get(j).r);

                        minDistance = Math.min(minDistance, current);
                    }
                }
                sum += minDistance;
            }
            ans = Math.min(ans, sum);

            return;
        }

        for (int i = start; i < CLIST.size(); i++) {
            check[i] = true;
            dfs(i+1, end+1);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        CLIST = new ArrayList<>(); // 치킨 리스트
        HLIST = new ArrayList<>(); // 집 리스트
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //
        M = Integer.parseInt(st.nextToken()); // 남아 있을 최대 치킨집

        // init
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                // 행렬 탐색
                int target = Integer.parseInt(st.nextToken());

                if (target == 1) { // 1이면 hList에 노드 추가
                    HLIST.add(new Node(i + 1, j + 1));
                } else if (target == 2) { // 2이면 cList에 노드 추가
                    CLIST.add(new Node(i + 1, j + 1));
                }
            }
        }

        check = new boolean[CLIST.size()];
        dfs(0,0);
        System.out.println(ans);
    }
}