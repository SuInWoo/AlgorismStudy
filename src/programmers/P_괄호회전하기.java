package programmers;

import java.util.*;

class P_괄호회전하기 {
	public int solution(String s) {
		int answer = 0;

		// x 회전(substring)
		for(int i = 0; i < s.length(); i++) {
			String reverse = s.substring(0, i);
			String normal = s.substring(i, s.length());

			if(checkBracket(normal, reverse)) {
				answer++;
			}

		}

		return answer;
	}

	static boolean checkBracket(String normal, String reverse) {
		Stack<Character> stack = new Stack<>();
		// [, {, ( 이면 push 반대이면 pull
		for(int i = 0; i < normal.length(); i++) {
			char c = normal.charAt(i);

			if(c == ')') {
				if(stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			} else if(c == ']') {
				if(stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			} else if(c == '}') {
				if(stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			} else {
				stack.push(c);
			}

		}

		for(int i = 0; i < reverse.length(); i++) {
			char c = reverse.charAt(i);

			if(c == ')') {
				if(stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			} else if(c == ']') {
				if(stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			} else if(c == '}') {
				if(stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			} else {
				stack.push(c);
			}

		}

		if(!stack.isEmpty())
			return false;
		return true;
	}
}
