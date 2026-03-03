package boj;

import java.io.*;
import java.util.*;

public class Boj1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N
        int rank = Integer.parseInt(st.nextToken()); // 확인할 랭킹
        int P = Integer.parseInt(st.nextToken()); // P

        if (N == 0) { // N이 0 일때는 리스트를 받을 필요 없음
            if (P == 0) // 0인경우 아예 랭킹에 올릴 수 없음
                System.out.println("-1");
            else
                System.out.println("1");
        } else { // 리스트 받아야함
            st = new StringTokenizer(br.readLine());
            int checkCount = 0; // 지금까지 확인한 랭킹 개수
            int myRank = 1; // 나의 순위

            int[] rankList = new int[N];

            for (int i = 0; i < N; i++) {
                rankList[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                if (rankList[i] > rank) { // 나보다 크면 내가 뒷순번
                    checkCount++;
                    myRank++;
                } else if (rankList[i] == rank) {// 같으면
                    checkCount++;
                } else { // 내 자리
                    break;
                }
            }

            if (checkCount >= P) {
                System.out.println("-1");
            } else {
                System.out.println(myRank);
            }
        }

    }
}
