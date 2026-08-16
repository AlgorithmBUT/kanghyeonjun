package 프로그래머스.Lv2.미로탈출;

import java.util.*;

class Solution {

    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};

    public int solution(String[] maps) {

        char[][] board = new char[maps.length][maps[0].length()];

        Point start = null;
        Point lever = null;
        Point goal = null;

        for (int i=0; i<maps.length; i++){
            board[i] = maps[i].toCharArray();

            for (int j=0; j<maps[i].length(); j++){
                if (board[i][j]=='S'){
                    start = new Point(i,j);
                } else if (board[i][j]=='L'){
                    lever = new Point(i,j);
                } else if (board[i][j]=='E'){
                    goal = new Point(i,j);
                }
            }
        }

        int first = bfs(start, lever, board);

        if (first==-1){
            return -1;
        }

        int second = bfs(lever, goal, board);

        if (second==-1){
            return -1;
        }

        return first+second;
    }

    static int bfs(Point start, Point goal, char[][] board){

        int[][] visited = new int[board.length][board[0].length];

        for (int i=0; i<visited.length; i++){
            Arrays.fill(visited[i], -1);
        }

        Deque<Point> dq = new ArrayDeque<>();

        dq.offerLast(start);
        visited[start.y][start.x] = 0;

        while (dq.size()!=0){

            Point cur = dq.pollFirst();

            if (cur.y==goal.y && cur.x==goal.x){
                return visited[cur.y][cur.x];
            }

            for (int d=0; d<4; d++){
                int ny = cur.y+dy[d];
                int nx = cur.x+dx[d];

                if (check(ny, nx, board, visited)){
                    dq.offerLast(new Point(ny,nx));
                    visited[ny][nx] = visited[cur.y][cur.x]+1;
                }
            }
        }

        return -1;
    }

    static boolean check(int y, int x, char[][] board, int[][] visited){

        if (y<0 || y>=board.length || x<0 || x>=board[0].length || board[y][x]=='X' || visited[y][x]!=-1){
            return false;
        }
        return true;
    }
}

class Point {
    
    int y;
    int x;

    public Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}