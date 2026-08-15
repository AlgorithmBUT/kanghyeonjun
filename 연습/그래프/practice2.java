package 그래프;

// bfs

import java.util.*;

public class practice2 {

    static List<Integer> graph[] = new ArrayList[7];
    static int[] visited = new int [7];

    static {
        Arrays.fill(visited, -1);
    }
    
    public static void main(String[] args) {
        for (int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }
        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(1);
        graph[2].add(4);
        graph[2].add(5);
        graph[3].add(1);
        graph[3].add(5);
        graph[4].add(2);
        graph[4].add(6);
        graph[5].add(2);
        graph[5].add(3);
        graph[5].add(6);
        graph[6].add(4);
        graph[6].add(5);

        bfs(1);
        System.out.println(Arrays.toString(visited));
    }

    static void bfs(int start){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(start);
        visited[start]=0;

        while (dq.size()!=0){
            int cur = dq.pollFirst();

            for (int next : graph[cur]){
                if (visited[next]==-1){
                    dq.offerLast(next);
                    visited[next]=visited[cur]+1;
                }
            }
        }
    }
}
