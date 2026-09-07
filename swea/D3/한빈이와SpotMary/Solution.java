package swea.D3.한빈이와SpotMary;

import java.util.*;
import java.io.*;

public class Solution {

  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;
  
  static int N;
  static int M;
  static int[] snacks;      

  static int maxWeight;     
  static boolean[] visited;

  public static void main(String[] args) throws Exception {

    br = new BufferedReader(new InputStreamReader(System.in));

    // test case
    int T = Integer.parseInt(br.readLine());

    for (int tc=1; tc<=T; tc++){

      // first input
      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      snacks = new int[N];

      // second input
      st = new StringTokenizer(br.readLine());
      for (int i=0; i<N; i++){
        snacks[i] = Integer.parseInt(st.nextToken());
      }

      // dfs
      maxWeight=-1;
      visited = new boolean[N];

      dfs(0, 0);

      // output
      sb = new StringBuilder();

      sb.append("#").append(tc).append(" ").append(maxWeight);

      System.out.println(sb);
    }
  }

  static void dfs(int d, int cur){
    if (d==2){
      if (cur<=M){
        maxWeight = Math.max(maxWeight, cur);
      }
      return;
    }

    for (int i=0; i<N; i++){
      if (!visited[i]){
        visited[i]=true;
        dfs(d+1, cur+snacks[i]);
        visited[i]=false;
      }
    }
  }
}
