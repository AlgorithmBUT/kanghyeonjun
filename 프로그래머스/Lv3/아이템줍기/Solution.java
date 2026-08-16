package 프로그래머스.Lv3.아이템줍기;

import java.util.*;

class Solution {

    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        int [][] board = new int [102][102];
        Deque<Point> dq = new ArrayDeque<>();

        // 2배 테두리 그리기
        for (int [] tmp : rectangle){
            int sx = tmp[0];
            int sy = tmp[1];
            int ex = tmp[2];
            int ey = tmp[3];

            // 테두리: -2, 내부: -1
            // 이미 -1이면 테두리 기록 X
            for (int y=sy*2; y<=ey*2; y++){
                for (int x=sx*2; x<=ex*2; x++){
                    if (y==sy*2 || x==sx*2 || y==ey*2 || x==ex*2){
                        if (board[y][x]==-1){
                            continue;
                        } else{
                            board[y][x]=-2;
                        }
                    } else {
                        board[y][x]=-1;
                    }
                }
            }
        }

        // bfs
        dq.offer(new Point(characterY*2, characterX*2));
        board[characterY*2][characterX*2]=0;

        while (dq.size()!=0){
            Point cur = dq.pollFirst();

            if (cur.y==itemY*2 && cur.x==itemX*2){
                answer=board[cur.y][cur.x]/2;
                break;
            }

            for (int d=0; d<4; d++){
                int ny = cur.y+dy[d];
                int nx = cur.x+dx[d];

                if (check(ny,nx,board)){
                    if (board[ny][nx]==-2){
                        dq.offerLast(new Point(ny, nx));
                        board[ny][nx]=board[cur.y][cur.x]+1;
                    }
                }
            }
        }
        
        return answer;
    }

    static boolean check (int y, int x, int[][] board){
        if (y<0 || y>= board.length || x<0 || x>=board[0].length || board[y][x]==-1 || board[y][x]==0){
            return false;
        }
        return true;
    }
}

class Point {
    int y;
    int x;

    public Point (int y, int x){
        this.y=y;
        this.x=x;
    }
}
