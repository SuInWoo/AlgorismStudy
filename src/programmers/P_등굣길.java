package programmers;

class P_등굣길 {

    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;

        // DP 테이블 초기화 (1-based를 0-based로 변환하기 위해 크기를 n+1, m+1로)
        int[][] dp = new int[n + 1][m + 1];

        // 물에 잠긴 지역 표시
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for (int[] puddle : puddles) {
            // puddles는 [x, y] 형태이므로 [열, 행] = [m좌표, n좌표]
            isPuddle[puddle[1]][puddle[0]] = true;
        }

        // 시작점 초기화
        dp[1][1] = 1;

        // DP 테이블 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 시작점이거나 물에 잠긴 곳은 건너뛰기
                if ((i == 1 && j == 1) || isPuddle[i][j]) {
                    if (isPuddle[i][j]) {
                        dp[i][j] = 0;
                    }
                    continue;
                }

                // 위쪽에서 오는 경로 + 왼쪽에서 오는 경로
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        return dp[n][m];
    }
}
