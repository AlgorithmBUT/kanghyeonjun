package 프로그래머스.Lv3.네트워크;

class Solution {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean visited[] = new boolean[n];
        for (int i=0; i<n; i++){
            if (!visited[i]){
                answer++;
                dfs(i, visited, computers);
            }
        }
        return answer;
    }

    static void dfs (int start, boolean[] visited, int [][] arr){
        if (visited[start]){
            return;
        }

        visited[start]=true;

        for (int i=0; i<arr[0].length; i++){
            if (arr[start][i]==1){
                dfs(i, visited, arr);
            }
        }
    }
}
