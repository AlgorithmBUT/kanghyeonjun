package swea.D4.치즈도둑;

import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static StringTokenizer st;

    static int N;
    static int[][] board;
    static boolean[][] visited;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int count;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            board = new int[N][N];
            count = 0;

            int maxTaste = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    maxTaste = Math.max(maxTaste, board[i][j]);
                }
            }

            for (int day = 0; day <= maxTaste; day++) {
                visited = new boolean[N][N];

                int cnt = 0;

                for (int y = 0; y < N; y++) {
                    for (int x = 0; x < N; x++) {
                        if (board[y][x] > day && !visited[y][x]) {
                            dfs(y, x, day);
                            cnt++;
                        }
                    }
                }

                count = Math.max(count, cnt);
            }

            System.out.println("#" + tc + " " + count);
        }
    }

    static void dfs(int y, int x, int day) {
        if (y < 0 || y >= N || x < 0 || x >= N) return;
        if (board[y][x] <= day) return;
        if (visited[y][x]) return;

        visited[y][x] = true;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            dfs(ny, nx, day);
        }
    }
}
