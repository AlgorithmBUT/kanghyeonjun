package swea.D4.미로2;

import java.io.*;

public class Solution {

  static BufferedReader br;
  static char [][] board;
  static int sy, sx, ey, ex;

  static final int SIZE = 100;

  static int[] dy = {1,0,-1,0};
  static int[] dx = {0,1,0,-1};

  public static void main(String[] args) throws Exception {

    br = new BufferedReader(new InputStreamReader(System.in));

    for (int tc=1; tc<=10; tc++) {
      br.readLine();

      board = new char[SIZE][SIZE];

      for (int i=0; i<SIZE; i++){
        board[i] = br.readLine().toCharArray();
        for (int j=0; j<SIZE; j++){
          if (board[i][j]=='2'){
            sy=i;
            sx=j;
          }

          if (board[i][j]=='3'){
            ey=i;
            ex=j;
          }
        }
      }

      dfs(1,1);

      int res = 0;
      if (board[ey][ex]=='1') res=1;

      StringBuilder ans = new StringBuilder();
      ans.append("#").append(tc).append(" ").append(res);

      System.out.println(ans);
    }
  }

  static void dfs(int y, int x){
    if (y<0 || y>= SIZE || x<0 || x>=SIZE) return;
    if (board[y][x]=='1') return;

    board[y][x] = '1';

    for (int d=0; d<4; d++){
      int ny = y + dy[d];
      int nx = x + dx[d];

      dfs(ny, nx);
    }
  }
}
