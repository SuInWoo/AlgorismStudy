package programmers;

import java.util.*;

class P_의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();

        // 같은 종류의 옷 개수 넣기
        System.out.println(1);
        for(int i = 0; i < clothes.length; i++) {
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(String key : hm.keySet()) {
            answer *= hm.get(key) + 1; // 안 입는 경우도 넣어주기
        }

        return answer - 1;
    }
}
