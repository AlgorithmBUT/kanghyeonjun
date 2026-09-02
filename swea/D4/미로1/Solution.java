package swea.D4.미로1;

import java.util.*;
import java.io.*;

public class Solution {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] board;
  static int[] dy = {-1,0,1,0};
  static int[] dx = {0,1,0,-1};

  static class Point{
    int y;
    int x;
    public Point(int y, int x){
      this.y=y;
      this.x=x;
    }
  }

  public static void main(String[] args) throws Exception {
    for (int tc=1; tc<=10; tc++){
      int T = Integer.parseInt(br.readLine());

      StringBuilder ans = new StringBuilder();

      board = new int [16][16];

      for (int i=0; i<16; i++){
        String line = br.readLine();

        for (int j=0; j<16; j++){
          board[i][j] = line.charAt(j) -'0';
        }
      }

      ans.append("#").append(T).append(" ").append(bfs());

      System.out.println(ans);
    }
  }

  static int bfs(){
    int [][] visited = new int[board.length][board.length];
    Deque<Point> dq = new ArrayDeque<>();

    int sX=0, sY=0, eX=0, eY=0;

    for (int i=0; i<board.length; i++){
      for (int j=0; j<board.length; j++){
        if (board[i][j]==2){
          sY=i;
          sX=j;
        }
        if (board[i][j]==3){
          eY=i;
          eX=j;
        }
      }
    }

    dq.offer(new Point(sY, sX));
    visited[sY][sX]=1;

    while(!dq.isEmpty()){
      Point cur = dq.pollFirst();

      for (int d=0; d<4; d++){
        
        int ny=cur.y+dy[d];
        int nx=cur.x+dx[d];  

        if (check(ny,nx,visited)){
          dq.offer(new Point(ny, nx));
          visited[ny][nx]=1;
        }
      }
    }

    return visited[eY][eX]==1? 1:0;

  }

  static boolean check(int y, int x, int[][] visited){
    if (y<0 || y>=board.length || x<0 || x>=board.length || board[y][x]==1 || visited[y][x]==1){
      return false;
    }
    return true;
  }
}