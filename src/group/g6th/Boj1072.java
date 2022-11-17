package group.g6th;

import java.util.Scanner;

public class Boj1072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextInt();
        long y = sc.nextInt();
        long z = 100 * y / x;
        int rnt = -1;

        if (z < 99) {
            rnt = (int) Math.ceil((double) (100 * y - x * (z + 1)) / (double) (z-99));
        }

        System.out.println(rnt);
    }
}
