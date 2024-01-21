package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class Boj2872_우리집엔도서관이있어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // init
        int N = sc.nextInt();
        int[] books = new int[N];
        int cnt = 0;
        int max = N;
        for (int i = 0; i < N; i++) {
            books[i] = sc.nextInt();
        }

        // logic

        for (int i = N - 1; i >= 0; i--) {
            if (books[i] == max) {
                max--;
            } else {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
