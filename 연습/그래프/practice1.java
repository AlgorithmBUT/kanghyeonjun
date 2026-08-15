package 그래프;

// dfs

import java.util.*;

public class practice1 {

    static List<Integer> [] graph = new ArrayList [7];
    static boolean [] visited = new boolean [7];
    public static void main(String[] args) {
        

        for (int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(1);
        graph[2].add(4);
        graph[3].add(1);
        graph[3].add(4);
        graph[4].add(2);
        graph[4].add(3);
        graph[4].add(5);
        graph[5].add(4);
        graph[5].add(6);
        graph[6].add(5);

        dfs(1);
    }

    static void dfs(int start){
        if (visited[start]){
            return;
        }
        visited[start]=true;
        System.out.println(start);

        for (int next : graph[start]){
            dfs(next);
        }
    }
}
