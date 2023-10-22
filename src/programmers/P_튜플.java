package programmers;

import java.util.*;

class P_튜플 {
    public int[] solution(String s) {
        // data set
        s = (s.replace("},{", "_")); // 치환
        s = s.substring(2, s.length()-2); // 앞 뒤 {{ / }} 제거
        String[] arr = s.split("_"); // 배열로 변경
        Arrays.sort(arr, (String s1, String s2) -> s1.length() - s2.length()); // 정렬

        // Logic
        ArrayList<Integer> list = new ArrayList<>();

        for(String str : arr) {
            String[] target = str.split(","); // 개별 숫자 담기

            for(int i = 0; i < target.length; i++) {
                // 현재 리스트에 존재하지 않으면 추가하기
                if(!list.contains(Integer.parseInt(target[i]))) {
                    list.add(Integer.parseInt(target[i]));
                }
            }
        }

        // create answer
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}