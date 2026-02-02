package programmers;

import java.util.*;

class P_뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // 인덱스 저장

        for(int i = 0; i < n; i++) {
            // 현재 값이 스택에 있는 값보다 크면 정답 처리
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        // 끝까지 못 찾은 애들
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}