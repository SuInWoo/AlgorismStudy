package programmers;

class P_정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // dp[0][0] = triangle[0][0]
        // dp[1][0] = dp[0][0] + triangle[1][0] -> 왼쪽 끝
        // dp[1][1] = dp[0][0] + triangle[1][1] -> 오른쪽 끝
        // dp[2][0] = dp[1][0] + triangle[2][0] -> 왼쪽 끝
        // dp[2][1] = dp[1][0], dp[1][1] 중 큰값 + triangle[2][1]
        // dp[2][2] = dp[1][1] + triangle[2][2] -> 오른쪽 끝
        
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++) {
            // 왼쪽 끝
            dp[i][0] = dp[i-1][0] + triangle[i][0];
                
            // 오른쪽 끝
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            
            for(int j = 1; j < triangle[i].length-1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }
    
        for(int i = 0; i < dp[dp.length-1].length; i++) {
            answer = Math.max(answer, dp[dp.length-1][i]);
        }
        
        return answer;
    }
}