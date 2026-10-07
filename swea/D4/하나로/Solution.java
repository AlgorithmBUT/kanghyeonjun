package swea.D4.하나로;

import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br;
    static StringTokenizer st;

    static int[] parent;
    static int[] size;

    static class Edge{
        int from;
        int to;
        long cost;

        public Edge(int from, int to, long cost){
            this.from=from;
            this.to=to;
            this.cost=cost;
        }
    }
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());

            long[] y = new long[N];
            long[] x = new long[N];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++){
                y[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++){
                x[i] = Long.parseLong(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine().trim());

            parent = new int[N];
            size = new int[N];

            for (int i=0; i<N; i++){
                parent[i]=i;
                size[i]=1;
            }

            // 모든 섬 쌍 거리 계산
            List<Edge> edges = new ArrayList<>();

            for (int i=0; i<N; i++){
                for (int j=i+1; j<N; j++){
                    long dy = y[i] - y[j];
                    long dx = x[i] - x[j];

                    long cost = dx*dx + dy*dy;

                    edges.add(new Edge(i, j, cost));
                }
            }

            // 비용이 작은 순으로 정렬
            edges.sort((a,b) -> Long.compare(a.cost, b.cost));

            long total = 0;
            long count = 0;

            for (Edge edge : edges){
                if (union(edge.from, edge.to)){
                    total += edge.cost;
                    count++;

                    if (count == N-1){
                        break;
                    }
                }
            }

            long answer = Math.round(total*E);

            StringBuilder res = new StringBuilder();
            res.append("#").append(tc).append(" ").append(answer);

            System.out.println(res);
        }
    }

    static int find(int x){
        if (parent[x]!=x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if (rootA==rootB){
            return false;
        }

        if (size[rootA]<size[rootB]){
            int tmp = rootA;
            rootA = rootB;
            rootB=tmp;
        }

        parent[rootB]=rootA;
        size[rootA]+=size[rootB];

        return true;
    }
}
