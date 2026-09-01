package swea.D3.퍼펙트셔플;

import java.util.*;
import java.io.*;

public class Solution {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws Exception {

    int T = Integer.parseInt(br.readLine());
    
    for (int tc=1; tc<=T; tc++){
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      Deque<String> dq1 = new ArrayDeque<>();
      Deque<String> dq2 = new ArrayDeque<>();

      StringBuilder ans = new StringBuilder();

      for (int i=0; i<(N+1)/2; i++){
        dq1.offer(st.nextToken());
      }

      for (int i=0; i<N/2; i++){
        dq2.offer(st.nextToken());
      }

      ans.append("#").append(tc).append(" ");

      while (!dq1.isEmpty() && !dq2.isEmpty()){
        ans.append(dq1.pollFirst()).append(" ").append(dq2.pollFirst()).append(" ");
      }

      if (!dq1.isEmpty()){
        ans.append(dq1.pollFirst());
      } 

      System.out.println(ans);
    }
  }
}
