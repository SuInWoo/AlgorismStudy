package programmers;

import java.util.*;

class P_여행경로 {

    Map<String, List<String>> link = new HashMap<>();
    List<String> path = new ArrayList<>();
    int ticketCount;

    public String[] solution(String[][] tickets) {
        ticketCount = tickets.length;
        init(tickets);
        path.add("ICN");        // 시작점
        dfs("ICN");             // DFS 시작
        return path.toArray(new String[link.size()]);
    }

    public void init(String[][] tickets) {
        for (String[] s : tickets) {
            link.computeIfAbsent(s[0], k -> new ArrayList<>()).add(s[1]);
        }

        // 알파벳 순 정렬
        for (List<String> list : link.values()) {
            Collections.sort(list);
        }
    }

    // DFS + 백트래킹
    public boolean dfs(String current) {
        if (path.size() == ticketCount + 1) {
            return true; // 모든 티켓 사용 완료
        }

        if (!link.containsKey(current) || link.get(current).isEmpty()) {
            return false;
        }

        List<String> nextList = link.get(current);

        for (int i = 0; i < nextList.size(); i++) {
            String next = nextList.get(i);

            // 티켓 사용
            nextList.remove(i);
            path.add(next);

            if (dfs(next)) return true;

            // 실패 시 복구
            path.remove(path.size() - 1);
            nextList.add(i, next);
        }

        return false;
    }
}