package boj;

import java.util.Scanner;

public class Boj16953_A_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int cnt = 1;
        while (A != B) { // 뒤에서 앞으로 진행
            if (B < A) { // 작아지면 같지 않다
                cnt = -1;
                break;
            }

            if (B % 10 == 1) { // 끝 자리가 1이면
                B /= 10;
            } else if (B % 2 == 0) { // 짝수이면
                B /= 2;
            } else { // 홀수이면서 끝자리가 1이 아니면
                cnt = -1;
                break;
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
