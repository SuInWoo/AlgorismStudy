package programmers;

/**
    1. 연결되어 있는 네트워크는 하나의 네트워크로 치므로, 연결되어 있을 때 애들을 다 방문해야함
    2. 방문 배열에서 0 ~ endIdx까지 돌면서 방문 안했으면 해당 네트워크 dfs 돌리기
    3. 해당 네트워크와 관련된 애들은 한번의 턴에 다 방문하고, 방문이 끝났을 때 그것을 하나의 네트워크로 침(answer++)
**/
class P_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n]; // 방문 배열
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) // 이미 방문했으면 지나감
                continue;
            
            dfs(i, visited, computers); // 해당 네트워크 숫자를 기준으로 dfs
            answer++; // 방문했던 모든 네트워크를 하나로 침 
        }
        
        return answer;
    }
    
    static void dfs(int netIdx, boolean[] visited, int[][] computers) {
        visited[netIdx] = true; // 방문했으니 방문 체크
        
        for(int i = 0; i < visited.length; i++) {
            if(i == netIdx || visited[i] || computers[netIdx][i] == 0)
                continue;
            
            dfs(i, visited, computers);
        }
    }
}