package programmers;

import java.util.*;

class P_방문길이 {
    public int solution(String dirs) {
        int answer = 0;

        Set<String> pathSet = new HashSet<>();

        // U, D, L, R
        int[] loc = {0, 0, 0, 0};

        for(int i = 0; i < dirs.length(); i++) {
            char type = dirs.charAt(i);

            int prevX = loc[2] + loc[3];
            int prevY = loc[0] + loc[1];

            // 이동 가능 체크
            if(!checkPass(type, loc)) continue;

            // 이동
            move(type, loc);

            int curX = loc[2] + loc[3];
            int curY = loc[0] + loc[1];

            // 경로 문자열
            String path1 = prevX + "," + prevY + "->" + curX + "," + curY;
            String path2 = curX + "," + curY + "->" + prevX + "," + prevY;

            // 중복 체크
            if(!pathSet.contains(path1)) {
                pathSet.add(path1);
                pathSet.add(path2);
                answer++;
            }
        }

        return answer;
    }

    // 범위 체크
    public boolean checkPass(char type, int[] loc) {

        int y = loc[0] + loc[1];
        int x = loc[2] + loc[3];

        switch(type) {
            case 'U': return y + 1 <= 5;
            case 'D': return y - 1 >= -5;
            case 'L': return x - 1 >= -5;
            case 'R': return x + 1 <= 5;
        }
        return true;
    }

    // 이동
    public void move(char type, int[] loc) {
        switch(type) {
            case 'U': loc[0]++; break;
            case 'D': loc[1]--; break;
            case 'L': loc[2]--; break;
            case 'R': loc[3]++; break;
        }
    }
}
