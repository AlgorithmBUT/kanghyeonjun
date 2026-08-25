package 프로그래머스.Lv3.외벽점검;

import java.util.*;

class Solution {

    static boolean[] visited;
    static int[] sWeak;
    static int[] sDist;
    static int N;
    static int ans;

    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        sWeak=weak;

        int [] arrDist = Arrays.stream(dist)
                                .boxed()
                                .sorted(Comparator.reverseOrder())
                                .mapToInt(Integer::intValue)
                                .toArray();
        
        sDist = arrDist;
        N=n;
        visited = new boolean[n];
        Arrays.fill(visited,true);
        for (int i : weak){
            visited[i]=false;
        }

        return answer;
    }

    static void dfs(int cnt){
        if (cnt>ans){
            return;
        }

        for(int j : sWeak){
            if (!visited[j]){
                List<Integer> blank = new ArrayList<>();
                for (int k=j; k<j+cnt; k++){
                    k%=N;
                    if (!visited[j]){
                        blank.add(k);
                        visited[k]=true;
                    }
                }
                dfs (cnt+1);
                for (int l : blank){
                    visited[l]=false;
                }
            }
        
        }
    }
}
