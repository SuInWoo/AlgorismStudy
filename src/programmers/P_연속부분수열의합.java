package programmers;

import java.util.*;

class P_연속부분수열의합 {
    public int solution(int[] elements) {
        HashSet<Integer> hs = new HashSet<>();
        int answer = 0;
        int size = elements.length;

        for(int len = 1; len <= size; len++) { // 길이
            int start = 0;
            int end = (start + len) % size;
            // 초기 sum
            int sum = 0;
            for(int i = start; i < end; i++) {
                sum += elements[i];
            }
            hs.add(sum);

            if(len == size) // 마지막 전체는 넘길필요가 없음
                break;

            // 한 칸씩 넘기기
            for(int i = start; i < size; i++) {
                end = (i + len) % size;
                sum -= elements[i];
                sum += elements[end];
                hs.add(sum);
            }
            System.out.println();
        }

        answer = hs.size();
        return answer;
    }
}