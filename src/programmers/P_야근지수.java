package programmers;

import java.util.*;
/**
    1. 피로도가 가장 낮게 나오려면 -> 제곱이니 남아있는 숫자들 평균이 낮아야함
    2. 최대 숫자를 꺼내면서 1씩 계속 감소시켜주면 평균이 낮아지지 않을까? => PQ 사용
**/
class P_야근지수 {
    public long solution(int n, int[] works) {     
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        
        return fatigue(n, pq);
    }
    
    static long fatigue(int n, PriorityQueue<Integer> pq) {
        long answer = 0;
        for(int i = 0; i < n; i++){
            int work = pq.poll();
            if(work <= 0)
                break;
            pq.offer(work - 1);
        }
        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}