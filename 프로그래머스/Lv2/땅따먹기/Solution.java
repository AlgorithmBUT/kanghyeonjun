package 프로그래머스.Lv2.땅따먹기;

import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int dp[][] = new int [land.length][4];

        for (int i=0; i<4; i++){
            dp[0][i]=land[0][i];
        }

        if (land.length==1){
            for (int i=0; i<3; i++){
                answer=Math.max(dp[0][i],dp[0][i+1]);
            }
        } else {
            for (int i=1; i<land.length; i++){
                dp[i][0] = land[i][0]+Collections.max(Arrays.asList(dp[i-1][1], dp[i-1][2], dp[i-1][3]));
                dp[i][1] = land[i][1]+Collections.max(Arrays.asList(dp[i-1][0], dp[i-1][2], dp[i-1][3]));
                dp[i][2] = land[i][2]+Collections.max(Arrays.asList(dp[i-1][0], dp[i-1][1], dp[i-1][3]));
                dp[i][3] = land[i][3]+Collections.max(Arrays.asList(dp[i-1][0], dp[i-1][1], dp[i-1][2]));
            }
        }

        answer = Collections.max(Arrays.asList(dp[dp.length-1][0], dp[dp.length-1][1], dp[dp.length-1][2], dp[dp.length-1][3]));
        return answer;
    }
}
