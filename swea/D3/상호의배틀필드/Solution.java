import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br;
    static StringTokenizer st;

    static char[][] board;

    static int H;
    static int W;

    static int y;
    static int x;
    static int dir;

    // 상 우 하 좌
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            board = new char[H][W];

            // 맵 입력 + 탱크 위치, 방향 찾기
            for (int i = 0; i < H; i++) {
                board[i] = br.readLine().toCharArray();

                for (int j = 0; j < W; j++) {

                    if (board[i][j] == '^') {
                        y = i;
                        x = j;
                        dir = 0;
                    } else if (board[i][j] == '>') {
                        y = i;
                        x = j;
                        dir = 1;
                    } else if (board[i][j] == 'v') {
                        y = i;
                        x = j;
                        dir = 2;
                    } else if (board[i][j] == '<') {
                        y = i;
                        x = j;
                        dir = 3;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            char[] order = br.readLine().toCharArray();

            for (int i = 0; i < N; i++) {

                char command = order[i];

                if (command == 'S') {
                    shoot();
                    continue;
                }

                // 방향 변경
                switch (command) {
                    case 'U':
                        dir = 0;
                        board[y][x] = '^';
                        break;

                    case 'R':
                        dir = 1;
                        board[y][x] = '>';
                        break;

                    case 'D':
                        dir = 2;
                        board[y][x] = 'v';
                        break;

                    case 'L':
                        dir = 3;
                        board[y][x] = '<';
                        break;
                }

                // 다음 위치
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                // 평지라면 이동
                if (checkArr(ny, nx) && board[ny][nx] == '.') {

                    char tank = board[y][x];

                    board[y][x] = '.';

                    y = ny;
                    x = nx;

                    board[y][x] = tank;
                }
            }

            StringBuilder sb = new StringBuilder();

            sb.append("#").append(tc).append(" ");

            for (int i = 0; i < H; i++) {
                sb.append(board[i]).append("\n");
            }

            System.out.print(sb);
        }
    }

    static boolean checkArr(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }

    static void shoot() {

        int sy = y;
        int sx = x;

        while (true) {

            sy += dy[dir];
            sx += dx[dir];

            if (!checkArr(sy, sx)) {
                break;
            }

            if (board[sy][sx] == '#') {
                break;
            }

            if (board[sy][sx] == '*') {
                board[sy][sx] = '.';
                break;
            }
        }
    }
}