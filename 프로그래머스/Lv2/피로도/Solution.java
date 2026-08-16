package 프로그래머스.Lv2.피로도;

class Solution {

    static int maxCnt = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0, visited);
        return maxCnt;
    }

    static void dfs (int cur, int[][] dungeons, int cnt, boolean[] visited){

        maxCnt=Math.max(cnt,maxCnt);

        for (int i=0; i<dungeons.length; i++){
            if (cur>=dungeons[i][0] && !visited[i]){
                visited[i]=true;
                dfs (cur-dungeons[i][1], dungeons, cnt+1, visited);
                visited[i]=false;
            }
        }
    }
}
