package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj4889_안정적인문자열 {
    /**
     * 1. "-" 가 한 개 이상 포함되어 있으면 종료
     * 2. "{"은 스택에 담음
     * 3. "}" 이 문자열은 무조건 "{" 있어야 하므로 스택 체크
     * 4. 스택이 비어있으면 변경하여 스택에 저장(변경 횟수 증가)
     * 5. 스택이 안비어있으면 꺼내기(안정적인 문자열)
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;

        while(true) {
            String input = br.readLine();

            if (input.contains("-"))
                break;

            sb.append(tc++).append(". ");

            int changeCnt = 0;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (c == '{') { // { 일때
                    stack.push(c);
                } else { // } 일때
                    if (stack.isEmpty()) {
                        stack.push('{');
                        changeCnt++;
                    } else {
                        stack.pop();
                    }
                }
            }

            sb.append(changeCnt + stack.size()/2).append("\n");
        }

        System.out.println(sb);
    }
}
