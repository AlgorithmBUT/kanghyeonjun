package swea.D4.장훈이의높은선반;

import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int N;
    static int B;

    static int[] heights;

    static int minHeight;

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            heights = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            minHeight = Integer.MAX_VALUE;

            dfs(0, 0);

            sb.append("#")
                    .append(tc)
                    .append(" ")
                    .append(minHeight - B)
                    .append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int d, int sum) {

        // 이미 선반 높이 이상이면 확인
        if (sum >= B) {
            minHeight = Math.min(minHeight, sum);
            return;
        }

        // 모든 사람을 확인했을 경우
        if (d == N) {
            return;
        }

        // 현재 사람을 선택
        dfs(d + 1, sum + heights[d]);

        // 현재 사람을 선택하지 않음
        dfs(d + 1, sum);
    }
}
