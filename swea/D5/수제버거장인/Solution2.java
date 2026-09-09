/*
 * =========================
 * 비트마스킹 풀이 흐름
 * =========================
 *
 * [1] 비트마스킹이란?
 * 정수의 각 비트(0/1)를 이용해서 여러 개의 상태를 하나의 int에 저장하는 방법
 *
 * 예)
 * 1 << 0  = 0001
 * 1 << 1  = 0010
 * 1 << 2  = 0100
 * 1 << 3  = 1000
 *
 * 각 비트의 위치를 사람 번호라고 생각하면
 * 0001 → 1번 사람
 * 0010 → 2번 사람
 * 0100 → 3번 사람
 * 1000 → 4번 사람
 *
 *
 * [2] hate 배열
 * hate[i] = i번 사람이 싫어하는 사람들을 비트로 저장
 *
 * 예)
 * 2번과 3번이 서로 싫어한다면
 *
 * hate[2]에 3번을 표시
 * hate[3]에 2번을 표시
 *
 * 0-based 기준으로
 * 2번 사람 → index 1
 * 3번 사람 → index 2
 *
 * hate[1] |= (1 << 2)
 *
 * 1 << 2 = 0100
 *
 * 즉,
 * hate[1] = 0100
 * → "2번 사람은 3번 사람을 싫어한다"
 *
 *
 * [3] cur
 * cur = 현재까지 선택한 사람들의 집합
 *
 * 예)
 * cur = 0101
 *
 * → 0번, 2번 사람이 현재 선택되어 있다는 의미
 *
 *
 * [4] 현재 사람을 선택할 수 있는지 검사
 *
 * if ((cur & hate[d]) == 0)
 *
 * cur       = 현재 선택된 사람들
 * hate[d]   = d번 사람이 싫어하는 사람들
 *
 * 둘을 AND(&) 했을 때
 *
 * 0 → 겹치는 사람이 없음 → 선택 가능
 * 1 이상 → 이미 선택된 사람 중 d번이 싫어하는 사람이 존재
 *
 *
 * [5] 사람을 선택
 *
 * cur |= (1 << d)
 *
 * d번째 비트를 1로 만든다.
 *
 * 예)
 * cur = 0101
 * d = 1
 *
 * 1 << 1 = 0010
 *
 * cur |= 0010
 *         ↓
 *        0111
 *
 * → 0번, 1번, 2번 사람이 선택된 상태
 *
 *
 * [6] DFS 흐름
 *
 * 각 사람마다
 *
 * ① 선택하지 않는다
 *    → dfs(d + 1, cur)
 *
 * ② 선택한다
 *    → 현재까지 선택된 사람과 싫어하는 사람이 겹치는지 확인
 *    → 겹치지 않으면 선택하고 다음 사람으로 이동
 *
 * 모든 사람을 결정하면 하나의 유효한 부분집합이 완성되므로 cnt++
 */

package swea.D5.수제버거장인;

import java.util.*;
import java.io.*;

public class Solution2{

  static BufferedReader br;
  static StringTokenizer st;

  static int N, M, cnt;
  static int[] hate;
    
  public static void main(String[] args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int tc=1; tc<=T; tc++){
      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      cnt = 0;

      hate = new int[N];

      for (int i=0; i<M; i++){
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken())-1;
        int b = Integer.parseInt(st.nextToken())-1;

        // 싫어하는 것 저장
        hate[a] |= (1<<b);
        hate[b] |= (1<<a);
      }

      // dfs
      dfs (0, 0);
      // 출력
      StringBuilder ans = new StringBuilder();
      ans.append("#").append(tc).append(" ").append(cnt);
      System.out.println(ans);
    }
  }

  static void dfs(int d, int cur){
    if (d==N){
      cnt++;
      return;
    }

    // 안 고름
    dfs (d+1, cur);

    // 고름
    if ((cur & hate[d]) == 0){
      dfs (d+1, cur | (1<<d));
    }
  }
}
