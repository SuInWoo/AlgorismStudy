package programmers;

import java.util.*;

class P_귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] type = new int[10000001];
        
        for(int i = 0; i < tangerine.length; i++) {
            type[tangerine[i]]++;
        }
        
        Arrays.sort(type); // 정렬
        
        for(int i = type.length - 1; i > 0; i--) {
            answer++;
            k -= type[i];
            if(k <= 0) { // 전체 개수에서 해당 타입의 개수를 뺐을때 음수이면 끝
                break; 
            }
        }
        
        return answer;
    }
}