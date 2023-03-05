package boj;

import java.io.*;
import java.util.*;

public class Boj17135_캐슬디펜스 {

    static int N, M, D;
    static int map[][];
    static List<int[]> enemyList;
    static int archer[];
    static int ans; // 공격할 수 있는 최대 적 수(정답)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        D = Integer.parseInt(st.nextToken()); // 공격 가능 거리

        map = new int[N][M];
        archer = new int[3]; // 궁수 3명의 공격 위치저장
        enemyList = new ArrayList<>(); // 적 좌표 저장 리스트

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {// 적 좌표
                    int[] in = new int[]{i, j};
                    enemyList.add(in); // 적 좌표에 추가
                }
            }
        }

        combi(0, 0); // 궁수 3명 조합
        System.out.println(ans);
    }

    private static void combi(int idx, int start) {
        if (idx == 3) { // 3명 다 배치했으면
            List<int[]> copyList = copy(enemyList);
            attack(copyList); // 적 죽이기
            return;
        }

        for (int i = start; i < M; i++) {
            archer[idx] = i; // 궁수 좌표 저장
            combi(idx + 1, i + 1);
        }

    }

    private static void attack(List<int[]> copyList) {
        int cnt = 0; // 공격한 적의 수

        while (!copyList.isEmpty()) { // 적이 없을때 까지
            List<int[]> targets = new ArrayList<>(); // 궁수 3명이 공격하고자 하는 적의 좌표

            for (int k = 0; k < 3; k++) { // 각 궁수마다 잡을 적 설정
                PriorityQueue<Enemy> pq = new PriorityQueue<>(); // 현재 궁수의 사정거리에 있는 적들 저장(거리 순, 열 순 정렬)

                for (int i = 0; i < copyList.size(); i++) { // 현재 남아있는 적
                    int[] cur = copyList.get(i);
                    int d = Math.abs(cur[0] - N) + Math.abs(cur[1] - archer[k]); // 궁수와 적 사이의 거리 계산 cur[0] = 세로, cur[1] = 가로
                    if (d <= D) // 사정거리 안에들어와서 죽일 수 있는 적이면
                        pq.add(new Enemy(cur[0], cur[1], d)); // q에 추가
                }

                if (!pq.isEmpty()) { // 잡을 적이 있다면
                    Enemy target = pq.poll(); // 가장 가깝고, 왼쪽에 있는 적
                    boolean flag = false; // 현재 타겟을 다른 궁수가 잡으려 하는지 여부 / true면 이미 다른 궁수가 잡으려 함

                    for (int i = 0; i < targets.size(); i++) {
                        int[] cur2 = targets.get(i);
                        if (target.x == cur2[0] && target.y == cur2[1]) // 이미 다른 누군가가 잡으려 함
                            flag = true;
                    }
                    if (!flag) { // 내가 처음 잡는거면 넣고 안잡는거면 안넣음
                        targets.add(new int[]{target.x, target.y});
                    }
                }
            }

            // targets 리스트에 있는 애들 전부 제거
            for (int i = 0; i < targets.size(); i++) {
                for (int j = copyList.size() - 1; j >= 0; j--) {
                    if (targets.get(i)[0] == copyList.get(j)[0] && targets.get(i)[1] == copyList.get(j)[1]) {
                        copyList.remove(j);
                        cnt++;
                        break;
                    }
                }
            }
            // 남아있는 적들 이동(좌표 벗어나면 삭제)
            for (int i = copyList.size() - 1; i >= 0; i--) {
                copyList.get(i)[0] += 1;
                if (copyList.get(i)[0] == N)
                    copyList.remove(i);
            }
        }
        ans = Math.max(ans, cnt);

    }

    private static List<int[]> copy(List<int[]> list) { // copy
        List<int[]> tmp = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int[] cur = list.get(i);
            int[] in = new int[]{cur[0], cur[1]};
            tmp.add(in);
        }

        return tmp;
    }

    static class Enemy implements Comparable<Enemy> {
        int x, y, d;

        public Enemy(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Enemy o) {
            if (this.d == o.d) { // 거리가 같다면
                return this.y - o.y; // 열이 더 작은 값(더 왼쪽)
            } else
                return this.d - o.d; // 거리가 더 작은 값
        }
    }
}
