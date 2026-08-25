package codetree.아기고래의첫항해;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 위를 기준으로 시계 방향
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int NN;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine().toString());
        int N = Integer.parseInt(st.nextToken()); 
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        NN=N;

        int[][] board = new int [N][N];

        for (int i=0; i<N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine().toString());
            for (int j=0; j<N; j++){
                board[i][j]=Integer.parseInt(st2.nextToken());
            }
        }

        // 문제에서는 1.상 2.하 3.좌 4.우
        // 하지만 dy, dx의 index 기준으로 바꿔줘야 함 (1=상 2=우 3=하 4=좌)
        int [] convert = {0, 2, 3, 1};
        d = convert[d-1];

        while (true){
            // 1. 인접 탐험
            int [] order = {d, (d+3)%4, (d+1)%4, (d+2)%4};
            boolean move = false;

            for (int dd =0; dd<4; dd++){
                int ny = r + dy[order[dd]];
                int nx = c + dx[order[dd]];

                if (check(ny,nx) && board[ny][nx]==0){
                    board[ny][nx]=-1;
                    r=ny;
                    c=nx;
                    d = order[dd];
                    move = true;
                    break;
                }
            }

            // 2. 바다 이동
            if (!move){
                Deque<Point> dq = new ArrayDeque<>();
                
            }
        }

    }

    static boolean check (int y, int x){
        if (y<0 || y>=NN || x<0 || x>=NN){
            return false;
        }
        return true;
    }
}

class Point {
    int y;
    int x;

    public Point(int y, int x){
        this.y=y;
        this.x=x;
    }
}
