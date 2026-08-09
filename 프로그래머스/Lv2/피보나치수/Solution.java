package 프로그래머스.Lv2.피보나치수;

class Solution {
    public int solution(int n) {
        long [] dp = new long[n+2];
        dp[1]=1;
        for (int i=2; i<n+2; i++){
            dp[i]=(dp[i-1]+dp[i-2])%1234567;
        }
        return (int)dp[n];
    }
}