package programmers;

import java.util.*;

class P_뉴스클러스터링 {
    public int solution(String str1, String str2) {
        
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        // 전부 소문자로 변경(일관성)
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 두 문자열을 두 글자씩 끊어서 배열로 만듬(영문 글자만 원소로 삼음)
        for(int i = 1; i < str1.length(); i++) {
            char c1 = str1.charAt(i - 1);
            char c2 = str1.charAt(i);
            
            if(c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') { // 영문 글자인지 아닌지 판별
                list1.add(Character.toString(c1) + Character.toString(c2));
            }
        }
        
        // 두 문자열을 두 글자씩 끊어서 배열로 만듬(영문 글자만 원소로 삼음)
        for(int i = 1; i < str2.length(); i++) {
            char c1 = str2.charAt(i - 1);
            char c2 = str2.charAt(i);
            
            if(c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') { // 영문 글자인지 아닌지 판별
                list2.add(Character.toString(c1) + Character.toString(c2));
            }
        }
        
        // 자카드 유사도 메서드
        return (int)(jacquard(list1, list2)*65536);
    }
    
    static double jacquard(ArrayList<String> list1, ArrayList<String> list2) {
        double answer = 0;
        double union = 0;
        double intersection = 0;
        
        for(int i = 0; i < list1.size(); i++) {
            if(list2.remove(list1.get(i))) { // 같은게 있으면 list2에서 지우고
                list1.remove(i); // list1도 지워줌
                i--; // list가 한 칸 당겨졌으므로
                intersection++; // 교집합 ++
            }
        }
        
        union = intersection + list1.size() + list2.size();           
        
        if(union == 0) {
            return 1;
        } else
            return intersection / union; 
    }
}