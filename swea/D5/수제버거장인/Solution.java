package swea.D5.수제버거장인;

import java.util.*;
import java.io.*;

public class Solution {
  static BufferedReader br;
  static StringTokenizer st;

  static int N, M, cnt;

  static List<Integer>[] hate;
  static boolean[] selected;

  public static void main(String[] args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= T; tc++){
      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      cnt = 0;

      hate = new ArrayList[N];
      selected = new boolean[N];

      for (int i = 0; i < N; i++){
        hate[i] = new ArrayList<>();
      }

      for (int i = 0; i < M; i++){
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        hate[a].add(b);
        hate[b].add(a);
      }

      dfs(0);

      StringBuilder ans = new StringBuilder();
      ans.append("#").append(tc).append(" ").append(cnt);

      System.out.println(ans);
    }
  }

  static void dfs(int d){
    // 모든 재료 선택/미선택 결정 완료
    if (d == N){

      boolean valid = true;

      // 현재 부분집합 검사
      for (int i=0; i < N; i++){
        // 선택 안 했다면 볼 필요 X
        if (!selected[i]) continue;
        // 싫어하는 재료 선택되어 있으면 false
        for (int h : hate[i]){
          if (selected[h]){
            valid = false;
            break;
          }
        }

        if (!valid) break;
      }
      // 문제가 없었다면 부분집합
      if (valid) cnt++;

      return;
    }
    // d번 재료 선택
    selected[d]=false;
    dfs(d+1);
    // d번 재료 선택 X
    selected[d]=true;
    dfs(d+1);
  }
}
