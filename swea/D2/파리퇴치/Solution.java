package swea.D2.파리퇴치;

import java.util.*;
import java.io.*;

public class Solution {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws Exception {

    int T = Integer.parseInt(br.readLine());

    for (int tc=1; tc<=T; tc++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int ans = 0;

      StringBuilder sb = new StringBuilder();

      int[][] board = new int[N][N];

      for (int y=0; y<N; y++){
        StringTokenizer num = new StringTokenizer(br.readLine());
        for (int x=0; x<N; x++){
          board[y][x] = Integer.parseInt(num.nextToken()); 
        }
      }

      for (int y=0; y<=N-M; y++){
        for (int x=0; x<=N-M; x++){

          int cur = 0;

          for (int curY=y; curY<y+M; curY++){
            for (int curX=x; curX<x+M; curX++){
              cur+=board[curY][curX];
            }
          }

          ans=Math.max(ans,cur);
        }
      }

      sb.append("#").append(tc).append(" ").append(ans);

      System.out.println(sb);
    }
  }
}
