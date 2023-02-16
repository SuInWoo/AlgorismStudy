package swea;

import java.util.Scanner;

public class Sw5215 {
    static int[] ingredient, calories;
    static int max, N, L;

    static void select(int idx, int sumIngredient, int sumCal) {
        if(sumCal > L)
            return;
        else
            max = Math.max(max, sumIngredient);

        if(idx == N)
            return;

        select(idx+1, sumIngredient + ingredient[idx], sumCal + calories[idx]);
        select(idx+1, sumIngredient, sumCal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt(); // 재료 수
            L = sc.nextInt(); // 제한 칼로리

            ingredient = new int[N];
            calories = new int[N];

            for (int i = 0; i < N; i++) {
                ingredient[i] = sc.nextInt();
                calories[i] = sc.nextInt();
            }
            // end input

            max = Integer.MIN_VALUE;
            select(0, 0, 0);

            sb.append("#" + tc + " " + max + "\n");
        }

        System.out.println(sb.toString());
    }
}
