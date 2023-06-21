package boj_m6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj4949_균형잡힌세상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            // 한 줄을 입력받아
            String input = br.readLine();
            if (input.equals("."))
                break;

            // for문 실행(이때 stack 생성) 후 StringBuilder에 값 저장
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i); // 한개씩 검사

                if (c == '(' || c == '[') { // 여는 괄호는 모두 push
                    stack.push(c);
                } else if (c == ')') { // 닫는 괄호 일때
                    if (stack.isEmpty() || stack.peek() != '(') { // 비어있거나 짝이 안맞으면 no
                        stack.push(c);
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        stack.push(c);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty())
                sb.append("yes\n");
            else
                sb.append("no\n");

        }

        System.out.println(sb);

    }
}
