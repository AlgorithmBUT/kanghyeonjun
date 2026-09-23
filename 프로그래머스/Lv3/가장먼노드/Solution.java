package 프로그래머스.Lv3.가장먼노드;

import java.util.*;

class Solution {

    static int[] visited;
    static List<Integer>[] graph;

    public int solution(int n, int[][] edge) {

        visited = new int[n + 1];
        graph = new ArrayList[n + 1];

        Arrays.fill(visited, -1);

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];

            graph[a].add(b);
            graph[b].add(a);
        }

        bfs(1);

        int maxDist = 0;
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            maxDist = Math.max(maxDist, visited[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == maxDist) {
                cnt++;
            }
        }

        return cnt;
    }

    static void bfs(int start) {

        Deque<Integer> dq = new ArrayDeque<>();

        visited[start] = 0;
        dq.offer(start);

        while (!dq.isEmpty()) {

            int cur = dq.poll();

            for (int nxt : graph[cur]) {

                if (visited[nxt] == -1) {
                    visited[nxt] = visited[cur] + 1;
                    dq.offer(nxt);
                }
            }
        }
    }
}
