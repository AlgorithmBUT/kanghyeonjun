package 프로그래머스.Lv3.외벽점검;

import java.util.*;

class Solution {

    static boolean[] visited;
    static int[] sWeak;
    static int[] sDist;
    static int N;

    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        sWeak=weak;
        
        N=n;
        visited = new boolean[n];
        Arrays.fill(visited,true);
        for (int i : weak){
            visited[i]=false;
        }

        return answer;
    }

    static void dfs(int[] weak){

    }
}
