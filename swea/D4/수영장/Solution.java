package swea.D4.수영장;

import java.util.*;
import java.io.*;

public class Solution {

    static int[] costs;
    static int[] months;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++){
            costs = new int[4];
            months = new int[12];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<4; i++){
                costs[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<12; i++){
                months[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[13];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i=1; i<=12; i++){
                // 1일 이용권
                dp[i] = Math.min(dp[i], costs[0] * months[i-1] + dp[i-1]);

                // 1달 이용권
                dp[i] = Math.min(dp[i], costs[1] + dp[i-1]);

                // 3달 이용권
                if (i>=3){
                    dp[i] = Math.min(dp[i], costs[2] + dp[i-3]);
                }

                // 1년 이용권
                if (i==12){
                    dp[i] = Math.min(dp[i], costs[3]);
                }
            }

            StringBuilder ans = new StringBuilder();
            ans.append("#").append(tc).append(" ").append(dp[12]);

            System.out.println(ans);
        }
    }
}
