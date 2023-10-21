package programmers;

import java.util.*;

class P_캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int size = cities.length;

        if(cacheSize == 0) {
            return size * 5;
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            String target = cities[i].toLowerCase();
            int listSize = list.size();

            if(list.remove(target)) { // 존재하면 answer + 1
                answer += 1;
            } else { // 존재하지 않으면 answer + 5
                answer += 5;
                if(listSize >= cacheSize) {
                    list.remove(0);
                }
            }
            list.add(target);
        }
        return answer;
    }
}