package 프로그래머스.Lv3.합승택시요금;

import java.util.*;

class Solution {

    static final int INF = 1000000000;
    static List<Node>[] graph;
    static int N;

    static class Node {
        int vertex;
        int cost;
        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {

        graph = new ArrayList[n + 1];
        N = n;

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];

            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        int[] dist_s = dijkstra(s);
        int[] dist_a = dijkstra(a);
        int[] dist_b = dijkstra(b);

        long min_dist = INF;

        for (int k = 1; k <= n; k++) {
            long total = (long) dist_s[k] + dist_a[k] + dist_b[k];
            min_dist = Math.min(min_dist, total);
        }

        return (int) min_dist;
    }

    int[] dijkstra(int start) {

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        Queue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > dist[cur.vertex]) {
                continue;
            }

            for (Node nxt : graph[cur.vertex]) {
                int nxt_dist = cur.cost + nxt.cost;

                if (nxt_dist < dist[nxt.vertex]) {
                    dist[nxt.vertex] = nxt_dist;
                    pq.offer(new Node(nxt.vertex, nxt_dist));
                }
            }
        }

        return dist;
    }
}