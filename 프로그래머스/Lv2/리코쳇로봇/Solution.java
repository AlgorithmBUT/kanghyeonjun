package 프로그래머스.Lv2.리코쳇로봇;

import java.util.*;

class Solution {

    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};

    public int solution(String[] board) {
        
        int [][] visited = new int[board.length][board[0].length()];
        for (int i=0; i<visited.length; i++){
            Arrays.fill(visited[i], -1);
        }

        Deque<Point> dq = new ArrayDeque<>();
        int goaly=0, goalx=0;
        char realboard[][] = new char[board.length][];

        // board -> char로 바꾸면서 'R', 'G' 위치 기록
        for (int i =0; i< board.length; i++){
            realboard[i]=board[i].toCharArray();
            if (board[i].contains("R")){
                int tmp = board[i].indexOf('R');
                dq.offer(new Point(i, tmp));
                visited[i][tmp]=0;
            }
            if (board[i].contains("G")){
                goaly=i;
                goalx=board[i].indexOf('G');
            }
        }

        // bfs 시작
        while (dq.size()!=0){
            
            Point cur = dq.pollFirst();

            // 4방향 탐색
            for (int d=0; d<4; d++){
                int ny = cur.y+dy[d];
                int nx = cur.x+dx[d];
                // 갈 수 있다면
                if (check (ny,nx,realboard,visited)){
                    // 그 방향으로 쭉 가기
                    while (check (ny,nx,realboard,visited)){
                        ny=ny+dy[d];
                        nx=nx+dx[d];
                    }
                }
                // 한 칸 뒤로
                ny=ny-dy[d];
                nx=nx-dx[d];
                // 방문하지 않닸다면 최단 거리 갱신
                if (visited[ny][nx]==-1){
                    dq.offerLast(new Point(ny,nx));
                    visited[ny][nx]=visited[cur.y][cur.x]+1;
                }
            }
        }

        return visited[goaly][goalx];
    }

    static boolean check (int y, int x, char[][] board, int[][]visited){
        if (y<0 || y>=visited.length || x<0 || x>=visited[0].length || board[y][x]=='D'){
            return false;
        }
        return true;
    }
}

class Point{
    int y;
    int x;

    public Point(int y, int x){
        this.y=y;
        this.x=x;
    }
}
