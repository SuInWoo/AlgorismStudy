package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class Boj1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        // end input

        LinkedList<Integer> circle = new LinkedList<>();
        int[] ans = new int[N];
        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        int idx = K-1; // 처음 idx
        for (int i = 0; i < N-1; i++) {
            ans[i] = circle.get(idx);
            circle.remove(idx);
            int size = circle.size();
            idx = (idx+K-1)%size;
        }
        ans[N-1] = circle.get(0);


        // print
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < ans.length-1; i++) {
            sb.append(ans[i] + ", ");
        }
        sb.append(ans[N-1] + ">");

        System.out.println(sb.toString());
    }
}
