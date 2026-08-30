class Solution {
    public int solution(int m, int n, int[][] puddles) {

        int[][] dp = new int[n][m];

        for (int i=0; i<puddles.length; i++){
            dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }

        dp[0][0] = 1;

        // 첫 번째 행
        for (int j=1; j<m; j++){
            if (dp[0][j] == -1){
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j-1];
            }
        }

        // 첫 번째 열
        for (int i=1; i<n; i++){
            if (dp[i][0] == -1){
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i-1][0];
            }
        }

        // 나머지
        for (int i=1; i<n; i++){
            for (int j=1; j<m; j++){

                if (dp[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }

        return dp[n-1][m-1];
    }
}