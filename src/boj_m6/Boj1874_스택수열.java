package boj_m6;

import java.util.Scanner;
import java.util.Stack;

public class Boj1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        // 맨 처음에
        // 해당 수가 될때까지 push 1 ~ 해당수
        int start = sc.nextInt();
        for (int i = 1; i <= start; i++) {
            stack.push(i);
            sb.append("+\n");
        }

        // 해당 수 pop 하고 기준 standard 변수에 저장
        int standard = stack.pop();
        sb.append("-\n");
        int cnt = start + 1;

        // 1 제외하고 이후 숫자
        // for) 1 ~ n
        for (int i = 1; i < n; i++) { // 나머지 숫자들

            int next = sc.nextInt();
            if (next < standard) { // if) 다음 숫자가 standard 보다 작을 때
                if (stack.peek() != next) { // peek가 그 수가 아니면 no
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                }

            } else { // else) 다음 숫자가 standard 보다 클 때
                for (int j = cnt; j <= next; j++) { // 그 수 까지 push
                    stack.push(j);
                    sb.append("+\n");
                }
                cnt = next + 1; // 지금까지 넣은 수 변경
                // 해당 수 pop 하고 standard 변경
            }
            standard = next;
            stack.pop();
            sb.append("-\n");

        }

        System.out.println(sb);

    }
}
